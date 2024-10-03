/*
 * Created on 2024-10-03 ( Time 13:00:22 )
 * Generated by Telosys Tools Generator ( version 3.3.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.wdy.brobrosseur.dao.entity;

import java.io.Serializable;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "utilisateur_activite"
 *
 * @author Telosys Tools Generator
 *
 */
@Data
@ToString
@Entity
@Table(name="utilisateur_activite" )
public class UtilisateurActivite implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id", nullable=false)
    // test value Integer
        private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="commentaire", length=65535)
    private String     commentaire  ;

    @Column(name="status_id")
    private Integer    statusId     ;

    @Column(name="updated_by")
    private Integer    updatedBy    ;

    @Column(name="is_deleted")
    private Boolean    isDeleted    ;

    @Column(name="created_by")
    private Integer    createdBy    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="deleted_at")
    private Date       deletedAt    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")
    private Date       updatedAt    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date       createdAt    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_fin")
    private Date       dateFin      ;

	// "utilisateurId" (column "utilisateur_id") is not defined by itself because used as FK in a link 
	// "activiteId" (column "activite_id") is not defined by itself because used as FK in a link 

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="activite_id", referencedColumnName="id")
    private Activite activite    ;
    @ManyToOne
    @JoinColumn(name="utilisateur_id", referencedColumnName="id")
    private Utilisateur utilisateur ;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public UtilisateurActivite() {
		super();
    }
    
	//----------------------------------------------------------------------
    // clone METHOD
    //----------------------------------------------------------------------
	@Override
	public java.lang.Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}