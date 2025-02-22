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
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "role"
 *
 * @author Telosys Tools Generator
 *
 */
@Data
@ToString
@Entity
@Table(name="role" )
public class Role implements Serializable, Cloneable {

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
    @Column(name="description", length=65535)
    private String     description  ;

    @Column(name="libelle", length=255)
    private String     libelle      ;

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


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Role() {
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
