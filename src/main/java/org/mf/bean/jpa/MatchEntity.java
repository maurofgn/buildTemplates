/*
 * Created on 29 lug 2016 ( Time 14:37:00 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.mf.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "match"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="match", catalog="torneo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="MatchEntity.countAll", query="SELECT COUNT(x) FROM MatchEntity x" )
} )
public class MatchEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="punti1team_a")
    private Short      punti1teamA  ;

    @Column(name="punti2team_a")
    private Short      punti2teamA  ;

    @Column(name="punti1team_b")
    private Short      punti1teamB  ;

    @Column(name="punti2team_b")
    private Short      punti2teamB  ;

    @Column(name="campo", length=40)
    private String     campo        ;

    @Column(name="arbitro", length=40)
    private String     arbitro      ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="inizio")
    private Date       inizio       ;

    @Column(name="progressivo", nullable=false)
    private Short      progressivo  ;

	// "teamA" (column "team_a") is not defined by itself because used as FK in a link 
	// "teamB" (column "team_b") is not defined by itself because used as FK in a link 
	// "gironiId" (column "gironi_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="team_b", referencedColumnName="id")
    private TeamEntity teamB        ;

    @ManyToOne
    @JoinColumn(name="gironi_id", referencedColumnName="id")
    private GironiEntity gironi      ;

    @ManyToOne
    @JoinColumn(name="team_a", referencedColumnName="id")
    private TeamEntity teamA        ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public MatchEntity() {
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
    //--- DATABASE MAPPING : punti1team_a ( SMALLINT ) 
    public void setPunti1teamA( Short punti1teamA ) {
        this.punti1teamA = punti1teamA;
    }
    public Short getPunti1teamA() {
        return this.punti1teamA;
    }

    //--- DATABASE MAPPING : punti2team_a ( SMALLINT ) 
    public void setPunti2teamA( Short punti2teamA ) {
        this.punti2teamA = punti2teamA;
    }
    public Short getPunti2teamA() {
        return this.punti2teamA;
    }

    //--- DATABASE MAPPING : punti1team_b ( SMALLINT ) 
    public void setPunti1teamB( Short punti1teamB ) {
        this.punti1teamB = punti1teamB;
    }
    public Short getPunti1teamB() {
        return this.punti1teamB;
    }

    //--- DATABASE MAPPING : punti2team_b ( SMALLINT ) 
    public void setPunti2teamB( Short punti2teamB ) {
        this.punti2teamB = punti2teamB;
    }
    public Short getPunti2teamB() {
        return this.punti2teamB;
    }

    //--- DATABASE MAPPING : campo ( VARCHAR ) 
    public void setCampo( String campo ) {
        this.campo = campo;
    }
    public String getCampo() {
        return this.campo;
    }

    //--- DATABASE MAPPING : arbitro ( VARCHAR ) 
    public void setArbitro( String arbitro ) {
        this.arbitro = arbitro;
    }
    public String getArbitro() {
        return this.arbitro;
    }

    //--- DATABASE MAPPING : inizio ( DATETIME ) 
    public void setInizio( Date inizio ) {
        this.inizio = inizio;
    }
    public Date getInizio() {
        return this.inizio;
    }

    //--- DATABASE MAPPING : progressivo ( SMALLINT ) 
    public void setProgressivo( Short progressivo ) {
        this.progressivo = progressivo;
    }
    public Short getProgressivo() {
        return this.progressivo;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setTeamA( TeamEntity teamA ) {
        this.teamA = teamA;
    }
    public TeamEntity getTeamA() {
        return this.teamA;
    }

    public void setGironi( GironiEntity gironi ) {
        this.gironi = gironi;
    }
    public GironiEntity getGironi() {
        return this.gironi;
    }

    public void setTeamB( TeamEntity teamB ) {
        this.teamB = teamB;
    }
    public TeamEntity getTeamBD() {
        return this.teamB;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(punti1teamA);
        sb.append("|");
        sb.append(punti2teamA);
        sb.append("|");
        sb.append(punti1teamB);
        sb.append("|");
        sb.append(punti2teamB);
        sb.append("|");
        sb.append(campo);
        sb.append("|");
        sb.append(arbitro);
        sb.append("|");
        sb.append(inizio);
        sb.append("|");
        sb.append(progressivo);
        return sb.toString(); 
    } 

}