

/*
 * Java transformer for entity table utilisateur_role 
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
 * TRANSFORMER for table "utilisateur_role"
 * 
 * @author Geo
 *
 */
@Mapper
public interface UtilisateurRoleTransformer {

	UtilisateurRoleTransformer INSTANCE = Mappers.getMapper(UtilisateurRoleTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="entity.role.id", target="roleId"),
		@Mapping(source="entity.role.libelle", target="roleLibelle"),
		@Mapping(source="entity.utilisateur.id", target="utilisateurId"),
		@Mapping(source="entity.utilisateur.nom", target="utilisateurNom"),
		@Mapping(source="entity.utilisateur.prenom", target="utilisateurPrenom"),
	})
	UtilisateurRoleDto toDto(UtilisateurRole entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<UtilisateurRoleDto> toDtos(List<UtilisateurRole> entities) throws ParseException;

    default UtilisateurRoleDto toLiteDto(UtilisateurRole entity) {
		if (entity == null) {
			return null;
		}
		UtilisateurRoleDto dto = new UtilisateurRoleDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<UtilisateurRoleDto> toLiteDtos(List<UtilisateurRole> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<UtilisateurRoleDto> dtos = new ArrayList<UtilisateurRoleDto>();
		for (UtilisateurRole entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.commentaire", target="commentaire"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="dd/MM/yyyy",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="dd/MM/yyyy",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="dd/MM/yyyy",target="createdAt"),
		@Mapping(source="role", target="role"),
		@Mapping(source="utilisateur", target="utilisateur"),
	})
    UtilisateurRole toEntity(UtilisateurRoleDto dto, Role role, Utilisateur utilisateur) throws ParseException;

    //List<UtilisateurRole> toEntities(List<UtilisateurRoleDto> dtos) throws ParseException;

}
