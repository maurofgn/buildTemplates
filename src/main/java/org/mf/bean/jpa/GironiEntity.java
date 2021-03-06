/*
 * Created on 29 lug 2016 ( Time 14:37:00 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.mf.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "gironi"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="gironi", catalog="torneo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="GironiEntity.countAll", query="SELECT COUNT(x) FROM GironiEntity x" )
} )
public class GironiEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="descrizione", length=30)
    private String     descrizione  ;

    @Column(name="teamnr")
    private Integer    teamnr       ;

    @Column(name="playtime")
    private Integer    playtime     ;

    @Column(name="campo")
    private Integer    campo        ;

    @Column(name="livello")
    private Integer    livello      ;

    @Column(name="eliminatorie")
    private Integer    eliminatorie ;

    @Column(name="perdente")
    private Integer    perdente     ;

	// "iscrizioniId" (column "iscrizioni_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="iscrizioni_id", referencedColumnName="id")
    private IscrizioniEntity iscrizioni  ;

    @OneToMany(mappedBy="gironi", targetEntity=MatchEntity.class)
    private List<MatchEntity> listOfMatch ;

    @OneToMany(mappedBy="gironi", targetEntity=TeamEntity.class)
    private List<TeamEntity> listOfTeam  ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public GironiEntity() {
		super();
    }
    
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
    //--- DATABASE MAPPING : descrizione ( CHAR ) 
    public void setDescrizione( String descrizione ) {
        this.descrizione = descrizione;
    }
    public String getDescrizione() {
        return this.descrizione;
    }

    //--- DATABASE MAPPING : teamnr ( INT ) 
    public void setTeamnr( Integer teamnr ) {
        this.teamnr = teamnr;
    }
    public Integer getTeamnr() {
        return this.teamnr;
    }

    //--- DATABASE MAPPING : playtime ( INT ) 
    public void setPlaytime( Integer playtime ) {
        this.playtime = playtime;
    }
    public Integer getPlaytime() {
        return this.playtime;
    }

    //--- DATABASE MAPPING : campo ( INT ) 
    public void setCampo( Integer campo ) {
        this.campo = campo;
    }
    public Integer getCampo() {
        return this.campo;
    }

    //--- DATABASE MAPPING : livello ( INT ) 
    public void setLivello( Integer livello ) {
        this.livello = livello;
    }
    public Integer getLivello() {
        return this.livello;
    }

    //--- DATABASE MAPPING : eliminatorie ( INT ) 
    public void setEliminatorie( Integer eliminatorie ) {
        this.eliminatorie = eliminatorie;
    }
    public Integer getEliminatorie() {
        return this.eliminatorie;
    }

    //--- DATABASE MAPPING : perdente ( INT ) 
    public void setPerdente( Integer perdente ) {
        this.perdente = perdente;
    }
    public Integer getPerdente() {
        return this.perdente;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setIscrizioni( IscrizioniEntity iscrizioni ) {
        this.iscrizioni = iscrizioni;
    }
    public IscrizioniEntity getIscrizioni() {
        return this.iscrizioni;
    }

    public void setListOfMatch( List<MatchEntity> listOfMatch ) {
        this.listOfMatch = listOfMatch;
    }
    public List<MatchEntity> getListOfMatch() {
        return this.listOfMatch;
    }

    public void setListOfTeam( List<TeamEntity> listOfTeam ) {
        this.listOfTeam = listOfTeam;
    }
    public List<TeamEntity> getListOfTeam() {
        return this.listOfTeam;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(descrizione);
        sb.append("|");
        sb.append(teamnr);
        sb.append("|");
        sb.append(playtime);
        sb.append("|");
        sb.append(campo);
        sb.append("|");
        sb.append(livello);
        sb.append("|");
        sb.append(eliminatorie);
        sb.append("|");
        sb.append(perdente);
        return sb.toString(); 
    } 

}
