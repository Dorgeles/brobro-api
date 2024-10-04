

/*
 * Java transformer for entity table evaluation_command 
 * Created on 2024-10-03 ( Time 13:19:22 )
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
 * TRANSFORMER for table "evaluation_command"
 * 
 * @author Geo
 *
 */
@Mapper
public interface EvaluationCommandTransformer {

	EvaluationCommandTransformer INSTANCE = Mappers.getMapper(EvaluationCommandTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.command.id", target="commandeId"),
	})
	EvaluationCommandDto toDto(EvaluationCommand entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<EvaluationCommandDto> toDtos(List<EvaluationCommand> entities) throws ParseException;

    default EvaluationCommandDto toLiteDto(EvaluationCommand entity) {
		if (entity == null) {
			return null;
		}
		EvaluationCommandDto dto = new EvaluationCommandDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<EvaluationCommandDto> toLiteDtos(List<EvaluationCommand> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<EvaluationCommandDto> dtos = new ArrayList<EvaluationCommandDto>();
		for (EvaluationCommand entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.noteRapidite", target="noteRapidite"),
		@Mapping(source="dto.notePrestation", target="notePrestation"),
		@Mapping(source="dto.noteConservation", target="noteConservation"),
		@Mapping(source="dto.commentairePrestation", target="commentairePrestation"),
		@Mapping(source="dto.dateEvaluation", target="dateEvaluation"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="command", target="command"),
	})
    EvaluationCommand toEntity(EvaluationCommandDto dto, Command command) throws ParseException;

    //List<EvaluationCommand> toEntities(List<EvaluationCommandDto> dtos) throws ParseException;

}
