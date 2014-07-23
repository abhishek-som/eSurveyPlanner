package com.esp.entity;
// Generated Jul 18, 2014 3:06:38 PM by Hibernate Tools 3.6.0



import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Answermaster generated by hbm2java
 */
@Entity
@Table(name="ANSWERMASTER"
    ,schema="SURVEY"
)
public class Answermaster  implements java.io.Serializable {


     private Integer ansid;
     private Answerdescriptionmaster answerdescriptionmasterByAnsdescid6;
     private Answerdescriptionmaster answerdescriptionmasterByAnsdescid7;
     private Answerdescriptionmaster answerdescriptionmasterByAnsdescid8;
     private Answerdescriptionmaster answerdescriptionmasterByAnsdescid9;
     private Answerdescriptionmaster answerdescriptionmasterByAnsdescid2;
     private Answerdescriptionmaster answerdescriptionmasterByAnsdescid3;
     private Answerdescriptionmaster answerdescriptionmasterByAnsdescid4;
     private Answerdescriptionmaster answerdescriptionmasterByAnsdescid5;
     private Answerdescriptionmaster answerdescriptionmasterByAnsdescid10;
     private Answerdescriptionmaster answerdescriptionmasterByAnsdescid1;
     private Set<Questionanswermapping> questionanswermappings = new HashSet<Questionanswermapping>(0);

    public Answermaster() {
    }

	
    public Answermaster(Integer ansid) {
        this.ansid = ansid;
    }
    public Answermaster(Integer ansid, Answerdescriptionmaster answerdescriptionmasterByAnsdescid6, Answerdescriptionmaster answerdescriptionmasterByAnsdescid7, Answerdescriptionmaster answerdescriptionmasterByAnsdescid8, Answerdescriptionmaster answerdescriptionmasterByAnsdescid9, Answerdescriptionmaster answerdescriptionmasterByAnsdescid2, Answerdescriptionmaster answerdescriptionmasterByAnsdescid3, Answerdescriptionmaster answerdescriptionmasterByAnsdescid4, Answerdescriptionmaster answerdescriptionmasterByAnsdescid5, Answerdescriptionmaster answerdescriptionmasterByAnsdescid10, Answerdescriptionmaster answerdescriptionmasterByAnsdescid1, Set<Questionanswermapping> questionanswermappings) {
       this.ansid = ansid;
       this.answerdescriptionmasterByAnsdescid6 = answerdescriptionmasterByAnsdescid6;
       this.answerdescriptionmasterByAnsdescid7 = answerdescriptionmasterByAnsdescid7;
       this.answerdescriptionmasterByAnsdescid8 = answerdescriptionmasterByAnsdescid8;
       this.answerdescriptionmasterByAnsdescid9 = answerdescriptionmasterByAnsdescid9;
       this.answerdescriptionmasterByAnsdescid2 = answerdescriptionmasterByAnsdescid2;
       this.answerdescriptionmasterByAnsdescid3 = answerdescriptionmasterByAnsdescid3;
       this.answerdescriptionmasterByAnsdescid4 = answerdescriptionmasterByAnsdescid4;
       this.answerdescriptionmasterByAnsdescid5 = answerdescriptionmasterByAnsdescid5;
       this.answerdescriptionmasterByAnsdescid10 = answerdescriptionmasterByAnsdescid10;
       this.answerdescriptionmasterByAnsdescid1 = answerdescriptionmasterByAnsdescid1;
       this.questionanswermappings = questionanswermappings;
    }
   
     @Id 

    
    @Column(name="ANSID", unique=true, nullable=false, precision=22, scale=0)
    public Integer getAnsid() {
        return this.ansid;
    }
    
    public void setAnsid(Integer ansid) {
        this.ansid = ansid;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSDESCID6")
    public Answerdescriptionmaster getAnswerdescriptionmasterByAnsdescid6() {
        return this.answerdescriptionmasterByAnsdescid6;
    }
    
    public void setAnswerdescriptionmasterByAnsdescid6(Answerdescriptionmaster answerdescriptionmasterByAnsdescid6) {
        this.answerdescriptionmasterByAnsdescid6 = answerdescriptionmasterByAnsdescid6;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSDESCID7")
    public Answerdescriptionmaster getAnswerdescriptionmasterByAnsdescid7() {
        return this.answerdescriptionmasterByAnsdescid7;
    }
    
    public void setAnswerdescriptionmasterByAnsdescid7(Answerdescriptionmaster answerdescriptionmasterByAnsdescid7) {
        this.answerdescriptionmasterByAnsdescid7 = answerdescriptionmasterByAnsdescid7;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSDESCID8")
    public Answerdescriptionmaster getAnswerdescriptionmasterByAnsdescid8() {
        return this.answerdescriptionmasterByAnsdescid8;
    }
    
    public void setAnswerdescriptionmasterByAnsdescid8(Answerdescriptionmaster answerdescriptionmasterByAnsdescid8) {
        this.answerdescriptionmasterByAnsdescid8 = answerdescriptionmasterByAnsdescid8;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSDESCID9")
    public Answerdescriptionmaster getAnswerdescriptionmasterByAnsdescid9() {
        return this.answerdescriptionmasterByAnsdescid9;
    }
    
    public void setAnswerdescriptionmasterByAnsdescid9(Answerdescriptionmaster answerdescriptionmasterByAnsdescid9) {
        this.answerdescriptionmasterByAnsdescid9 = answerdescriptionmasterByAnsdescid9;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSDESCID2")
    public Answerdescriptionmaster getAnswerdescriptionmasterByAnsdescid2() {
        return this.answerdescriptionmasterByAnsdescid2;
    }
    
    public void setAnswerdescriptionmasterByAnsdescid2(Answerdescriptionmaster answerdescriptionmasterByAnsdescid2) {
        this.answerdescriptionmasterByAnsdescid2 = answerdescriptionmasterByAnsdescid2;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSDESCID3")
    public Answerdescriptionmaster getAnswerdescriptionmasterByAnsdescid3() {
        return this.answerdescriptionmasterByAnsdescid3;
    }
    
    public void setAnswerdescriptionmasterByAnsdescid3(Answerdescriptionmaster answerdescriptionmasterByAnsdescid3) {
        this.answerdescriptionmasterByAnsdescid3 = answerdescriptionmasterByAnsdescid3;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSDESCID4")
    public Answerdescriptionmaster getAnswerdescriptionmasterByAnsdescid4() {
        return this.answerdescriptionmasterByAnsdescid4;
    }
    
    public void setAnswerdescriptionmasterByAnsdescid4(Answerdescriptionmaster answerdescriptionmasterByAnsdescid4) {
        this.answerdescriptionmasterByAnsdescid4 = answerdescriptionmasterByAnsdescid4;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSDESCID5")
    public Answerdescriptionmaster getAnswerdescriptionmasterByAnsdescid5() {
        return this.answerdescriptionmasterByAnsdescid5;
    }
    
    public void setAnswerdescriptionmasterByAnsdescid5(Answerdescriptionmaster answerdescriptionmasterByAnsdescid5) {
        this.answerdescriptionmasterByAnsdescid5 = answerdescriptionmasterByAnsdescid5;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSDESCID10")
    public Answerdescriptionmaster getAnswerdescriptionmasterByAnsdescid10() {
        return this.answerdescriptionmasterByAnsdescid10;
    }
    
    public void setAnswerdescriptionmasterByAnsdescid10(Answerdescriptionmaster answerdescriptionmasterByAnsdescid10) {
        this.answerdescriptionmasterByAnsdescid10 = answerdescriptionmasterByAnsdescid10;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ANSDESCID1")
    public Answerdescriptionmaster getAnswerdescriptionmasterByAnsdescid1() {
        return this.answerdescriptionmasterByAnsdescid1;
    }
    
    public void setAnswerdescriptionmasterByAnsdescid1(Answerdescriptionmaster answerdescriptionmasterByAnsdescid1) {
        this.answerdescriptionmasterByAnsdescid1 = answerdescriptionmasterByAnsdescid1;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="answermaster")
    public Set<Questionanswermapping> getQuestionanswermappings() {
        return this.questionanswermappings;
    }
    
    public void setQuestionanswermappings(Set<Questionanswermapping> questionanswermappings) {
        this.questionanswermappings = questionanswermappings;
    }




}


