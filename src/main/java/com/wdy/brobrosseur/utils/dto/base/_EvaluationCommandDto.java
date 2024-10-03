
/*
 * Java dto for entity table evaluation_command 
 * Created on 2024-10-03 ( Time 13:00:22 )
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
 * DTO customize for table "evaluation_command"
 * 
 * @author Smile Back-End generator
 *
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _EvaluationCommandDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected Integer    commandeId           ;
    protected Integer    noteRapidite         ;
    protected Integer    notePrestation       ;
    protected Integer    noteConservation     ;
    protected String     commentairePrestation ;
    protected Date       dateEvaluation       ;
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

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<Integer>  commandeIdParam       ;                     
	protected SearchParam<Integer>  noteRapiditeParam     ;                     
	protected SearchParam<Integer>  notePrestationParam   ;                     
	protected SearchParam<Integer>  noteConservationParam ;                     
	protected SearchParam<String>   commentairePrestationParam;                     
	protected SearchParam<Date>     dateEvaluationParam   ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  commandParam          ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
