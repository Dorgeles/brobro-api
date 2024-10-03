
/*
 * Java dto for entity table utilisateur 
 * Created on 2024-09-29 ( Time 22:52:47 )
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
 * DTO customize for table "utilisateur"
 * 
 * @author Smile Back-End generator
 *
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _UtilisateurDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected String     nom                  ;
    protected String     username             ;
    protected String     prenom               ;
    protected String     email                ;
    protected String     telephone            ;
    protected String     telephone2           ;
    protected String     motDePasse           ;
    protected Integer    statusId             ;
    protected Integer    updatedBy            ;
    protected Boolean    isDeleted            ;
    protected Integer    createdBy            ;
	protected String     deletedAt            ;
    protected Boolean    isLocked             ;
	protected String     updatedAt            ;
	protected String     createdAt            ;
    protected Integer    typeClient           ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<String>   nomParam              ;                     
	protected SearchParam<String>   usernameParam         ;                     
	protected SearchParam<String>   prenomParam           ;                     
	protected SearchParam<String>   emailParam            ;                     
	protected SearchParam<String>   telephoneParam        ;                     
	protected SearchParam<String>   telephone2Param       ;                     
	protected SearchParam<String>   motDePasseParam       ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<Boolean>  isLockedParam         ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  typeClientParam       ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
