
/*
 * Java dto for entity table command 
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
 * DTO customize for table "command"
 * 
 * @author Smile Back-End generator
 *
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _CommandDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected Integer    consommateurId       ;
    protected Integer    coursierId           ;
    protected Integer    prestationId         ;
    protected String     typeCommand          ;
    protected String     latitudeLivraison    ;
    protected String     longitudeLivraison   ;
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
	//protected Integer    customer;
	//protected Integer    prestation;
	protected String prestationLibelle;
	//protected Integer    coursier;

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<Integer>  consommateurIdParam   ;                     
	protected SearchParam<Integer>  coursierIdParam       ;                     
	protected SearchParam<Integer>  prestationIdParam     ;                     
	protected SearchParam<String>   typeCommandParam      ;                     
	protected SearchParam<String>   latitudeLivraisonParam;                     
	protected SearchParam<String>   longitudeLivraisonParam;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  customerParam         ;                     
	protected SearchParam<Integer>  prestationParam       ;                     
	protected SearchParam<String>   prestationLibelleParam;                     
	protected SearchParam<Integer>  coursierParam         ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
