                                                                															
/*
 * Java business for entity table evaluation_command 
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
import com.wdy.brobrosseur.dao.entity.EvaluationCommand;
import com.wdy.brobrosseur.dao.entity.Command;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "evaluation_command"
 * 
 * @author Geo
 *
 */

@Component
public class EvaluationCommandBusiness implements IBasicBusiness<Request<EvaluationCommandDto>, Response<EvaluationCommandDto>> {

	private Response<EvaluationCommandDto> response;
	@Autowired
	private EvaluationCommandRepository evaluationCommandRepository;
	@Autowired
	private CommandRepository commandRepository;
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

	public EvaluationCommandBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create EvaluationCommand by using EvaluationCommandDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvaluationCommandDto> create(Request<EvaluationCommandDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create EvaluationCommand-----");

		Response<EvaluationCommandDto> response = new Response<EvaluationCommandDto>();
		List<EvaluationCommand>        items    = new ArrayList<EvaluationCommand>();
			
		for (EvaluationCommandDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("commandeId", dto.getCommandeId());
			fieldsToVerify.put("noteRapidite", dto.getNoteRapidite());
			fieldsToVerify.put("notePrestation", dto.getNotePrestation());
			fieldsToVerify.put("noteConservation", dto.getNoteConservation());
			fieldsToVerify.put("commentairePrestation", dto.getCommentairePrestation());
			fieldsToVerify.put("dateEvaluation", dto.getDateEvaluation());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if evaluationCommand to insert do not exist
			EvaluationCommand existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("evaluationCommand id -> " + dto.getId(), locale));
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
				EvaluationCommand entityToSave = null;
			entityToSave = EvaluationCommandTransformer.INSTANCE.toEntity(dto, existingCommand);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<EvaluationCommand> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = evaluationCommandRepository.saveAll((Iterable<EvaluationCommand>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("evaluationCommand", locale));
				response.setHasError(true);
				return response;
			}
			List<EvaluationCommandDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? EvaluationCommandTransformer.INSTANCE.toLiteDtos(itemsSaved) : EvaluationCommandTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create EvaluationCommand-----");
		return response;
	}

	/**
	 * update EvaluationCommand by using EvaluationCommandDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvaluationCommandDto> update(Request<EvaluationCommandDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update EvaluationCommand-----");

		Response<EvaluationCommandDto> response = new Response<EvaluationCommandDto>();
		List<EvaluationCommand>        items    = new ArrayList<EvaluationCommand>();
			
		for (EvaluationCommandDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la evaluationCommand existe
			EvaluationCommand entityToSave = null;
			entityToSave = evaluationCommandRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("evaluationCommand id -> " + dto.getId(), locale));
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
			if (dto.getNoteRapidite() != null && dto.getNoteRapidite() > 0) {
				entityToSave.setNoteRapidite(dto.getNoteRapidite());
			}
			if (dto.getNotePrestation() != null && dto.getNotePrestation() > 0) {
				entityToSave.setNotePrestation(dto.getNotePrestation());
			}
			if (dto.getNoteConservation() != null && dto.getNoteConservation() > 0) {
				entityToSave.setNoteConservation(dto.getNoteConservation());
			}
			if (Utilities.notBlank(dto.getCommentairePrestation())) {
				entityToSave.setCommentairePrestation(dto.getCommentairePrestation());
			}
			if (dto.getDateEvaluation() != null) {
				entityToSave.setDateEvaluation(dto.getDateEvaluation());
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
			List<EvaluationCommand> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = evaluationCommandRepository.saveAll((Iterable<EvaluationCommand>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("evaluationCommand", locale));
				response.setHasError(true);
				return response;
			}
			List<EvaluationCommandDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? EvaluationCommandTransformer.INSTANCE.toLiteDtos(itemsSaved) : EvaluationCommandTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update EvaluationCommand-----");
		return response;
	}

	/**
	 * delete EvaluationCommand by using EvaluationCommandDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvaluationCommandDto> delete(Request<EvaluationCommandDto> request, Locale locale)  {
		// System.out.println("----begin delete EvaluationCommand-----");

		Response<EvaluationCommandDto> response = new Response<EvaluationCommandDto>();
		List<EvaluationCommand>        items    = new ArrayList<EvaluationCommand>();
			
		for (EvaluationCommandDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la evaluationCommand existe
			EvaluationCommand existingEntity = null;

			existingEntity = evaluationCommandRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("evaluationCommand -> " + dto.getId(), locale));
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
			evaluationCommandRepository.saveAll((Iterable<EvaluationCommand>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete EvaluationCommand-----");
		return response;
	}

	/**
	 * get EvaluationCommand by using EvaluationCommandDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<EvaluationCommandDto> getByCriteria(Request<EvaluationCommandDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get EvaluationCommand-----");

		Response<EvaluationCommandDto> response = new Response<EvaluationCommandDto>();
		List<EvaluationCommand> items 			 = evaluationCommandRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<EvaluationCommandDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? EvaluationCommandTransformer.INSTANCE.toLiteDtos(items) : EvaluationCommandTransformer.INSTANCE.toDtos(items);

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
			response.setCount(evaluationCommandRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("evaluationCommand", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get EvaluationCommand-----");
		return response;
	}

	/**
	 * get full EvaluationCommandDto by using EvaluationCommand as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private EvaluationCommandDto getFullInfos(EvaluationCommandDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
