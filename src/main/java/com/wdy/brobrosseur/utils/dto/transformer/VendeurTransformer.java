

/*
 * Java transformer for entity table vendeur 
 * Created on 2024-09-29 ( Time 22:05:55 )
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
 * TRANSFORMER for table "vendeur"
 * 
 * @author Geo
 *
 */
@Mapper
public interface VendeurTransformer {

	VendeurTransformer INSTANCE = Mappers.getMapper(VendeurTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="entity.utilisateur.id", target="utilisateurId"),
		@Mapping(source="entity.utilisateur.nom", target="utilisateurNom"),
		@Mapping(source="entity.utilisateur.prenom", target="utilisateurPrenom"),
	})
	VendeurDto toDto(Vendeur entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<VendeurDto> toDtos(List<Vendeur> entities) throws ParseException;

    default VendeurDto toLiteDto(Vendeur entity) {
		if (entity == null) {
			return null;
		}
		VendeurDto dto = new VendeurDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<VendeurDto> toLiteDtos(List<Vendeur> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<VendeurDto> dtos = new ArrayList<VendeurDto>();
		for (Vendeur entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="utilisateur", target="utilisateur"),
	})
    Vendeur toEntity(VendeurDto dto, Utilisateur utilisateur) throws ParseException;

    //List<Vendeur> toEntities(List<VendeurDto> dtos) throws ParseException;

}
