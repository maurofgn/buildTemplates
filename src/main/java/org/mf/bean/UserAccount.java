/*
 * Created on 29 lug 2016 ( Time 14:37:00 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.mf.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Long id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 255 )
    private String email;

    @NotNull
    private Boolean enabled;

    @Size( max = 255 )
    private String firstname;

    @Size( max = 255 )
    private String lastname;

    @Size( max = 60 )
    private String password;

    @NotNull
    private Integer attempt;


    private Date lastAccess;


    private Date lastChangePassword;

    @Size( max = 20 )
    private String state;


    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Long id ) {
        this.id = id ;
    }

    public Long getId() {
        return this.id;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEnabled( Boolean enabled ) {
        this.enabled = enabled;
    }
    public Boolean getEnabled() {
        return this.enabled;
    }
    public void setFirstname( String firstname ) {
        this.firstname = firstname;
    }
    public String getFirstname() {
        return this.firstname;
    }
    public void setLastname( String lastname ) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return this.lastname;
    }
    public void setPassword( String password ) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
    public void setAttempt( Integer attempt ) {
        this.attempt = attempt;
    }
    public Integer getAttempt() {
        return this.attempt;
    }
    public void setLastAccess( Date lastAccess ) {
        this.lastAccess = lastAccess;
    }
    public Date getLastAccess() {
        return this.lastAccess;
    }
    public void setLastChangePassword( Date lastChangePassword ) {
        this.lastChangePassword = lastChangePassword;
    }
    public Date getLastChangePassword() {
        return this.lastChangePassword;
    }
    public void setState( String state ) {
        this.state = state;
    }
    public String getState() {
        return this.state;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(enabled);
        sb.append("|");
        sb.append(firstname);
        sb.append("|");
        sb.append(lastname);
        sb.append("|");
        sb.append(password);
        sb.append("|");
        sb.append(attempt);
        sb.append("|");
        sb.append(lastAccess);
        sb.append("|");
        sb.append(lastChangePassword);
        sb.append("|");
        sb.append(state);
        return sb.toString(); 
    } 

}
