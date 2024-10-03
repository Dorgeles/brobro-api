

/*
 * Java transformer for entity table command 
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
 * TRANSFORMER for table "command"
 * 
 * @author Geo
 *
 */
@Mapper
public interface CommandTransformer {

	CommandTransformer INSTANCE = Mappers.getMapper(CommandTransformer.class);

	@FullTransformerQualifier
	@Mappings({
		@Mapping(source="entity.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="entity.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="entity.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="entity.customer.id", target="consommateurId"),
		@Mapping(source="entity.prestation.id", target="prestationId"),
		@Mapping(source="entity.prestation.libelle", target="prestationLibelle"),
		@Mapping(source="entity.coursier.id", target="coursierId"),
	})
	CommandDto toDto(Command entity) throws ParseException;

	@IterableMapping(qualifiedBy = {FullTransformerQualifier.class})
    List<CommandDto> toDtos(List<Command> entities) throws ParseException;

    default CommandDto toLiteDto(Command entity) {
		if (entity == null) {
			return null;
		}
		CommandDto dto = new CommandDto();
		dto.setId( entity.getId() );
		return dto;
    }

	default List<CommandDto> toLiteDtos(List<Command> entities) {
		if (entities == null || entities.stream().allMatch(o -> o == null)) {
			return null;
		}
		List<CommandDto> dtos = new ArrayList<CommandDto>();
		for (Command entity : entities) {
			dtos.add(toLiteDto(entity));
		}
		return dtos;
	}

	@Mappings({
		@Mapping(source="dto.id", target="id"),
		@Mapping(source="dto.typeCommand", target="typeCommand"),
		@Mapping(source="dto.latitudeLivraison", target="latitudeLivraison"),
		@Mapping(source="dto.longitudeLivraison", target="longitudeLivraison"),
		@Mapping(source="dto.statusId", target="statusId"),
		@Mapping(source="dto.updatedBy", target="updatedBy"),
		@Mapping(source="dto.isDeleted", target="isDeleted"),
		@Mapping(source="dto.createdBy", target="createdBy"),
		@Mapping(source="dto.deletedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="deletedAt"),
		@Mapping(source="dto.updatedAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="updatedAt"),
		@Mapping(source="dto.createdAt", dateFormat="YYYY-MM-DD'T'HH:mm:ss.000'Z'",target="createdAt"),
		@Mapping(source="customer", target="customer"),
		@Mapping(source="prestation", target="prestation"),
		@Mapping(source="coursier", target="coursier"),
	})
    Command toEntity(CommandDto dto, Customer customer, Prestation prestation, Coursier coursier) throws ParseException;

    //List<Command> toEntities(List<CommandDto> dtos) throws ParseException;

}
