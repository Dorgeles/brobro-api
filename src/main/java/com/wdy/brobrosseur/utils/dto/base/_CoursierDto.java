
/*
 * Java dto for entity table coursier 
 * Created on 2024-09-29 ( Time 22:05:54 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto.base;

import java.util.Date;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import lombok.*;

import com.wdy.brobrosseur.utils.contract.*;

/**
 * DTO customize for table "coursier"
 * 
 * @author Smile Back-End generator
 *
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _CoursierDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected Integer    utilisateurId        ;
    protected Boolean    disponible           ;
    protected Integer    statusId             ;
    protected Integer    updatedBy            ;
    protected Boolean    isDeleted            ;
    protected Integer    createdBy            ;
	protected String     deletedAt            ;
	protected String     updatedAt            ;
	protected String     createdAt            ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------
	//protected Integer    utilisateur;
	protected String utilisateurNom;
	protected String utilisateurPrenom;
	protected String utilisateurEmail;
	protected String utilisateurTelephone;

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<Integer>  utilisateurIdParam    ;                     
	protected SearchParam<Boolean>  disponibleParam       ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  utilisateurParam      ;                     
	protected SearchParam<String>   utilisateurNomParam   ;                     
	protected SearchParam<String>   utilisateurPrenomParam;                     
	protected SearchParam<String>   utilisateurEmailParam ;                     
	protected SearchParam<String>   utilisateurTelephoneParam;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
