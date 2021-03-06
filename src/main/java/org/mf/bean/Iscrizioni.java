/*
 * Created on 29 lug 2016 ( Time 14:37:00 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.mf.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Iscrizioni implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    private Integer torneoId;

    @NotNull
    private Integer societaId;

    @NotNull
    private Integer categorieId;

    @NotNull
    private Integer nrteam;


    private Integer nrplayer;

    @NotNull
    private Date created;

    @Size( max = 45 )
    private String accompagnatore;

    @NotNull
    private Long createdby;


    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }

    public Integer getId() {
        return this.id;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setTorneoId( Integer torneoId ) {
        this.torneoId = torneoId;
    }
    public Integer getTorneoId() {
        return this.torneoId;
    }
    public void setSocietaId( Integer societaId ) {
        this.societaId = societaId;
    }
    public Integer getSocietaId() {
        return this.societaId;
    }
    public void setCategorieId( Integer categorieId ) {
        this.categorieId = categorieId;
    }
    public Integer getCategorieId() {
        return this.categorieId;
    }
    public void setNrteam( Integer nrteam ) {
        this.nrteam = nrteam;
    }
    public Integer getNrteam() {
        return this.nrteam;
    }
    public void setNrplayer( Integer nrplayer ) {
        this.nrplayer = nrplayer;
    }
    public Integer getNrplayer() {
        return this.nrplayer;
    }
    public void setCreated( Date created ) {
        this.created = created;
    }
    public Date getCreated() {
        return this.created;
    }
    public void setAccompagnatore( String accompagnatore ) {
        this.accompagnatore = accompagnatore;
    }
    public String getAccompagnatore() {
        return this.accompagnatore;
    }
    public void setCreatedby( Long createdby ) {
        this.createdby = createdby;
    }
    public Long getCreatedby() {
        return this.createdby;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(torneoId);
        sb.append("|");
        sb.append(societaId);
        sb.append("|");
        sb.append(categorieId);
        sb.append("|");
        sb.append(nrteam);
        sb.append("|");
        sb.append(nrplayer);
        sb.append("|");
        sb.append(created);
        sb.append("|");
        sb.append(accompagnatore);
        sb.append("|");
        sb.append(createdby);
        return sb.toString(); 
    } 

}
