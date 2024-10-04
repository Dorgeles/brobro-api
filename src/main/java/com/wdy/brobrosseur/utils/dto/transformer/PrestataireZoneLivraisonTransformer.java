

/*
 * Java transformer for entity table prestataire_zone_livraison 
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
 * TRANSFORMER for table "prestataire_zone_livraison"
 * 
 * @author Geo
 *
 */
@Mapper
public interface PrestataireZoneLivraisonTransformer {

	PrestataireZoneLivraisonTransformer INSTANCE = Mappers.getMapper(PrestataireZoneLivraisonTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.dateFin", dateFormat="dd/MM/yyyy",target="dateFin"),
		@Mapping(source="entity.zoneLivraison.id", target="zoneLivraisonId"),
		@Mapping(source="entity.prestation.id", target="prestataireId"),
		@Mapping(source="entity.prestation.libelle", target="prestationLibelle"),
	})
	PrestataireZoneLivraisonDto toDto(PrestataireZoneLivraison entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<PrestataireZoneLivraisonDto> toDtos(List<PrestataireZoneLivraison> entities) throws ParseException;

    default PrestataireZoneLivraisonDto toLiteDto(PrestataireZoneLivraison entity) {
		if (entity == null) {
			return null;
		}
		PrestataireZoneLivraisonDto dto = new PrestataireZoneLivraisonDto();
		dto.setId( entity.getId() );
		dto.setLibelle( entity.getLibelle() );
		return dto;
    }

	default List<PrestataireZoneLivraisonDto> toLiteDtos(List<PrestataireZoneLivraison> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<PrestataireZoneLivraisonDto> dtos = new ArrayList<PrestataireZoneLivraisonDto>();
		for (PrestataireZoneLivraison entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.description", target="description"),
		@Mapping(source="dto.libelle", target="libelle"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="dto.dateFin", dateFormat="dd/MM/yyyy",target="dateFin"),
		@Mapping(source="zoneLivraison", target="zoneLivraison"),
		@Mapping(source="prestation", target="prestation"),
	})
    PrestataireZoneLivraison toEntity(PrestataireZoneLivraisonDto dto, ZoneLivraison zoneLivraison, Prestation prestation) throws ParseException;

    //List<PrestataireZoneLivraison> toEntities(List<PrestataireZoneLivraisonDto> dtos) throws ParseException;

}
