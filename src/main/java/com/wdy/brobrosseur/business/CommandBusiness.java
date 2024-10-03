                                                                															
/*
 * Java business for entity table command 
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
import com.wdy.brobrosseur.dao.entity.Command;
import com.wdy.brobrosseur.dao.entity.Customer;
import com.wdy.brobrosseur.dao.entity.Prestation;
import com.wdy.brobrosseur.dao.entity.Coursier;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "command"
 * 
 * @author Geo
 *
 */

@Component
public class CommandBusiness implements IBasicBusiness<Request<CommandDto>, Response<CommandDto>> {

	private Response<CommandDto> response;
	@Autowired
	private CommandRepository commandRepository;
	@Autowired
	private EvaluationCommandRepository evaluationCommandRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PrestationRepository prestationRepository;
	@Autowired
	private EvaluationPrestationRepository evaluationPrestationRepository;
	@Autowired
	private CoursierRepository coursierRepository;
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

	public CommandBusiness() {
		dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateTimeFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	}
	
	/**
	 * create Command by using CommandDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CommandDto> create(Request<CommandDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Command-----");

		Response<CommandDto> response = new Response<CommandDto>();
		List<Command>        items    = new ArrayList<Command>();
			
		for (CommandDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("consommateurId", dto.getConsommateurId());
			fieldsToVerify.put("coursierId", dto.getCoursierId());
			fieldsToVerify.put("prestationId", dto.getPrestationId());
			fieldsToVerify.put("typeCommand", dto.getTypeCommand());
			fieldsToVerify.put("latitudeLivraison", dto.getLatitudeLivraison());
			fieldsToVerify.put("longitudeLivraison", dto.getLongitudeLivraison());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if command to insert do not exist
			Command existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("command id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if customer exist
			Customer existingCustomer = null;
			if (dto.getConsommateurId() != null && dto.getConsommateurId() > 0){
				existingCustomer = customerRepository.findOne(dto.getConsommateurId(), false);
				if (existingCustomer == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("customer consommateurId -> " + dto.getConsommateurId(), locale));
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
			// Verify if coursier exist
			Coursier existingCoursier = null;
			if (dto.getCoursierId() != null && dto.getCoursierId() > 0){
				existingCoursier = coursierRepository.findOne(dto.getCoursierId(), false);
				if (existingCoursier == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("coursier coursierId -> " + dto.getCoursierId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				Command entityToSave = null;
			entityToSave = CommandTransformer.INSTANCE.toEntity(dto, existingCustomer, existingPrestation, existingCoursier);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Command> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = commandRepository.saveAll((Iterable<Command>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("command", locale));
				response.setHasError(true);
				return response;
			}
			List<CommandDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CommandTransformer.INSTANCE.toLiteDtos(itemsSaved) : CommandTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create Command-----");
		return response;
	}

	/**
	 * update Command by using CommandDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CommandDto> update(Request<CommandDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Command-----");

		Response<CommandDto> response = new Response<CommandDto>();
		List<Command>        items    = new ArrayList<Command>();
			
		for (CommandDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la command existe
			Command entityToSave = null;
			entityToSave = commandRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("command id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if customer exist
			if (dto.getConsommateurId() != null && dto.getConsommateurId() > 0){
				Customer existingCustomer = customerRepository.findOne(dto.getConsommateurId(), false);
				if (existingCustomer == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("customer consommateurId -> " + dto.getConsommateurId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setCustomer(existingCustomer);
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
			// Verify if coursier exist
			if (dto.getCoursierId() != null && dto.getCoursierId() > 0){
				Coursier existingCoursier = coursierRepository.findOne(dto.getCoursierId(), false);
				if (existingCoursier == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("coursier coursierId -> " + dto.getCoursierId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setCoursier(existingCoursier);
			}
			if (Utilities.notBlank(dto.getTypeCommand())) {
				entityToSave.setTypeCommand(dto.getTypeCommand());
			}
			if (Utilities.notBlank(dto.getLatitudeLivraison())) {
				entityToSave.setLatitudeLivraison(dto.getLatitudeLivraison());
			}
			if (Utilities.notBlank(dto.getLongitudeLivraison())) {
				entityToSave.setLongitudeLivraison(dto.getLongitudeLivraison());
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
			List<Command> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = commandRepository.saveAll((Iterable<Command>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("command", locale));
				response.setHasError(true);
				return response;
			}
			List<CommandDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CommandTransformer.INSTANCE.toLiteDtos(itemsSaved) : CommandTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update Command-----");
		return response;
	}

	/**
	 * delete Command by using CommandDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CommandDto> delete(Request<CommandDto> request, Locale locale)  {
		// System.out.println("----begin delete Command-----");

		Response<CommandDto> response = new Response<CommandDto>();
		List<Command>        items    = new ArrayList<Command>();
			
		for (CommandDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la command existe
			Command existingEntity = null;

			existingEntity = commandRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("command -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// evaluationCommand
			List<EvaluationCommand> listOfEvaluationCommand = evaluationCommandRepository.findByCommandeId(existingEntity.getId(), false);
			if (listOfEvaluationCommand != null && !listOfEvaluationCommand.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfEvaluationCommand.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// evaluationPrestation
			List<EvaluationPrestation> listOfEvaluationPrestation = evaluationPrestationRepository.findByCommandeId(existingEntity.getId(), false);
			if (listOfEvaluationPrestation != null && !listOfEvaluationPrestation.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfEvaluationPrestation.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			commandRepository.saveAll((Iterable<Command>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Command-----");
		return response;
	}

	/**
	 * get Command by using CommandDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CommandDto> getByCriteria(Request<CommandDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Command-----");

		Response<CommandDto> response = new Response<CommandDto>();
		List<Command> items 			 = commandRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<CommandDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CommandTransformer.INSTANCE.toLiteDtos(items) : CommandTransformer.INSTANCE.toDtos(items);

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
			response.setCount(commandRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("command", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Command-----");
		return response;
	}

	/**
	 * get full CommandDto by using Command as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private CommandDto getFullInfos(CommandDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
