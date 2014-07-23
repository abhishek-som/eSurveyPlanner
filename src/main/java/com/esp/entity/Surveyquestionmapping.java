package com.esp.entity;
// Generated Jul 18, 2014 3:06:38 PM by Hibernate Tools 3.6.0


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Surveyquestionmapping generated by hbm2java
 */
@Entity
@Table(name="SURVEYQUESTIONMAPPING"
    ,schema="SURVEY"
)
public class Surveyquestionmapping  implements java.io.Serializable {


     private SurveyquestionmappingId id;

    public Surveyquestionmapping() {
    }

    public Surveyquestionmapping(SurveyquestionmappingId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="surveyid", column=@Column(name="SURVEYID", nullable=false, precision=22, scale=0) ), 
        @AttributeOverride(name="questionid", column=@Column(name="QUESTIONID", nullable=false, precision=22, scale=0) ) } )
    public SurveyquestionmappingId getId() {
        return this.id;
    }
    
    public void setId(SurveyquestionmappingId id) {
        this.id = id;
    }




}


