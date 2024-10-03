

/*
 * Java transformer for entity table record_image 
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
 * TRANSFORMER for table "record_image"
 * 
 * @author Geo
 *
 */
@Mapper
public interface RecordImageTransformer {

	RecordImageTransformer INSTANCE = Mappers.getMapper(RecordImageTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="entity.activite.id", target="activiteId"),
		@Mapping(source="entity.activite.libelle", target="activiteLibelle"),
	})
	RecordImageDto toDto(RecordImage entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<RecordImageDto> toDtos(List<RecordImage> entities) throws ParseException;

    default RecordImageDto toLiteDto(RecordImage entity) {
		if (entity == null) {
			return null;
		}
		RecordImageDto dto = new RecordImageDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<RecordImageDto> toLiteDtos(List<RecordImage> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<RecordImageDto> dtos = new ArrayList<RecordImageDto>();
		for (RecordImage entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.url", target="url"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="activite", target="activite"),
	})
    RecordImage toEntity(RecordImageDto dto, Activite activite) throws ParseException;

    //List<RecordImage> toEntities(List<RecordImageDto> dtos) throws ParseException;

}
