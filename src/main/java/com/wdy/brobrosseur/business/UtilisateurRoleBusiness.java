                                                    												
/*
 * Java business for entity table utilisateur_role 
 * Created on 2024-10-03 ( Time 13:00:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.business;

import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.wdy.brobrosseur.utils.*;
import com.wdy.brobrosseur.utils.dto.*;
import com.wdy.brobrosseur.utils.enums.*;
import com.wdy.brobrosseur.utils.contract.*;
import com.wdy.brobrosseur.utils.contract.IBasicBusiness;
import com.wdy.brobrosseur.utils.contract.Request;
import com.wdy.brobrosseur.utils.contract.Response;
import com.wdy.brobrosseur.utils.dto.transformer.*;
import com.wdy.brobrosseur.dao.entity.UtilisateurRole;
import com.wdy.brobrosseur.dao.entity.Role;
import com.wdy.brobrosseur.dao.entity.Utilisateur;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "utilisateur_role"
 * 
 * @author Geo
 *
 */

@Component
public class UtilisateurRoleBusiness implements IBasicBusiness<Request<UtilisateurRoleDto>, Response<UtilisateurRoleDto>> {

	private Response<UtilisateurRoleDto> response;
	@Autowired
	private UtilisateurRoleRepository utilisateurRoleRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private FunctionalError functionalError;
	@Autowired
	private TechnicalError technicalError;
	@Autowired
	private ExceptionUtils exceptionUtils;
	@PersistenceContext
	private EntityManager em;

	private SimpleDateFormat dateFormat;
	private SimpleDateFormat dateTimeFormat;

	public UtilisateurRoleBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create UtilisateurRole by using UtilisateurRoleDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurRoleDto> create(Request<UtilisateurRoleDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create UtilisateurRole-----");

		Response<UtilisateurRoleDto> response = new Response<UtilisateurRoleDto>();
		List<UtilisateurRole>        items    = new ArrayList<UtilisateurRole>();
			
		for (UtilisateurRoleDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("utilisateurId", dto.getUtilisateurId());
			fieldsToVerify.put("roleId", dto.getRoleId());
			fieldsToVerify.put("commentaire", dto.getCommentaire());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if utilisateurRole to insert do not exist
			UtilisateurRole existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("utilisateurRole id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if role exist
			Role existingRole = null;
			if (dto.getRoleId() != null && dto.getRoleId() > 0){
				existingRole = roleRepository.findOne(dto.getRoleId(), false);
				if (existingRole == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("role roleId -> " + dto.getRoleId(), locale));
					response.setHasError(true);
					return response;
				}
			}
			// Verify if utilisateur exist
			Utilisateur existingUtilisateur = null;
			if (dto.getUtilisateurId() != null && dto.getUtilisateurId() > 0){
				existingUtilisateur = utilisateurRepository.findOne(dto.getUtilisateurId(), false);
				if (existingUtilisateur == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("utilisateur utilisateurId -> " + dto.getUtilisateurId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				UtilisateurRole entityToSave = null;
			entityToSave = UtilisateurRoleTransformer.INSTANCE.toEntity(dto, existingRole, existingUtilisateur);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<UtilisateurRole> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = utilisateurRoleRepository.saveAll((Iterable<UtilisateurRole>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("utilisateurRole", locale));
				response.setHasError(true);
				return response;
			}
			List<UtilisateurRoleDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UtilisateurRoleTransformer.INSTANCE.toLiteDtos(itemsSaved) : UtilisateurRoleTransformer.INSTANCE.toDtos(itemsSaved);

			final int size = itemsSaved.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setHasError(false);
		}

		// System.out.println("----end create UtilisateurRole-----");
		return response;
	}

	/**
	 * update UtilisateurRole by using UtilisateurRoleDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurRoleDto> update(Request<UtilisateurRoleDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update UtilisateurRole-----");

		Response<UtilisateurRoleDto> response = new Response<UtilisateurRoleDto>();
		List<UtilisateurRole>        items    = new ArrayList<UtilisateurRole>();
			
		for (UtilisateurRoleDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la utilisateurRole existe
			UtilisateurRole entityToSave = null;
			entityToSave = utilisateurRoleRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("utilisateurRole id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if role exist
			if (dto.getRoleId() != null && dto.getRoleId() > 0){
				Role existingRole = roleRepository.findOne(dto.getRoleId(), false);
				if (existingRole == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("role roleId -> " + dto.getRoleId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setRole(existingRole);
			}
			// Verify if utilisateur exist
			if (dto.getUtilisateurId() != null && dto.getUtilisateurId() > 0){
				Utilisateur existingUtilisateur = utilisateurRepository.findOne(dto.getUtilisateurId(), false);
				if (existingUtilisateur == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("utilisateur utilisateurId -> " + dto.getUtilisateurId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setUtilisateur(existingUtilisateur);
			}
			if (Utilities.notBlank(dto.getCommentaire())) {
				entityToSave.setCommentaire(dto.getCommentaire());
			}
			if (dto.getStatusId() != null && dto.getStatusId() > 0) {
				entityToSave.setStatusId(dto.getStatusId());
			}
			if (dto.getUpdatedBy() != null && dto.getUpdatedBy() > 0) {
				entityToSave.setUpdatedBy(dto.getUpdatedBy());
			}
			if (dto.getCreatedBy() != null && dto.getCreatedBy() > 0) {
				entityToSave.setCreatedBy(dto.getCreatedBy());
			}
			if (Utilities.notBlank(dto.getDeletedAt())) {
				entityToSave.setDeletedAt(dateFormat.parse(dto.getDeletedAt()));
			}
			entityToSave.setUpdatedBy(request.getUser());
			entityToSave.setUpdatedAt(Utilities.getCurrentDate());
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<UtilisateurRole> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = utilisateurRoleRepository.saveAll((Iterable<UtilisateurRole>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("utilisateurRole", locale));
				response.setHasError(true);
				return response;
			}
			List<UtilisateurRoleDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UtilisateurRoleTransformer.INSTANCE.toLiteDtos(itemsSaved) : UtilisateurRoleTransformer.INSTANCE.toDtos(itemsSaved);

			final int size = itemsSaved.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setHasError(false);
		}

		// System.out.println("----end update UtilisateurRole-----");
		return response;
	}

	/**
	 * delete UtilisateurRole by using UtilisateurRoleDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurRoleDto> delete(Request<UtilisateurRoleDto> request, Locale locale)  {
		// System.out.println("----begin delete UtilisateurRole-----");

		Response<UtilisateurRoleDto> response = new Response<UtilisateurRoleDto>();
		List<UtilisateurRole>        items    = new ArrayList<UtilisateurRole>();
			
		for (UtilisateurRoleDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la utilisateurRole existe
			UtilisateurRole existingEntity = null;

			existingEntity = utilisateurRoleRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("utilisateurRole -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------



			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			utilisateurRoleRepository.saveAll((Iterable<UtilisateurRole>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete UtilisateurRole-----");
		return response;
	}

	/**
	 * get UtilisateurRole by using UtilisateurRoleDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurRoleDto> getByCriteria(Request<UtilisateurRoleDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get UtilisateurRole-----");

		Response<UtilisateurRoleDto> response = new Response<UtilisateurRoleDto>();
		List<UtilisateurRole> items 			 = utilisateurRoleRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<UtilisateurRoleDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UtilisateurRoleTransformer.INSTANCE.toLiteDtos(items) : UtilisateurRoleTransformer.INSTANCE.toDtos(items);

			final int size = items.size();
			List<String>  listOfError      = Collections.synchronizedList(new ArrayList<String>());
			itemsDto.parallelStream().forEach(dto -> {
				try {
					dto = getFullInfos(dto, size, request.getIsSimpleLoading(), locale);
				} catch (Exception e) {
					listOfError.add(e.getMessage());
					e.printStackTrace();
				}
			});
			if (Utilities.isNotEmpty(listOfError)) {
				Object[] objArray = listOfError.stream().distinct().toArray();
				throw new RuntimeException(StringUtils.join(objArray, ", "));
			}
			response.setItems(itemsDto);
			response.setCount(utilisateurRoleRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("utilisateurRole", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get UtilisateurRole-----");
		return response;
	}

	/**
	 * get full UtilisateurRoleDto by using UtilisateurRole as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private UtilisateurRoleDto getFullInfos(UtilisateurRoleDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
		// put code here

		if (Utilities.isTrue(isSimpleLoading)) {
			return dto;
		}
		if (size > 1) {
			return dto;
		}

		return dto;
	}
}
