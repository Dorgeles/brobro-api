

/*
 * Java transformer for entity table projet 
 * Created on 2024-09-29 ( Time 23:02:37 )
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
 * TRANSFORMER for table "projet"
 * 
 * @author Geo
 *
 */
@Mapper
public interface ProjetTransformer {

	ProjetTransformer INSTANCE = Mappers.getMapper(ProjetTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="entity.vendeur.id", target="vendeurId"),
	})
	ProjetDto toDto(Projet entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<ProjetDto> toDtos(List<Projet> entities) throws ParseException;

    default ProjetDto toLiteDto(Projet entity) {
		if (entity == null) {
			return null;
		}
		ProjetDto dto = new ProjetDto();
		dto.setId( entity.getId() );
		dto.setNom( entity.getNom() );
		return dto;
    }

	default List<ProjetDto> toLiteDtos(List<Projet> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<ProjetDto> dtos = new ArrayList<ProjetDto>();
		for (Projet entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.nom", target="nom"),
		@Mapping(source="dto.description", target="description"),
		@Mapping(source="dto.latitude", target="latitude"),
		@Mapping(source="dto.longitude", target="longitude"),
		@Mapping(source="dto.noteMoyenne", target="noteMoyenne"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="vendeur", target="vendeur"),
	})
    Projet toEntity(ProjetDto dto, Vendeur vendeur) throws ParseException;

    //List<Projet> toEntities(List<ProjetDto> dtos) throws ParseException;

}
