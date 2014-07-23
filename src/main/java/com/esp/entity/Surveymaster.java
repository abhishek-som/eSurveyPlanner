package com.esp.entity;
// Generated Jul 18, 2014 3:06:38 PM by Hibernate Tools 3.6.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Surveymaster generated by hbm2java
 */
@Entity
@Table(name = "SURVEYMASTER", schema = "SURVEY"
)
public class Surveymaster implements java.io.Serializable {

    private Integer surveyid;
    private Usermaster usermasterByCreatedbyid;
    private Usermaster usermasterByLastmodifiedbyid;
    private Surveytypemaster surveytypemaster;
    private String surveycategory;
    private String createdbyname;
    private Date createddate;
    private Date lastmodifieddate;
    private String lastmodifiedbyname;
    private Date startdate;
    private Date enddate;
    private String surveyName;
    private String surveyDesc;

    public Surveymaster() {
    }

    public Surveymaster(Integer surveyid) {
        this.surveyid = surveyid;
    }

    public Surveymaster(Integer surveyid, Usermaster usermasterByCreatedbyid, Usermaster usermasterByLastmodifiedbyid, Surveytypemaster surveytypemaster, String surveycategory, String createdbyname, Date createddate, Date lastmodifieddate, String lastmodifiedbyname, Date startdate, Date enddate,String surveyName,String surveyDesc) {
        this.surveyid = surveyid;
        this.usermasterByCreatedbyid = usermasterByCreatedbyid;
        this.usermasterByLastmodifiedbyid = usermasterByLastmodifiedbyid;
        this.surveytypemaster = surveytypemaster;
        this.surveycategory = surveycategory;
        this.createdbyname = createdbyname;
        this.createddate = createddate;
        this.lastmodifieddate = lastmodifieddate;
        this.lastmodifiedbyname = lastmodifiedbyname;
        this.startdate = startdate;
        this.enddate = enddate;
        this.surveyName = surveyName;
        this.surveyDesc = surveyDesc;
    }

    @Id

    @SequenceGenerator(name = "SEQ_SURVEY_MASTER", sequenceName = "SEQ_SURVEY_MASTER")
    @GeneratedValue(generator = "SEQ_SURVEY_MASTER", strategy = GenerationType.SEQUENCE)
    @Column(name = "SURVEYID", unique = true, nullable = false, precision = 22, scale = 0)
    public Integer getSurveyid() {
        return this.surveyid;
    }

    public void setSurveyid(Integer surveyid) {
        this.surveyid = surveyid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATEDBYID")
    public Usermaster getUsermasterByCreatedbyid() {
        return this.usermasterByCreatedbyid;
    }

    public void setUsermasterByCreatedbyid(Usermaster usermasterByCreatedbyid) {
        this.usermasterByCreatedbyid = usermasterByCreatedbyid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LASTMODIFIEDBYID")
    public Usermaster getUsermasterByLastmodifiedbyid() {
        return this.usermasterByLastmodifiedbyid;
    }

    public void setUsermasterByLastmodifiedbyid(Usermaster usermasterByLastmodifiedbyid) {
        this.usermasterByLastmodifiedbyid = usermasterByLastmodifiedbyid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SURVEYTYPEID")
    public Surveytypemaster getSurveytypemaster() {
        return this.surveytypemaster;
    }

    public void setSurveytypemaster(Surveytypemaster surveytypemaster) {
        this.surveytypemaster = surveytypemaster;
    }

    @Column(name = "SURVEYCATEGORY", length = 200)
    public String getSurveycategory() {
        return this.surveycategory;
    }

    public void setSurveycategory(String surveycategory) {
        this.surveycategory = surveycategory;
    }

    @Column(name = "CREATEDBYNAME", length = 200)
    public String getCreatedbyname() {
        return this.createdbyname;
    }

    public void setCreatedbyname(String createdbyname) {
        this.createdbyname = createdbyname;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATEDDATE", length = 7)
    public Date getCreateddate() {
        return this.createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "LASTMODIFIEDDATE", length = 7)
    public Date getLastmodifieddate() {
        return this.lastmodifieddate;
    }

    public void setLastmodifieddate(Date lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    @Column(name = "LASTMODIFIEDBYNAME", length = 200)
    public String getLastmodifiedbyname() {
        return this.lastmodifiedbyname;
    }

    public void setLastmodifiedbyname(String lastmodifiedbyname) {
        this.lastmodifiedbyname = lastmodifiedbyname;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "STARTDATE", length = 7)
    public Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "ENDDATE", length = 7)
    public Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Column(name="SURVEYNAME",length = 200)
    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    @Column(name="SURVEYDESC",length = 250)
    public String getSurveyDesc() {
        return surveyDesc;
    }

    public void setSurveyDesc(String surveyDesc) {
        this.surveyDesc = surveyDesc;
    }
    
    
    
    

}
