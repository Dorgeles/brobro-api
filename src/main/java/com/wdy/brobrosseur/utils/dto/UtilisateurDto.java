
/*
 * Java dto for entity table utilisateur 
 * Created on 2024-09-29 ( Time 22:52:47 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto;

import java.util.Date;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.*;

import com.wdy.brobrosseur.utils.contract.*;
import com.wdy.brobrosseur.utils.dto.base._UtilisateurDto;

/**
 * DTO for table "utilisateur"
 *
 * @author Geo
 */
@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder(alphabetic = true)
public class UtilisateurDto extends _UtilisateurDto{

    private String    statusLibelle               ;
    
	//----------------------------------------------------------------------
    // clone METHOD
    //----------------------------------------------------------------------
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
