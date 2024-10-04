

/*
 * Java transformer for entity table prestation_moyen_deplacement 
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
 * TRANSFORMER for table "prestation_moyen_deplacement"
 * 
 * @author Geo
 *
 */
@Mapper
public interface PrestationMoyenDeplacementTransformer {

	PrestationMoyenDeplacementTransformer INSTANCE = Mappers.getMapper(PrestationMoyenDeplacementTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.dateDebut", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateDebut"),
		@Mapping(source="entity.dateFin", dateFormat="dd/MM/yyyy",target="dateFin"),
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.moyenDeplacement.id", target="moyenDeplacementId"),
		@Mapping(source="entity.moyenDeplacement.libelle", target="moyenDeplacementLibelle"),
		@Mapping(source="entity.prestation.id", target="presatationId"),
		@Mapping(source="entity.prestation.libelle", target="prestationLibelle"),
	})
	PrestationMoyenDeplacementDto toDto(PrestationMoyenDeplacement entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<PrestationMoyenDeplacementDto> toDtos(List<PrestationMoyenDeplacement> entities) throws ParseException;

    default PrestationMoyenDeplacementDto toLiteDto(PrestationMoyenDeplacement entity) {
		if (entity == null) {
			return null;
		}
		PrestationMoyenDeplacementDto dto = new PrestationMoyenDeplacementDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<PrestationMoyenDeplacementDto> toLiteDtos(List<PrestationMoyenDeplacement> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<PrestationMoyenDeplacementDto> dtos = new ArrayList<PrestationMoyenDeplacementDto>();
		for (PrestationMoyenDeplacement entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.dateDebut", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateDebut"),
		@Mapping(source="dto.dateFin", dateFormat="dd/MM/yyyy",target="dateFin"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="moyenDeplacement", target="moyenDeplacement"),
		@Mapping(source="prestation", target="prestation"),
	})
    PrestationMoyenDeplacement toEntity(PrestationMoyenDeplacementDto dto, MoyenDeplacement moyenDeplacement, Prestation prestation) throws ParseException;

    //List<PrestationMoyenDeplacement> toEntities(List<PrestationMoyenDeplacementDto> dtos) throws ParseException;

}
