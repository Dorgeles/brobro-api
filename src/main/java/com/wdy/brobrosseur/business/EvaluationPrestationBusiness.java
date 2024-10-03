                                                            														
/*
 * Java business for entity table evaluation_prestation 
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
import com.wdy.brobrosseur.dao.entity.EvaluationPrestation;
import com.wdy.brobrosseur.dao.entity.Command;
import com.wdy.brobrosseur.dao.entity.Prestation;
import com.wdy.brobrosseur.dao.entity.Customer;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "evaluation_prestation"
 * 
 * @author Geo
 *
 */

@Component
public class EvaluationPrestationBusiness implements IBasicBusiness<Request<EvaluationPrestationDto>, Response<EvaluationPrestationDto>> {

	private Response<EvaluationPrestationDto> response;
	@Autowired
	private EvaluationPrestationRepository evaluationPrestationRepository;
	@Autowired
	private CommandRepository commandRepository;
	@Autowired
	private PrestationRepository prestationRepository;
	@Autowired
	private CustomerRepository customerRepository;
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

	public EvaluationPrestationBusiness() {
		dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateTimeFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	}
	
	/**
	 * create EvaluationPrestation by using EvaluationPrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvaluationPrestationDto> create(Request<EvaluationPrestationDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create EvaluationPrestation-----");

		Response<EvaluationPrestationDto> response = new Response<EvaluationPrestationDto>();
		List<EvaluationPrestation>        items    = new ArrayList<EvaluationPrestation>();
			
		for (EvaluationPrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("customerId", dto.getCustomerId());
			fieldsToVerify.put("prestationId", dto.getPrestationId());
			fieldsToVerify.put("commandeId", dto.getCommandeId());
			fieldsToVerify.put("note", dto.getNote());
			fieldsToVerify.put("commentaire", dto.getCommentaire());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if evaluationPrestation to insert do not exist
			EvaluationPrestation existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("evaluationPrestation id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if command exist
			Command existingCommand = null;
			if (dto.getCommandeId() != null && dto.getCommandeId() > 0){
				existingCommand = commandRepository.findOne(dto.getCommandeId(), false);
				if (existingCommand == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("command commandeId -> " + dto.getCommandeId(), locale));
					response.setHasError(true);
					return response;
				}
			}
			// Verify if prestation exist
			Prestation existingPrestation = null;
			if (dto.getPrestationId() != null && dto.getPrestationId() > 0){
				existingPrestation = prestationRepository.findOne(dto.getPrestationId(), false);
				if (existingPrestation == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("prestation prestationId -> " + dto.getPrestationId(), locale));
					response.setHasError(true);
					return response;
				}
			}
			// Verify if customer exist
			Customer existingCustomer = null;
			if (dto.getCustomerId() != null && dto.getCustomerId() > 0){
				existingCustomer = customerRepository.findOne(dto.getCustomerId(), false);
				if (existingCustomer == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("customer customerId -> " + dto.getCustomerId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				EvaluationPrestation entityToSave = null;
			entityToSave = EvaluationPrestationTransformer.INSTANCE.toEntity(dto, existingCommand, existingPrestation, existingCustomer);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<EvaluationPrestation> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = evaluationPrestationRepository.saveAll((Iterable<EvaluationPrestation>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("evaluationPrestation", locale));
				response.setHasError(true);
				return response;
			}
			List<EvaluationPrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? EvaluationPrestationTransformer.INSTANCE.toLiteDtos(itemsSaved) : EvaluationPrestationTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create EvaluationPrestation-----");
		return response;
	}

	/**
	 * update EvaluationPrestation by using EvaluationPrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvaluationPrestationDto> update(Request<EvaluationPrestationDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update EvaluationPrestation-----");

		Response<EvaluationPrestationDto> response = new Response<EvaluationPrestationDto>();
		List<EvaluationPrestation>        items    = new ArrayList<EvaluationPrestation>();
			
		for (EvaluationPrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la evaluationPrestation existe
			EvaluationPrestation entityToSave = null;
			entityToSave = evaluationPrestationRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("evaluationPrestation id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if command exist
			if (dto.getCommandeId() != null && dto.getCommandeId() > 0){
				Command existingCommand = commandRepository.findOne(dto.getCommandeId(), false);
				if (existingCommand == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("command commandeId -> " + dto.getCommandeId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setCommand(existingCommand);
			}
			// Verify if prestation exist
			if (dto.getPrestationId() != null && dto.getPrestationId() > 0){
				Prestation existingPrestation = prestationRepository.findOne(dto.getPrestationId(), false);
				if (existingPrestation == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("prestation prestationId -> " + dto.getPrestationId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setPrestation(existingPrestation);
			}
			// Verify if customer exist
			if (dto.getCustomerId() != null && dto.getCustomerId() > 0){
				Customer existingCustomer = customerRepository.findOne(dto.getCustomerId(), false);
				if (existingCustomer == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("customer customerId -> " + dto.getCustomerId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setCustomer(existingCustomer);
			}
			if (dto.getNote() != null && dto.getNote() > 0) {
				entityToSave.setNote(dto.getNote());
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
			List<EvaluationPrestation> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = evaluationPrestationRepository.saveAll((Iterable<EvaluationPrestation>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("evaluationPrestation", locale));
				response.setHasError(true);
				return response;
			}
			List<EvaluationPrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? EvaluationPrestationTransformer.INSTANCE.toLiteDtos(itemsSaved) : EvaluationPrestationTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update EvaluationPrestation-----");
		return response;
	}

	/**
	 * delete EvaluationPrestation by using EvaluationPrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvaluationPrestationDto> delete(Request<EvaluationPrestationDto> request, Locale locale)  {
		// System.out.println("----begin delete EvaluationPrestation-----");

		Response<EvaluationPrestationDto> response = new Response<EvaluationPrestationDto>();
		List<EvaluationPrestation>        items    = new ArrayList<EvaluationPrestation>();
			
		for (EvaluationPrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la evaluationPrestation existe
			EvaluationPrestation existingEntity = null;

			existingEntity = evaluationPrestationRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("evaluationPrestation -> " + dto.getId(), locale));
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
			evaluationPrestationRepository.saveAll((Iterable<EvaluationPrestation>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete EvaluationPrestation-----");
		return response;
	}

	/**
	 * get EvaluationPrestation by using EvaluationPrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvaluationPrestationDto> getByCriteria(Request<EvaluationPrestationDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get EvaluationPrestation-----");

		Response<EvaluationPrestationDto> response = new Response<EvaluationPrestationDto>();
		List<EvaluationPrestation> items 			 = evaluationPrestationRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<EvaluationPrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? EvaluationPrestationTransformer.INSTANCE.toLiteDtos(items) : EvaluationPrestationTransformer.INSTANCE.toDtos(items);

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
			response.setCount(evaluationPrestationRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("evaluationPrestation", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get EvaluationPrestation-----");
		return response;
	}

	/**
	 * get full EvaluationPrestationDto by using EvaluationPrestation as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private EvaluationPrestationDto getFullInfos(EvaluationPrestationDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
