                                                											
/*
 * Java business for entity table type_client 
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
import com.wdy.brobrosseur.dao.entity.TypeClient;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "type_client"
 * 
 * @author Geo
 *
 */

@Component
public class TypeClientBusiness implements IBasicBusiness<Request<TypeClientDto>, Response<TypeClientDto>> {

	private Response<TypeClientDto> response;
	@Autowired
	private TypeClientRepository typeClientRepository;
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

	public TypeClientBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create TypeClient by using TypeClientDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<TypeClientDto> create(Request<TypeClientDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create TypeClient-----");

		Response<TypeClientDto> response = new Response<TypeClientDto>();
		List<TypeClient>        items    = new ArrayList<TypeClient>();
			
		for (TypeClientDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("description", dto.getDescription());
			fieldsToVerify.put("libelle", dto.getLibelle());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if typeClient to insert do not exist
			TypeClient existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("typeClient id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// verif unique libelle in db
			existingEntity = typeClientRepository.findByLibelle(dto.getLibelle(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("typeClient libelle -> " + dto.getLibelle(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique libelle in items to save
			if (items.stream().anyMatch(a -> a.getLibelle().equalsIgnoreCase(dto.getLibelle()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" libelle ", locale));
				response.setHasError(true);
				return response;
			}

				TypeClient entityToSave = null;
			entityToSave = TypeClientTransformer.INSTANCE.toEntity(dto);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<TypeClient> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = typeClientRepository.saveAll((Iterable<TypeClient>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("typeClient", locale));
				response.setHasError(true);
				return response;
			}
			List<TypeClientDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? TypeClientTransformer.INSTANCE.toLiteDtos(itemsSaved) : TypeClientTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create TypeClient-----");
		return response;
	}

	/**
	 * update TypeClient by using TypeClientDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<TypeClientDto> update(Request<TypeClientDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update TypeClient-----");

		Response<TypeClientDto> response = new Response<TypeClientDto>();
		List<TypeClient>        items    = new ArrayList<TypeClient>();
			
		for (TypeClientDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la typeClient existe
			TypeClient entityToSave = null;
			entityToSave = typeClientRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("typeClient id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getDescription())) {
				entityToSave.setDescription(dto.getDescription());
			}
			if (Utilities.notBlank(dto.getLibelle())) {
				entityToSave.setLibelle(dto.getLibelle());
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
			List<TypeClient> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = typeClientRepository.saveAll((Iterable<TypeClient>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("typeClient", locale));
				response.setHasError(true);
				return response;
			}
			List<TypeClientDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? TypeClientTransformer.INSTANCE.toLiteDtos(itemsSaved) : TypeClientTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update TypeClient-----");
		return response;
	}

	/**
	 * delete TypeClient by using TypeClientDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<TypeClientDto> delete(Request<TypeClientDto> request, Locale locale)  {
		// System.out.println("----begin delete TypeClient-----");

		Response<TypeClientDto> response = new Response<TypeClientDto>();
		List<TypeClient>        items    = new ArrayList<TypeClient>();
			
		for (TypeClientDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la typeClient existe
			TypeClient existingEntity = null;

			existingEntity = typeClientRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("typeClient -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// utilisateur
			List<Utilisateur> listOfUtilisateur = utilisateurRepository.findByTypeClientId(existingEntity.getId(), false);
			if (listOfUtilisateur != null && !listOfUtilisateur.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUtilisateur.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			typeClientRepository.saveAll((Iterable<TypeClient>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete TypeClient-----");
		return response;
	}

	/**
	 * get TypeClient by using TypeClientDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<TypeClientDto> getByCriteria(Request<TypeClientDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get TypeClient-----");

		Response<TypeClientDto> response = new Response<TypeClientDto>();
		List<TypeClient> items 			 = typeClientRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<TypeClientDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? TypeClientTransformer.INSTANCE.toLiteDtos(items) : TypeClientTransformer.INSTANCE.toDtos(items);

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
			response.setCount(typeClientRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("typeClient", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get TypeClient-----");
		return response;
	}

	/**
	 * get full TypeClientDto by using TypeClient as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private TypeClientDto getFullInfos(TypeClientDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
