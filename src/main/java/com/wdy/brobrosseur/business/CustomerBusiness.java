                                            										
/*
 * Java business for entity table customer 
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
import com.wdy.brobrosseur.dao.entity.Customer;
import com.wdy.brobrosseur.dao.entity.Utilisateur;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "customer"
 * 
 * @author Geo
 *
 */

@Component
public class CustomerBusiness implements IBasicBusiness<Request<CustomerDto>, Response<CustomerDto>> {

	private Response<CustomerDto> response;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private UtilisateurBusiness utilisateurBusiness;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private EvaluationPrestationRepository evaluationPrestationRepository;
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

	public CustomerBusiness() {
		dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateTimeFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	}
	
	/**
	 * create Customer by using CustomerDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CustomerDto> create(Request<CustomerDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Customer-----");

		Response<CustomerDto> response = new Response<CustomerDto>();
		List<Customer>        items    = new ArrayList<Customer>();
			
		for (CustomerDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("utilisateur", dto.getUtilisateur());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if customer to insert do not exist
			Customer existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("customer id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if utilisateur exist
			Utilisateur existingUtilisateur = null;
			if (dto.getUtilisateur().getId() != null && dto.getUtilisateur().getId()  > 0){
				existingUtilisateur = utilisateurRepository.findOne(dto.getUtilisateur().getId(), false);
				if (existingUtilisateur == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("utilisateur utilisateurId -> " + dto.getUtilisateurId(), locale));
					response.setHasError(true);
					return response;
				}
			}

			// création de l'utilisateur
			Request<UtilisateurDto> reqUtilisateur = new Request<UtilisateurDto>();
			reqUtilisateur.setUser(1);
			reqUtilisateur.setDatas(Arrays.asList(dto.getUtilisateur()));
			Response<UtilisateurDto> respUtilisateur = utilisateurBusiness.create(reqUtilisateur, locale);
			if (Utilities.isEmpty(respUtilisateur.getItems())) {
				response.setStatus(respUtilisateur.getStatus());
				response.setHasError(true);
				return response;
			}
			Customer entityToSave = null;
			entityToSave = CustomerTransformer.INSTANCE.toEntity(dto, existingUtilisateur);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Customer> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = customerRepository.saveAll((Iterable<Customer>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("customer", locale));
				response.setHasError(true);
				return response;
			}
			List<CustomerDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CustomerTransformer.INSTANCE.toLiteDtos(itemsSaved) : CustomerTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create Customer-----");
		return response;
	}

	/**
	 * update Customer by using CustomerDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CustomerDto> update(Request<CustomerDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Customer-----");

		Response<CustomerDto> response = new Response<CustomerDto>();
		List<Customer>        items    = new ArrayList<Customer>();
			
		for (CustomerDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la customer existe
			Customer entityToSave = null;
			entityToSave = customerRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("customer id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
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
			List<Customer> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = customerRepository.saveAll((Iterable<Customer>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("customer", locale));
				response.setHasError(true);
				return response;
			}
			List<CustomerDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CustomerTransformer.INSTANCE.toLiteDtos(itemsSaved) : CustomerTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update Customer-----");
		return response;
	}

	/**
	 * delete Customer by using CustomerDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CustomerDto> delete(Request<CustomerDto> request, Locale locale)  {
		// System.out.println("----begin delete Customer-----");

		Response<CustomerDto> response = new Response<CustomerDto>();
		List<Customer>        items    = new ArrayList<Customer>();
			
		for (CustomerDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la customer existe
			Customer existingEntity = null;

			existingEntity = customerRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("customer -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// evaluationPrestation
			List<EvaluationPrestation> listOfEvaluationPrestation = evaluationPrestationRepository.findByCustomerId(existingEntity.getId(), false);
			if (listOfEvaluationPrestation != null && !listOfEvaluationPrestation.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfEvaluationPrestation.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// command
			List<Command> listOfCommand = commandRepository.findByConsommateurId(existingEntity.getId(), false);
			if (listOfCommand != null && !listOfCommand.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfCommand.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			customerRepository.saveAll((Iterable<Customer>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Customer-----");
		return response;
	}

	/**
	 * get Customer by using CustomerDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CustomerDto> getByCriteria(Request<CustomerDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Customer-----");

		Response<CustomerDto> response = new Response<CustomerDto>();
		List<Customer> items 			 = customerRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<CustomerDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CustomerTransformer.INSTANCE.toLiteDtos(items) : CustomerTransformer.INSTANCE.toDtos(items);

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
			response.setCount(customerRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("customer", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Customer-----");
		return response;
	}

	/**
	 * get full CustomerDto by using Customer as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private CustomerDto getFullInfos(CustomerDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
