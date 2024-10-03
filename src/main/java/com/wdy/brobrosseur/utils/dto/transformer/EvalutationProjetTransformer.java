

/*
 * Java transformer for entity table evalutation_projet 
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
 * TRANSFORMER for table "evalutation_projet"
 * 
 * @author Geo
 *
 */
@Mapper
public interface EvalutationProjetTransformer {

	EvalutationProjetTransformer INSTANCE = Mappers.getMapper(EvalutationProjetTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="entity.projet.id", target="projetId"),
		@Mapping(source="entity.projet.nom", target="projetNom"),
	})
	EvalutationProjetDto toDto(EvalutationProjet entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<EvalutationProjetDto> toDtos(List<EvalutationProjet> entities) throws ParseException;

    default EvalutationProjetDto toLiteDto(EvalutationProjet entity) {
		if (entity == null) {
			return null;
		}
		EvalutationProjetDto dto = new EvalutationProjetDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<EvalutationProjetDto> toLiteDtos(List<EvalutationProjet> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<EvalutationProjetDto> dtos = new ArrayList<EvalutationProjetDto>();
		for (EvalutationProjet entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.note", target="note"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="projet", target="projet"),
	})
    EvalutationProjet toEntity(EvalutationProjetDto dto, Projet projet) throws ParseException;

    //List<EvalutationProjet> toEntities(List<EvalutationProjetDto> dtos) throws ParseException;

}
