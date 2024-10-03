

/*
 * Java transformer for entity table evaluation_prestation 
 * Created on 2024-09-29 ( Time 22:05:54 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.dto.transformer;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.wdy.brobrosseur.utils.contract.*;
import com.wdy.brobrosseur.utils.dto.*;
import com.wdy.brobrosseur.dao.entity.*;


/**
 * TRANSFORMER for table "evaluation_prestation"
 * 
 * @author Geo
 *
 */
@Mapper
public interface EvaluationPrestationTransformer {

	EvaluationPrestationTransformer INSTANCE = Mappers.getMapper(EvaluationPrestationTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="entity.command.id", target="commandeId"),
		@Mapping(source="entity.prestation.id", target="prestationId"),
		@Mapping(source="entity.prestation.libelle", target="prestationLibelle"),
		@Mapping(source="entity.customer.id", target="customerId"),
	})
	EvaluationPrestationDto toDto(EvaluationPrestation entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<EvaluationPrestationDto> toDtos(List<EvaluationPrestation> entities) throws ParseException;

    default EvaluationPrestationDto toLiteDto(EvaluationPrestation entity) {
		if (entity == null) {
			return null;
		}
		EvaluationPrestationDto dto = new EvaluationPrestationDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<EvaluationPrestationDto> toLiteDtos(List<EvaluationPrestation> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<EvaluationPrestationDto> dtos = new ArrayList<EvaluationPrestationDto>();
		for (EvaluationPrestation entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.note", target="note"),
		@Mapping(source="dto.commentaire", target="commentaire"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="command", target="command"),
		@Mapping(source="prestation", target="prestation"),
		@Mapping(source="customer", target="customer"),
	})
    EvaluationPrestation toEntity(EvaluationPrestationDto dto, Command command, Prestation prestation, Customer customer) throws ParseException;

    //List<EvaluationPrestation> toEntities(List<EvaluationPrestationDto> dtos) throws ParseException;

}
