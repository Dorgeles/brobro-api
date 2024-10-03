

/*
 * Java transformer for entity table images_prestation 
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
 * TRANSFORMER for table "images_prestation"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ImagesPrestationTransformer {

	ImagesPrestationTransformer INSTANCE = Mappers.getMapper(ImagesPrestationTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="entity.prestation.id", target="prestationId"),
		@Mapping(source="entity.prestation.libelle", target="prestationLibelle"),
	})
	ImagesPrestationDto toDto(ImagesPrestation entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ImagesPrestationDto> toDtos(List<ImagesPrestation> entities) throws ParseException;

    default ImagesPrestationDto toLiteDto(ImagesPrestation entity) {
		if (entity == null) {
			return null;
		}
		ImagesPrestationDto dto = new ImagesPrestationDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<ImagesPrestationDto> toLiteDtos(List<ImagesPrestation> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ImagesPrestationDto> dtos = new ArrayList<ImagesPrestationDto>();
		for (ImagesPrestation entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.url", target="url"),
		@Mapping(source="dto.description", target="description"),
		@Mapping(source="dto.ordre", target="ordre"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="prestation", target="prestation"),
	})
    ImagesPrestation toEntity(ImagesPrestationDto dto, Prestation prestation) throws ParseException;

    //List<ImagesPrestation> toEntities(List<ImagesPrestationDto> dtos) throws ParseException;

}
