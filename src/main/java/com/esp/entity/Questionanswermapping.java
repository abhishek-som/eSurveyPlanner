package com.esp.entity;
// Generated Jul 18, 2014 3:06:38 PM by Hibernate Tools 3.6.0



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Questionanswermapping generated by hbm2java
 */
@Entity
@Table(name="QUESTIONANSWERMAPPING"
    ,schema="SURVEY"
)
public class Questionanswermapping  implements java.io.Serializable {


     private Integer quesansmappingid;
     private Usermaster usermasterByCreatedbyid;
     private Usermaster usermasterByLastmodifiedbyid;
     private Questionmaster questionmaster;
     private Answertypemaster answertypemaster;
     private Answermaster answermaster;
     private String createdbyname;
     private Date createddate;
     private Date lastmodifieddate;
     private String lastmodifiedbyname;

    public Questionanswermapping() {
    }

	
    public Questionanswermapping(Integer quesansmappingid) {
        this.quesansmappingid = quesansmappingid;
    }
    public Questionanswermapping(Integer quesansmappingid, Usermaster usermasterByCreatedbyid, Usermaster usermasterByLastmodifiedbyid, Questionmaster questionmaster, Answertypemaster answertypemaster, Answermaster answermaster, String createdbyname, Date createddate, Date lastmodifieddate, String lastmodifiedbyname) {
       this.quesansmappingid = quesansmappingid;
       this.usermasterByCreatedbyid = usermasterByCreatedbyid;
       this.usermasterByLastmodifiedbyid = usermasterByLastmodifiedbyid;
       this.questionmaster = questionmaster;
       this.answertypemaster = answertypemaster;
       this.answermaster = answermaster;
       this.createdbyname = createdbyname;
       this.createddate = createddate;
       this.lastmodifieddate = lastmodifieddate;
       this.lastmodifiedbyname = lastmodifiedbyname;
    }
   
     @Id 

    
    @Column(name="QUESANSMAPPINGID", unique=true, nullable=false, precision=22, scale=0)
    public Integer getQuesansmappingid() {
        return this.quesansmappingid;
    }
    
    public void setQuesansmappingid(Integer quesansmappingid) {
        this.quesansmappingid = quesansmappingid;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CREATEDBYID")
    public Usermaster getUsermasterByCreatedbyid() {
        return this.usermasterByCreatedbyid;
    }
    
    public void setUsermasterByCreatedbyid(Usermaster usermasterByCreatedbyid) {
        this.usermasterByCreatedbyid = usermasterByCreatedbyid;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LASTMODIFIEDBYID")
    public Usermaster getUsermasterByLastmodifiedbyid() {
        return this.usermasterByLastmodifiedbyid;
    }
    
    public void setUsermasterByLastmodifiedbyid(Usermaster usermasterByLastmodifiedbyid) {
        this.usermasterByLastmodifiedbyid = usermasterByLastmodifiedbyid;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="QUESTIONID")
    public Questionmaster getQuestionmaster() {
        return this.questionmaster;
    }
    
    public void setQuestionmaster(Questionmaster questionmaster) {
        this.questionmaster = questionmaster;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSTYPEMASTERID")
    public Answertypemaster getAnswertypemaster() {
        return this.answertypemaster;
    }
    
    public void setAnswertypemaster(Answertypemaster answertypemaster) {
        this.answertypemaster = answertypemaster;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSWERID")
    public Answermaster getAnswermaster() {
        return this.answermaster;
    }
    
    public void setAnswermaster(Answermaster answermaster) {
        this.answermaster = answermaster;
    }

    
    @Column(name="CREATEDBYNAME", length=200)
    public String getCreatedbyname() {
        return this.createdbyname;
    }
    
    public void setCreatedbyname(String createdbyname) {
        this.createdbyname = createdbyname;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="CREATEDDATE", length=7)
    public Date getCreateddate() {
        return this.createddate;
    }
    
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="LASTMODIFIEDDATE", length=7)
    public Date getLastmodifieddate() {
        return this.lastmodifieddate;
    }
    
    public void setLastmodifieddate(Date lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    
    @Column(name="LASTMODIFIEDBYNAME", length=200)
    public String getLastmodifiedbyname() {
        return this.lastmodifiedbyname;
    }
    
    public void setLastmodifiedbyname(String lastmodifiedbyname) {
        this.lastmodifiedbyname = lastmodifiedbyname;
    }




}


