

/*
 * Java transformer for entity table activite 
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
 * TRANSFORMER for table "activite"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ActiviteTransformer {

	ActiviteTransformer INSTANCE = Mappers.getMapper(ActiviteTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.dateOuverture", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateOuverture"),
		@Mapping(source="entity.dateFermeture", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateFermeture"),
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="entity.dateFin", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateFin"),
	})
	ActiviteDto toDto(Activite entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ActiviteDto> toDtos(List<Activite> entities) throws ParseException;

    default ActiviteDto toLiteDto(Activite entity) {
		if (entity == null) {
			return null;
		}
		ActiviteDto dto = new ActiviteDto();
		dto.setId( entity.getId() );
		dto.setLibelle( entity.getLibelle() );
		return dto;
    }

	default List<ActiviteDto> toLiteDtos(List<Activite> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ActiviteDto> dtos = new ArrayList<ActiviteDto>();
		for (Activite entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.libelle", target="libelle"),
		@Mapping(source="dto.description", target="description"),
		@Mapping(source="dto.latitude", target="latitude"),
		@Mapping(source="dto.longitude", target="longitude"),
		@Mapping(source="dto.noteMoyenne", target="noteMoyenne"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.dateOuverture", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateOuverture"),
		@Mapping(source="dto.dateFermeture", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateFermeture"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="dto.dateFin", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateFin"),
	})
    Activite toEntity(ActiviteDto dto) throws ParseException;

    //List<Activite> toEntities(List<ActiviteDto> dtos) throws ParseException;

}
