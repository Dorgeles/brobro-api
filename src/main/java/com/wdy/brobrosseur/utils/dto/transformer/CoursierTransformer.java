

/*
 * Java transformer for entity table coursier 
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
 * TRANSFORMER for table "coursier"
 * 
 * @author Geo
 *
 */
@Mapper
public interface CoursierTransformer {

	CoursierTransformer INSTANCE = Mappers.getMapper(CoursierTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="entity.utilisateur.id", target="utilisateurId"),
		@Mapping(source="entity.utilisateur.nom", target="utilisateurNom"),
		@Mapping(source="entity.utilisateur.prenom", target="utilisateurPrenom"),
	})
	CoursierDto toDto(Coursier entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<CoursierDto> toDtos(List<Coursier> entities) throws ParseException;

    default CoursierDto toLiteDto(Coursier entity) {
		if (entity == null) {
			return null;
		}
		CoursierDto dto = new CoursierDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<CoursierDto> toLiteDtos(List<Coursier> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<CoursierDto> dtos = new ArrayList<CoursierDto>();
		for (Coursier entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.disponible", target="disponible"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="utilisateur", target="utilisateur"),
	})
    Coursier toEntity(CoursierDto dto, Utilisateur utilisateur) throws ParseException;

    //List<Coursier> toEntities(List<CoursierDto> dtos) throws ParseException;

}
