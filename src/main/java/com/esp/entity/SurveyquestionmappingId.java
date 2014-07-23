package com.esp.entity;
// Generated Jul 18, 2014 3:06:38 PM by Hibernate Tools 3.6.0



import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SurveyquestionmappingId generated by hbm2java
 */
@Embeddable
public class SurveyquestionmappingId  implements java.io.Serializable {


     private Integer surveyid;
     private Integer questionid;

    public SurveyquestionmappingId() {
    }

    public SurveyquestionmappingId(Integer surveyid, Integer questionid) {
       this.surveyid = surveyid;
       this.questionid = questionid;
    }
   


    @Column(name="SURVEYID", nullable=false, precision=22, scale=0)
    public Integer getSurveyid() {
        return this.surveyid;
    }
    
    public void setSurveyid(Integer surveyid) {
        this.surveyid = surveyid;
    }


    @Column(name="QUESTIONID", nullable=false, precision=22, scale=0)
    public Integer getQuestionid() {
        return this.questionid;
    }
    
    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SurveyquestionmappingId) ) return false;
		 SurveyquestionmappingId castOther = ( SurveyquestionmappingId ) other; 
         
		 return ( (this.getSurveyid()==castOther.getSurveyid()) || ( this.getSurveyid()!=null && castOther.getSurveyid()!=null && this.getSurveyid().equals(castOther.getSurveyid()) ) )
 && ( (this.getQuestionid()==castOther.getQuestionid()) || ( this.getQuestionid()!=null && castOther.getQuestionid()!=null && this.getQuestionid().equals(castOther.getQuestionid()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSurveyid() == null ? 0 : this.getSurveyid().hashCode() );
         result = 37 * result + ( getQuestionid() == null ? 0 : this.getQuestionid().hashCode() );
         return result;
   }   


}

