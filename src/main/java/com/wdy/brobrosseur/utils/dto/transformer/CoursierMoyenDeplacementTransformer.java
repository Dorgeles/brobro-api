

/*
 * Java transformer for entity table coursier_moyen_deplacement 
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
 * TRANSFORMER for table "coursier_moyen_deplacement"
 * 
 * @author Geo
 *
 */
@Mapper
public interface CoursierMoyenDeplacementTransformer {

	CoursierMoyenDeplacementTransformer INSTANCE = Mappers.getMapper(CoursierMoyenDeplacementTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.dateDebut", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateDebut"),
		@Mapping(source="entity.dateFin", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateFin"),
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="entity.moyenDeplacement.id", target="moyenDeplacementId"),
		@Mapping(source="entity.moyenDeplacement.libelle", target="moyenDeplacementLibelle"),
		@Mapping(source="entity.coursier.id", target="coursierId"),
	})
	CoursierMoyenDeplacementDto toDto(CoursierMoyenDeplacement entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<CoursierMoyenDeplacementDto> toDtos(List<CoursierMoyenDeplacement> entities) throws ParseException;

    default CoursierMoyenDeplacementDto toLiteDto(CoursierMoyenDeplacement entity) {
		if (entity == null) {
			return null;
		}
		CoursierMoyenDeplacementDto dto = new CoursierMoyenDeplacementDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<CoursierMoyenDeplacementDto> toLiteDtos(List<CoursierMoyenDeplacement> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<CoursierMoyenDeplacementDto> dtos = new ArrayList<CoursierMoyenDeplacementDto>();
		for (CoursierMoyenDeplacement entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.dateDebut", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateDebut"),
		@Mapping(source="dto.dateFin", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="dateFin"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="moyenDeplacement", target="moyenDeplacement"),
		@Mapping(source="coursier", target="coursier"),
	})
    CoursierMoyenDeplacement toEntity(CoursierMoyenDeplacementDto dto, MoyenDeplacement moyenDeplacement, Coursier coursier) throws ParseException;

    //List<CoursierMoyenDeplacement> toEntities(List<CoursierMoyenDeplacementDto> dtos) throws ParseException;

}
