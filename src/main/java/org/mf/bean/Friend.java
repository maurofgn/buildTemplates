/*
 * Created on 29 lug 2016 ( Time 14:37:00 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.mf.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Friend implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    private Integer torneoId;


    private Date sentinvitation;

    @NotNull
    private Integer host;

    @NotNull
    private Integer guest;


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
    public void setSentinvitation( Date sentinvitation ) {
        this.sentinvitation = sentinvitation;
    }
    public Date getSentinvitation() {
        return this.sentinvitation;
    }
    public void setHost( Integer host ) {
        this.host = host;
    }
    public Integer getHost() {
        return this.host;
    }
    public void setGuest( Integer guest ) {
        this.guest = guest;
    }
    public Integer getGuest() {
        return this.guest;
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
        sb.append(sentinvitation);
        sb.append("|");
        sb.append(host);
        sb.append("|");
        sb.append(guest);
        return sb.toString(); 
    } 

}
