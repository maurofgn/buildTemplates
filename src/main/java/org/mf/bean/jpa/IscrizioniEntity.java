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
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "iscrizioni"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="iscrizioni", catalog="torneo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="IscrizioniEntity.countAll", query="SELECT COUNT(x) FROM IscrizioniEntity x" )
} )
public class IscrizioniEntity implements Serializable {

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
    @Column(name="nrteam", nullable=false)
    private Integer    nrteam       ;

    @Column(name="nrplayer")
    private Integer    nrplayer     ;

    @Temporal(TemporalType.DATE)
    @Column(name="created", nullable=false)
    private Date       created      ;

    @Column(name="accompagnatore", length=45)
    private String     accompagnatore ;

	// "torneoId" (column "torneo_id") is not defined by itself because used as FK in a link 
	// "societaId" (column "societa_id") is not defined by itself because used as FK in a link 
	// "categorieId" (column "categorie_id") is not defined by itself because used as FK in a link 
	// "createdby" (column "createdBy") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="createdBy", referencedColumnName="id")
    private UserAccountEntity userAccount ;

    @ManyToOne
    @JoinColumn(name="categorie_id", referencedColumnName="id")
    private CategorieEntity categorie   ;

    @OneToMany(mappedBy="iscrizioni", targetEntity=GironiEntity.class)
    private List<GironiEntity> listOfGironi;

    @ManyToOne
    @JoinColumn(name="societa_id", referencedColumnName="id")
    private SocietaEntity societa     ;

    @ManyToOne
    @JoinColumn(name="torneo_id", referencedColumnName="id")
    private TorneoEntity torneo      ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public IscrizioniEntity() {
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
    //--- DATABASE MAPPING : nrteam ( INT ) 
    public void setNrteam( Integer nrteam ) {
        this.nrteam = nrteam;
    }
    public Integer getNrteam() {
        return this.nrteam;
    }

    //--- DATABASE MAPPING : nrplayer ( INT ) 
    public void setNrplayer( Integer nrplayer ) {
        this.nrplayer = nrplayer;
    }
    public Integer getNrplayer() {
        return this.nrplayer;
    }

    //--- DATABASE MAPPING : created ( DATE ) 
    public void setCreated( Date created ) {
        this.created = created;
    }
    public Date getCreated() {
        return this.created;
    }

    //--- DATABASE MAPPING : accompagnatore ( VARCHAR ) 
    public void setAccompagnatore( String accompagnatore ) {
        this.accompagnatore = accompagnatore;
    }
    public String getAccompagnatore() {
        return this.accompagnatore;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setUserAccount( UserAccountEntity userAccount ) {
        this.userAccount = userAccount;
    }
    public UserAccountEntity getUserAccount() {
        return this.userAccount;
    }

    public void setCategorie( CategorieEntity categorie ) {
        this.categorie = categorie;
    }
    public CategorieEntity getCategorie() {
        return this.categorie;
    }

    public void setListOfGironi( List<GironiEntity> listOfGironi ) {
        this.listOfGironi = listOfGironi;
    }
    public List<GironiEntity> getListOfGironi() {
        return this.listOfGironi;
    }

    public void setSocieta( SocietaEntity societa ) {
        this.societa = societa;
    }
    public SocietaEntity getSocieta() {
        return this.societa;
    }

    public void setTorneo( TorneoEntity torneo ) {
        this.torneo = torneo;
    }
    public TorneoEntity getTorneo() {
        return this.torneo;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(nrteam);
        sb.append("|");
        sb.append(nrplayer);
        sb.append("|");
        sb.append(created);
        sb.append("|");
        sb.append(accompagnatore);
        return sb.toString(); 
    } 

}
