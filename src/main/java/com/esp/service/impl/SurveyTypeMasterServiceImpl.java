/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esp.service.impl;

import com.esp.dao.SurveyTypeMasterDAO;
import com.esp.entity.Surveytypemaster;
import com.esp.service.SurveyTypeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rakesh.k
 */
@Service
public class SurveyTypeMasterServiceImpl implements SurveyTypeMasterService{

    @Autowired
    private SurveyTypeMasterDAO surveyTypeMasterDAO;
    
    @Transactional
    @Override
    public Surveytypemaster getSurveyTypeMaster(String type) {
        
        return surveyTypeMasterDAO.findUnique(Surveytypemaster.class, "surveytype", type);
    }
    
    
    
}