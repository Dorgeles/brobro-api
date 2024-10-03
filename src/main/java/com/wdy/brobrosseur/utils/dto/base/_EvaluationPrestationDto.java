
/*
 * Java dto for entity table evaluation_prestation 
 * Created on 2024-09-29 ( Time 22:05:54 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto.base;

import java.util.Date;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import lombok.*;

import com.wdy.brobrosseur.utils.contract.*;

/**
 * DTO customize for table "evaluation_prestation"
 * 
 * @author Smile Back-End generator
 *
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _EvaluationPrestationDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected Integer    customerId           ;
    protected Integer    prestationId         ;
    protected Integer    commandeId           ;
    protected Integer    note                 ;
    protected String     commentaire          ;
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
	//protected Integer    command;
	//protected Integer    prestation;
	protected String prestationLibelle;
	//protected Integer    customer;

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<Integer>  customerIdParam       ;                     
	protected SearchParam<Integer>  prestationIdParam     ;                     
	protected SearchParam<Integer>  commandeIdParam       ;                     
	protected SearchParam<Integer>  noteParam             ;                     
	protected SearchParam<String>   commentaireParam      ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  commandParam          ;                     
	protected SearchParam<Integer>  prestationParam       ;                     
	protected SearchParam<String>   prestationLibelleParam;                     
	protected SearchParam<Integer>  customerParam         ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
