/*
 * Created on 29 lug 2016 ( Time 14:37:00 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.mf.bean;

import java.io.Serializable;

import javax.validation.constraints.*;


public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 50 )
    private String nome;

    @Size( max = 50 )
    private String citta;

    @Size( max = 50 )
    private String accompagnatore;

    @NotNull
    private Integer gironiId;


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
    public void setNome( String nome ) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }
    public void setCitta( String citta ) {
        this.citta = citta;
    }
    public String getCitta() {
        return this.citta;
    }
    public void setAccompagnatore( String accompagnatore ) {
        this.accompagnatore = accompagnatore;
    }
    public String getAccompagnatore() {
        return this.accompagnatore;
    }
    public void setGironiId( Integer gironiId ) {
        this.gironiId = gironiId;
    }
    public Integer getGironiId() {
        return this.gironiId;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(nome);
        sb.append("|");
        sb.append(citta);
        sb.append("|");
        sb.append(accompagnatore);
        sb.append("|");
        sb.append(gironiId);
        return sb.toString(); 
    } 

}
