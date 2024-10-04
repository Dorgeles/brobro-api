
/*
 * Java dto for entity table activite 
 * Created on 2024-10-03 ( Time 17:22:58 )
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
 * DTO customize for table "activite"
 * 
 * @author Smile Back-End generator
 *
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _ActiviteDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected String     libelle              ;
    protected String     description          ;
    protected String     latitude             ;
    protected String     longitude            ;
    protected Integer    noteMoyenne          ;
    protected Integer    statusId             ;
	protected String     dateOuverture        ;
	protected String     dateFermeture        ;
    protected Integer    updatedBy            ;
    protected Boolean    isDeleted            ;
    protected Integer    createdBy            ;
	protected String     deletedAt            ;
	protected String     updatedAt            ;
	protected String     createdAt            ;
	protected String     dateFin              ;

    //----------------------------------------------------------------------
    // ENTITY LINKS FIELD ( RELATIONSHIP )
    //----------------------------------------------------------------------

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<String>   libelleParam          ;                     
	protected SearchParam<String>   descriptionParam      ;                     
	protected SearchParam<String>   latitudeParam         ;                     
	protected SearchParam<String>   longitudeParam        ;                     
	protected SearchParam<Integer>  noteMoyenneParam      ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<String>   dateOuvertureParam    ;                     
	protected SearchParam<String>   dateFermetureParam    ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<String>   dateFinParam          ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
