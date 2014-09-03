package com.esp.entity;
// Generated Jul 18, 2014 3:06:38 PM by Hibernate Tools 3.6.0



import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Organisation generated by hbm2java
 */
@Entity
@Table(name="ORGANISATION"
    ,schema="SURVEY"
)
public class Organisation  implements java.io.Serializable {


     private Integer orgid;
     private String orgname;
     private String orgregid;
     private Set<Userlist> userlists = new HashSet<Userlist>(0);

    public Organisation() {
    }

	
    public Organisation(Integer orgid) {
        this.orgid = orgid;
    }
    public Organisation(Integer orgid, String orgname, String orgregid, Set<Userlist> userlists) {
       this.orgid = orgid;
       this.orgname = orgname;
       this.orgregid = orgregid;
       this.userlists = userlists;
    }
   
     @Id 

    
    @Column(name="ORGID", unique=true, nullable=false, precision=22, scale=0)
    public Integer getOrgid() {
        return this.orgid;
    }
    
    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    
    @Column(name="ORGNAME", length=200)
    public String getOrgname() {
        return this.orgname;
    }
    
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    
    @Column(name="ORGREGID", length=100)
    public String getOrgregid() {
        return this.orgregid;
    }
    
    public void setOrgregid(String orgregid) {
        this.orgregid = orgregid;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="organisation")
    public Set<Userlist> getUserlists() {
        return this.userlists;
    }
    
    public void setUserlists(Set<Userlist> userlists) {
        this.userlists = userlists;
    }




}


