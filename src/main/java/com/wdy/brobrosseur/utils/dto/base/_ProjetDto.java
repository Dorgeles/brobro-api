
/*
 * Java dto for entity table projet 
 * Created on 2024-09-29 ( Time 23:02:37 )
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
 * DTO customize for table "projet"
 * 
 * @author Smile Back-End generator
 *
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class _ProjetDto implements Cloneable {

    protected Integer    id                   ; // Primary Key

    protected Integer    vendeurId            ;
    protected String     nom                  ;
    protected String     description          ;
    protected String     latitude             ;
    protected String     longitude            ;
    protected Integer    noteMoyenne          ;
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
	//protected Integer    vendeur;

	// Search param
	protected SearchParam<Integer>  idParam               ;                     
	protected SearchParam<Integer>  vendeurIdParam        ;                     
	protected SearchParam<String>   nomParam              ;                     
	protected SearchParam<String>   descriptionParam      ;                     
	protected SearchParam<String>   latitudeParam         ;                     
	protected SearchParam<String>   longitudeParam        ;                     
	protected SearchParam<Integer>  noteMoyenneParam      ;                     
	protected SearchParam<Integer>  statusIdParam         ;                     
	protected SearchParam<Integer>  updatedByParam        ;                     
	protected SearchParam<Boolean>  isDeletedParam        ;                     
	protected SearchParam<Integer>  createdByParam        ;                     
	protected SearchParam<String>   deletedAtParam        ;                     
	protected SearchParam<String>   updatedAtParam        ;                     
	protected SearchParam<String>   createdAtParam        ;                     
	protected SearchParam<Integer>  vendeurParam          ;                     

	// order param
	protected String orderField;
	protected String orderDirection;




}
