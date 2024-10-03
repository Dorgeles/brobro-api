                                                											
/*
 * Java business for entity table evalutation_projet 
 * Created on 2024-09-29 ( Time 22:05:54 )
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
import com.wdy.brobrosseur.dao.entity.EvalutationProjet;
import com.wdy.brobrosseur.dao.entity.Projet;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "evalutation_projet"
 * 
 * @author Geo
 *
 */

@Component
public class EvalutationProjetBusiness implements IBasicBusiness<Request<EvalutationProjetDto>, Response<EvalutationProjetDto>> {

	private Response<EvalutationProjetDto> response;
	@Autowired
	private EvalutationProjetRepository evalutationProjetRepository;
	@Autowired
	private ProjetRepository projetRepository;
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

	public EvalutationProjetBusiness() {
		dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateTimeFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	}
	
	/**
	 * create EvalutationProjet by using EvalutationProjetDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvalutationProjetDto> create(Request<EvalutationProjetDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create EvalutationProjet-----");

		Response<EvalutationProjetDto> response = new Response<EvalutationProjetDto>();
		List<EvalutationProjet>        items    = new ArrayList<EvalutationProjet>();
			
		for (EvalutationProjetDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("projetId", dto.getProjetId());
			fieldsToVerify.put("note", dto.getNote());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if evalutationProjet to insert do not exist
			EvalutationProjet existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("evalutationProjet id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if projet exist
			Projet existingProjet = null;
			if (dto.getProjetId() != null && dto.getProjetId() > 0){
				existingProjet = projetRepository.findOne(dto.getProjetId(), false);
				if (existingProjet == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("projet projetId -> " + dto.getProjetId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				EvalutationProjet entityToSave = null;
			entityToSave = EvalutationProjetTransformer.INSTANCE.toEntity(dto, existingProjet);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<EvalutationProjet> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = evalutationProjetRepository.saveAll((Iterable<EvalutationProjet>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("evalutationProjet", locale));
				response.setHasError(true);
				return response;
			}
			List<EvalutationProjetDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? EvalutationProjetTransformer.INSTANCE.toLiteDtos(itemsSaved) : EvalutationProjetTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create EvalutationProjet-----");
		return response;
	}

	/**
	 * update EvalutationProjet by using EvalutationProjetDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvalutationProjetDto> update(Request<EvalutationProjetDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update EvalutationProjet-----");

		Response<EvalutationProjetDto> response = new Response<EvalutationProjetDto>();
		List<EvalutationProjet>        items    = new ArrayList<EvalutationProjet>();
			
		for (EvalutationProjetDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la evalutationProjet existe
			EvalutationProjet entityToSave = null;
			entityToSave = evalutationProjetRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("evalutationProjet id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if projet exist
			if (dto.getProjetId() != null && dto.getProjetId() > 0){
				Projet existingProjet = projetRepository.findOne(dto.getProjetId(), false);
				if (existingProjet == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("projet projetId -> " + dto.getProjetId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setProjet(existingProjet);
			}
			if (dto.getNote() != null && dto.getNote() > 0) {
				entityToSave.setNote(dto.getNote());
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
			List<EvalutationProjet> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = evalutationProjetRepository.saveAll((Iterable<EvalutationProjet>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("evalutationProjet", locale));
				response.setHasError(true);
				return response;
			}
			List<EvalutationProjetDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? EvalutationProjetTransformer.INSTANCE.toLiteDtos(itemsSaved) : EvalutationProjetTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update EvalutationProjet-----");
		return response;
	}

	/**
	 * delete EvalutationProjet by using EvalutationProjetDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvalutationProjetDto> delete(Request<EvalutationProjetDto> request, Locale locale)  {
		// System.out.println("----begin delete EvalutationProjet-----");

		Response<EvalutationProjetDto> response = new Response<EvalutationProjetDto>();
		List<EvalutationProjet>        items    = new ArrayList<EvalutationProjet>();
			
		for (EvalutationProjetDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la evalutationProjet existe
			EvalutationProjet existingEntity = null;

			existingEntity = evalutationProjetRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("evalutationProjet -> " + dto.getId(), locale));
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
			evalutationProjetRepository.saveAll((Iterable<EvalutationProjet>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete EvalutationProjet-----");
		return response;
	}

	/**
	 * get EvalutationProjet by using EvalutationProjetDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvalutationProjetDto> getByCriteria(Request<EvalutationProjetDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get EvalutationProjet-----");

		Response<EvalutationProjetDto> response = new Response<EvalutationProjetDto>();
		List<EvalutationProjet> items 			 = evalutationProjetRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<EvalutationProjetDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? EvalutationProjetTransformer.INSTANCE.toLiteDtos(items) : EvalutationProjetTransformer.INSTANCE.toDtos(items);

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
			response.setCount(evalutationProjetRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("evalutationProjet", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get EvalutationProjet-----");
		return response;
	}

	/**
	 * get full EvalutationProjetDto by using EvalutationProjet as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private EvalutationProjetDto getFullInfos(EvalutationProjetDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
