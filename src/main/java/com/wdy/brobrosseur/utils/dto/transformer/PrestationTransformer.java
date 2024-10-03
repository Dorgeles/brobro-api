

/*
 * Java transformer for entity table prestation 
 * Created on 2024-09-29 ( Time 23:04:15 )
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
 * TRANSFORMER for table "prestation"
 * 
 * @author Geo
 *
 */
@Mapper
public interface PrestationTransformer {

	PrestationTransformer INSTANCE = Mappers.getMapper(PrestationTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
	})
	PrestationDto toDto(Prestation entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<PrestationDto> toDtos(List<Prestation> entities) throws ParseException;

    default PrestationDto toLiteDto(Prestation entity) {
		if (entity == null) {
			return null;
		}
		PrestationDto dto = new PrestationDto();
		dto.setId( entity.getId() );
		dto.setLibelle( entity.getLibelle() );
		return dto;
    }

	default List<PrestationDto> toLiteDtos(List<Prestation> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<PrestationDto> dtos = new ArrayList<PrestationDto>();
		for (Prestation entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.projetId", target="projetId"),
		@Mapping(source="dto.libelle", target="libelle"),
		@Mapping(source="dto.description", target="description"),
		@Mapping(source="dto.prix", target="prix"),
		@Mapping(source="dto.dureeEstimee", target="dureeEstimee"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
	})
    Prestation toEntity(PrestationDto dto) throws ParseException;

    //List<Prestation> toEntities(List<PrestationDto> dtos) throws ParseException;

}
