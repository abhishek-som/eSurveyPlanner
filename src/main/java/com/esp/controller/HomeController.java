package com.esp.controller;

import com.esp.entity.AnswerMaster;
import com.esp.entity.AnswerTypeMaster;
import com.esp.entity.SurveyMaster;
import com.esp.entity.SurveyQuestionMapping;
import com.esp.entity.SurveyTypeMaster;
import com.esp.entity.UserMaster;
import com.esp.handler.HomeHandler;
import com.esp.service.GenericService;
import com.esp.dto.ElementDTO;
import com.esp.dto.FixedSurveyAnswersDTO;
import com.esp.dto.FixedSurveyQuestionsDTO;
import com.esp.dto.SurveyDetailsDTO;
import com.esp.dto.SurveyDTO;
import com.esp.dto.SurveyQuestionDTO;
import com.esp.dto.SurveyResponseDTO;
import com.esp.dto.SurveyUIDTO;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    @Qualifier("UserMasterService")
    private GenericService userMasterService;
    @Autowired
    @Qualifier("SurveyMasterService")
    private GenericService surveyMasterService;
    @Autowired
    @Qualifier("SurveyTypeMasterService")
    private GenericService surveyTypeMasterService;
    @Autowired
    @Qualifier("AnswerMasterService")
    private GenericService answerService;
    @Autowired
    @Qualifier("AnswerTypeMasterService")
    private GenericService answerTypeMasterService;
    @Autowired
    private HomeHandler handler;
    //for testing
    Integer userId = 100;
    private Logger log = Logger.getLogger(this.getClass().getName());


    @RequestMapping(value = "/home")
    public ModelAndView Home(Principal principal) throws IOException {

        log.info("logged in user :" + principal.getName());
        return new ModelAndView("home");

    }

    @RequestMapping(value = "")
    public ModelAndView HomePage(Principal principal) throws IOException {

        log.info("logged in user :" + principal.getName());
        return new ModelAndView("home");

    }

    @RequestMapping(value = "/createSurvey")
    public ModelAndView createSurvey(ModelMap model) throws Exception {
        log.info("Request for Creating Survey");

        List<ElementDTO> surveyTypes;

        surveyTypes = handler.fetchSurveyType();

        model.addAttribute("surveyTypes", surveyTypes);
        return new ModelAndView("createSurvey");
    }

    @RequestMapping(value = "/submitSurveyMaster")
    public ModelAndView submitSurvey(ModelMap model, @ModelAttribute("surveyDetailsDTO") SurveyDetailsDTO surveyDetailsDTO) throws IOException {

        try {
            log.info("Going to save Survey Master Details -");
            log.info("submitting survey to database");
            log.info("name :" + surveyDetailsDTO.getSurveyname());
            log.info("desc :" + surveyDetailsDTO.getDescription());
            log.info("type ;" + surveyDetailsDTO.getType());

            UserMaster usermaster = (UserMaster) userMasterService.fetch(BigDecimal.valueOf(userId));
            SurveyTypeMaster surveytypemaster = (SurveyTypeMaster) surveyTypeMasterService.fetch(BigDecimal.valueOf(surveyDetailsDTO.getType()));
            SurveyMaster surveymaster = handler.mapToSurveymaster(usermaster, surveytypemaster, surveyDetailsDTO);
            surveyMasterService.add(surveymaster);
            log.info("Survey Saved to database");

            log.info("getting answertype master list");

            List<AnswerTypeMaster> answermasters = answerTypeMasterService.fetchAll();

            log.info("Answertype master list fetched");

            SurveyDTO surveyDTO = new SurveyDTO();
            surveyDTO.setSurveyId(Integer.parseInt(surveymaster.getId().toString()));
            surveyDTO.setSurveyName(surveymaster.getSurveyName());
            log.info("SurveyVO is set");

            model.addAttribute("surveyDTO", surveyDTO);
            model.addAttribute("answerTypeMaster", answermasters);

            if (surveyDetailsDTO.getType() == 1) {

                return new ModelAndView("answerType");

            } else if (surveyDetailsDTO.getType() == 2) {

                return new ModelAndView("addQuestionAnswer");
            }


        } catch (ParseException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/addQuestions")
    public ModelAndView addQuestions(ModelMap model, @ModelAttribute("surveyDTO") SurveyDTO surveyDTO,
            @ModelAttribute("answerDetailsDTO") FixedSurveyAnswersDTO answerDetailsDTO) throws IOException {

        try {
            log.info("Going to save Answer Master details -");

            log.info("Going answerDetailsDTO.getAnsType()-" + answerDetailsDTO.getAnsTextList());

            AnswerMaster answerMaster = handler.mapToAnswerMaster(answerDetailsDTO);


            surveyDTO.setAnsId(Integer.parseInt(answerMaster.getId().toString()));
            log.info("survey name" + surveyDTO.getSurveyName());
            log.info("survey id" + surveyDTO.getSurveyId());
            log.info("survey ans id" + surveyDTO.getAnsId());
            log.info("survey ans type id" + surveyDTO.getAnsTypeID());
            log.info("survey answerDetailsDTO type id" + answerDetailsDTO.getAnsTypeId());
            surveyDTO.setAnsTypeID(answerDetailsDTO.getAnsTypeId());

            log.info("survey ans type id" + surveyDTO.getAnsTypeID());
            model.addAttribute("surveyDTO", surveyDTO);


            return new ModelAndView("addQuestions");
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "saveQuestions", method = RequestMethod.POST)
    public ModelAndView saveQuestions(ModelMap model, @ModelAttribute("questionDTO") FixedSurveyQuestionsDTO questionDTO, @ModelAttribute("surveyDTO") SurveyDTO surveyDTO) {
        ModelAndView modelAndView = new ModelAndView();

        log.info("--->survey id :" + surveyDTO.getSurveyId());
        log.info("--->survey ans id:" + surveyDTO.getAnsId());
        log.info("--->survey ansType id:" + surveyDTO.getAnsTypeID());
        log.info("--->survey question list size :" + questionDTO.getQuestionText().size());

        for (String question : questionDTO.getQuestionText()) {
            log.info("question :" + question);
        }

        UserMaster usermaster = (UserMaster) userMasterService.fetch(BigDecimal.valueOf(userId));
        //SurveyMaster surveymaster = (SurveyMaster) surveyMasterService.fetch(surveyDTO.getSurveyId());

        SurveyQuestionMapping surveyQuestionMapping = handler.mapToQuestionMaster(questionDTO, usermaster, surveyDTO);

        log.info("Survey question answers saved in - " + surveyQuestionMapping.getId());
        model.addAttribute("survey", surveyDTO);
        modelAndView.setViewName("thanksAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "saveQuestionAns", method = RequestMethod.POST)
    public ModelAndView submitSurveyResponse1(ModelMap model, @ModelAttribute("surveyResponseDTO") SurveyResponseDTO surveyResponseDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        System.out.println("-->>>>> surveyResponseDTO" + surveyResponseDTO);
        if (surveyResponseDTO != null) {

            System.out.println("-->>>>> surveyResponseDTO Survey Questions" + surveyResponseDTO.getSurveyQuestions());

            for (SurveyQuestionDTO q : surveyResponseDTO.getSurveyQuestions()) {
                System.out.println("-->>>>> q.getQuestionText()" + q.getQuestionText() + " -- " + q.getAnsTypeId());
                /*if (q.get getAnswers()!=null){
                System.out.println("-->>>>> q.getAnswers()"+q.getAnswers());
                for (ElementDTO	a:q.getAnswers()){
                System.out.println("-->>>>> a. ans text ()"+a.getText());

                }
                }*/

                /*if (q.getAnsIdList() !=null){
                System.out.println("-->>>>> q.getAnsIdList()"+q.getAnsIdList());
                for (AnswerDTO	a:q.getAnswers()){
                System.out.println("-->>>>> ans text "+a.getAnsText());

                }
                }*/

            }

        }

        //model.addAttribute("survey",surveyDTO);
        UserMaster usermaster = (UserMaster) userMasterService.fetch(BigDecimal.valueOf(userId));
        SurveyQuestionMapping surveyQuestionMapping = handler.saveQuestionAnswers(surveyResponseDTO, usermaster);

        //log.info("Survey question answers saved in - " + surveyQuestionMapping.getId());

        SurveyDTO surveyDTO = new SurveyDTO();
        surveyDTO.setSurveyId(surveyResponseDTO.getSurveyId());
        surveyDTO.setSurveyName(surveyResponseDTO.getSurveyName());

        model.addAttribute("survey", surveyDTO);
        modelAndView.setViewName("thanksAdmin");
        return modelAndView;

    }

    /**
     * This method is used to add two integers. This is
     * a the simplest form of a class method, just to
     * show the usage of various javadoc Tags.
     * @param numA This is the first paramter to addNum method
     * @param numB  This is the second parameter to addNum method
     * @return int This returns sum of numA and numB.
     */
    @RequestMapping(value = "/s/survey{uri}", method = RequestMethod.GET)
    public ModelAndView getPublishedSurvey(ModelMap model, @PathVariable(value = "uri") String uri) throws IOException {

        //String uri="8900";
        log.info("String here in getPublishedSurvey " + uri);
        
        SurveyUIDTO userSurveyDTO = handler.fetchSurveyDetails(Integer.parseInt(uri));

        //UserSurveyUrlMapping surveyUrlMapping = userSurveyUrlService.getUserSurveyURL(uri); 

        log.info("userSurveyDTO " + userSurveyDTO.getSurveyId() + userSurveyDTO.getSurveyName());
        log.info("userSurveyDTO " + userSurveyDTO.toString());
        model.addAttribute("survey", userSurveyDTO);
        return new ModelAndView("viewSurvey");
    }

    @RequestMapping(value = "/s/submitSurveyResponse", method = RequestMethod.POST)
    public ModelAndView submitSurveyResponse(ModelMap model, @ModelAttribute("surveyResponseDTO") SurveyResponseDTO surveyResponseDTO, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView modelAndView = new ModelAndView();
        String email = request.getParameter("email");

        if (email == null || email.equals("")) {
            throw new Exception("Email is null");

        }

        System.out.println("-->>>>> surveyResponseDTO" + surveyResponseDTO);
        if (surveyResponseDTO != null) {

            System.out.println("-->>>>> surveyResponseDTO Survey Questions" + surveyResponseDTO.getSurveyQuestions());

            for (SurveyQuestionDTO q : surveyResponseDTO.getSurveyQuestions()) {
                System.out.println("-->>>>> q.getQuestionId()" + q.getQuestionId());
                /*if (q.getAnswers()!=null){
                System.out.println("-->>>>> q.getAnswers()"+q.getAnswers());
                for (AnswerDTO	a:q.getAnswers()){
                System.out.println("-->>>>> a.getAnsId()"+a.getAnsId());

                }
                }*/

                if (q.getAnsTextList() != null) {
                    System.out.println("-->>>>> q.getAnsTextList()" + q.getAnsTextList());
                    for (String a : q.getAnsTextList()) {
                        System.out.println("-->>>>> ans text " + a);

                    }
                }

            }

        }


        UserMaster usermaster = (UserMaster) userMasterService.fetch(BigDecimal.valueOf(userId));
        handler.submitSurveyResponse(surveyResponseDTO, usermaster, request.getRemoteAddr(), email);
        /*System.out.println("----Addr: "+request.getRemoteAddr()+"----Host: " +request.getRemoteHost()+"----Port: " + request.getRemotePort()+"----User: " +request.getRemoteUser());
        //UserSurveyUrlMapping surveyUrlMapping = userSurveyUrlService.getUserSurveyURL(uri); 
        

        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        System.out.println("==1=>"+ip);
        ip = request.getHeader("Proxy-Client-IP");
        System.out.println("==2=>"+ip);
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("WL-Proxy-Client-IP");
        System.out.println("==3=>"+ip);
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getRemoteAddr();
        System.out.println("==4=>"+ip);
        }*/









        //log.info("userSurveyDTO "+userSurveyDTO.getSurveyId() + userSurveyDTO.getSurveyName());
        model.addAttribute("survey", surveyResponseDTO.getSurveyName());
        return new ModelAndView("thanksUser");
    }
}
