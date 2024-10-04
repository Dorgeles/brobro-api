

/*
 * Java transformer for entity table activite_prestation 
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
 * TRANSFORMER for table "activite_prestation"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ActivitePrestationTransformer {

	ActivitePrestationTransformer INSTANCE = Mappers.getMapper(ActivitePrestationTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.activite.id", target="activiteId"),
		@Mapping(source="entity.activite.libelle", target="activiteLibelle"),
		@Mapping(source="entity.prestation.id", target="prestationId"),
		@Mapping(source="entity.prestation.libelle", target="prestationLibelle"),
	})
	ActivitePrestationDto toDto(ActivitePrestation entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ActivitePrestationDto> toDtos(List<ActivitePrestation> entities) throws ParseException;

    default ActivitePrestationDto toLiteDto(ActivitePrestation entity) {
		if (entity == null) {
			return null;
		}
		ActivitePrestationDto dto = new ActivitePrestationDto();
		dto.setId( entity.getId() );
		dto.setLibelle( entity.getLibelle() );
		return dto;
    }

	default List<ActivitePrestationDto> toLiteDtos(List<ActivitePrestation> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ActivitePrestationDto> dtos = new ArrayList<ActivitePrestationDto>();
		for (ActivitePrestation entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.description", target="description"),
		@Mapping(source="dto.libelle", target="libelle"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="activite", target="activite"),
		@Mapping(source="prestation", target="prestation"),
	})
    ActivitePrestation toEntity(ActivitePrestationDto dto, Activite activite, Prestation prestation) throws ParseException;

    //List<ActivitePrestation> toEntities(List<ActivitePrestationDto> dtos) throws ParseException;

}
