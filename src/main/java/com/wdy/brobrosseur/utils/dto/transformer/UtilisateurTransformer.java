

/*
 * Java transformer for entity table utilisateur 
 * Created on 2024-09-29 ( Time 22:52:48 )
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
 * TRANSFORMER for table "utilisateur"
 * 
 * @author Geo
 *
 */
@Mapper
public interface UtilisateurTransformer {

	UtilisateurTransformer INSTANCE = Mappers.getMapper(UtilisateurTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
	})
	UtilisateurDto toDto(Utilisateur entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<UtilisateurDto> toDtos(List<Utilisateur> entities) throws ParseException;

    default UtilisateurDto toLiteDto(Utilisateur entity) {
		if (entity == null) {
			return null;
		}
		UtilisateurDto dto = new UtilisateurDto();
		dto.setId( entity.getId() );
		dto.setNom( entity.getNom() );
		dto.setPrenom( entity.getPrenom() );
		return dto;
    }

	default List<UtilisateurDto> toLiteDtos(List<Utilisateur> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<UtilisateurDto> dtos = new ArrayList<UtilisateurDto>();
		for (Utilisateur entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.nom", target="nom"),
		@Mapping(source="dto.username", target="username"),
		@Mapping(source="dto.prenom", target="prenom"),
		@Mapping(source="dto.email", target="email"),
		@Mapping(source="dto.telephone", target="telephone"),
		@Mapping(source="dto.telephone2", target="telephone2"),
		@Mapping(source="dto.motDePasse", target="motDePasse"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.isLocked", target="isLocked"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="dto.typeClient", target="typeClient"),
	})
    Utilisateur toEntity(UtilisateurDto dto) throws ParseException;

    //List<Utilisateur> toEntities(List<UtilisateurDto> dtos) throws ParseException;

}
