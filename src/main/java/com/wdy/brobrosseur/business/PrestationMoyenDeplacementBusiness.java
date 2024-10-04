                                                        													
/*
 * Java business for entity table prestation_moyen_deplacement 
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
import com.wdy.brobrosseur.dao.entity.PrestationMoyenDeplacement;
import com.wdy.brobrosseur.dao.entity.MoyenDeplacement;
import com.wdy.brobrosseur.dao.entity.Prestation;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "prestation_moyen_deplacement"
 * 
 * @author Geo
 *
 */

@Component
public class PrestationMoyenDeplacementBusiness implements IBasicBusiness<Request<PrestationMoyenDeplacementDto>, Response<PrestationMoyenDeplacementDto>> {

	private Response<PrestationMoyenDeplacementDto> response;
	@Autowired
	private PrestationMoyenDeplacementRepository prestationMoyenDeplacementRepository;
	@Autowired
	private MoyenDeplacementRepository moyenDeplacementRepository;
	@Autowired
	private PrestationRepository prestationRepository;
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

	public PrestationMoyenDeplacementBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create PrestationMoyenDeplacement by using PrestationMoyenDeplacementDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestationMoyenDeplacementDto> create(Request<PrestationMoyenDeplacementDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create PrestationMoyenDeplacement-----");

		Response<PrestationMoyenDeplacementDto> response = new Response<PrestationMoyenDeplacementDto>();
		List<PrestationMoyenDeplacement>        items    = new ArrayList<PrestationMoyenDeplacement>();
			
		for (PrestationMoyenDeplacementDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("presatationId", dto.getPresatationId());
			fieldsToVerify.put("moyenDeplacementId", dto.getMoyenDeplacementId());
			fieldsToVerify.put("dateDebut", dto.getDateDebut());
			fieldsToVerify.put("dateFin", dto.getDateFin());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if prestationMoyenDeplacement to insert do not exist
			PrestationMoyenDeplacement existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("prestationMoyenDeplacement id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if moyenDeplacement exist
			MoyenDeplacement existingMoyenDeplacement = null;
			if (dto.getMoyenDeplacementId() != null && dto.getMoyenDeplacementId() > 0){
				existingMoyenDeplacement = moyenDeplacementRepository.findOne(dto.getMoyenDeplacementId(), false);
				if (existingMoyenDeplacement == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("moyenDeplacement moyenDeplacementId -> " + dto.getMoyenDeplacementId(), locale));
					response.setHasError(true);
					return response;
				}
			}
			// Verify if prestation exist
			Prestation existingPrestation = null;
			if (dto.getPresatationId() != null && dto.getPresatationId() > 0){
				existingPrestation = prestationRepository.findOne(dto.getPresatationId(), false);
				if (existingPrestation == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("prestation presatationId -> " + dto.getPresatationId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				PrestationMoyenDeplacement entityToSave = null;
			entityToSave = PrestationMoyenDeplacementTransformer.INSTANCE.toEntity(dto, existingMoyenDeplacement, existingPrestation);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<PrestationMoyenDeplacement> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = prestationMoyenDeplacementRepository.saveAll((Iterable<PrestationMoyenDeplacement>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prestationMoyenDeplacement", locale));
				response.setHasError(true);
				return response;
			}
			List<PrestationMoyenDeplacementDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrestationMoyenDeplacementTransformer.INSTANCE.toLiteDtos(itemsSaved) : PrestationMoyenDeplacementTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create PrestationMoyenDeplacement-----");
		return response;
	}

	/**
	 * update PrestationMoyenDeplacement by using PrestationMoyenDeplacementDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestationMoyenDeplacementDto> update(Request<PrestationMoyenDeplacementDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update PrestationMoyenDeplacement-----");

		Response<PrestationMoyenDeplacementDto> response = new Response<PrestationMoyenDeplacementDto>();
		List<PrestationMoyenDeplacement>        items    = new ArrayList<PrestationMoyenDeplacement>();
			
		for (PrestationMoyenDeplacementDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prestationMoyenDeplacement existe
			PrestationMoyenDeplacement entityToSave = null;
			entityToSave = prestationMoyenDeplacementRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prestationMoyenDeplacement id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if moyenDeplacement exist
			if (dto.getMoyenDeplacementId() != null && dto.getMoyenDeplacementId() > 0){
				MoyenDeplacement existingMoyenDeplacement = moyenDeplacementRepository.findOne(dto.getMoyenDeplacementId(), false);
				if (existingMoyenDeplacement == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("moyenDeplacement moyenDeplacementId -> " + dto.getMoyenDeplacementId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setMoyenDeplacement(existingMoyenDeplacement);
			}
			// Verify if prestation exist
			if (dto.getPresatationId() != null && dto.getPresatationId() > 0){
				Prestation existingPrestation = prestationRepository.findOne(dto.getPresatationId(), false);
				if (existingPrestation == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("prestation presatationId -> " + dto.getPresatationId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setPrestation(existingPrestation);
			}
			if (Utilities.notBlank(dto.getDateDebut())) {
				entityToSave.setDateDebut(dateFormat.parse(dto.getDateDebut()));
			}
			if (Utilities.notBlank(dto.getDateFin())) {
				entityToSave.setDateFin(dateFormat.parse(dto.getDateFin()));
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
			List<PrestationMoyenDeplacement> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = prestationMoyenDeplacementRepository.saveAll((Iterable<PrestationMoyenDeplacement>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prestationMoyenDeplacement", locale));
				response.setHasError(true);
				return response;
			}
			List<PrestationMoyenDeplacementDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrestationMoyenDeplacementTransformer.INSTANCE.toLiteDtos(itemsSaved) : PrestationMoyenDeplacementTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update PrestationMoyenDeplacement-----");
		return response;
	}

	/**
	 * delete PrestationMoyenDeplacement by using PrestationMoyenDeplacementDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestationMoyenDeplacementDto> delete(Request<PrestationMoyenDeplacementDto> request, Locale locale)  {
		// System.out.println("----begin delete PrestationMoyenDeplacement-----");

		Response<PrestationMoyenDeplacementDto> response = new Response<PrestationMoyenDeplacementDto>();
		List<PrestationMoyenDeplacement>        items    = new ArrayList<PrestationMoyenDeplacement>();
			
		for (PrestationMoyenDeplacementDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prestationMoyenDeplacement existe
			PrestationMoyenDeplacement existingEntity = null;

			existingEntity = prestationMoyenDeplacementRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prestationMoyenDeplacement -> " + dto.getId(), locale));
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
			prestationMoyenDeplacementRepository.saveAll((Iterable<PrestationMoyenDeplacement>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete PrestationMoyenDeplacement-----");
		return response;
	}

	/**
	 * get PrestationMoyenDeplacement by using PrestationMoyenDeplacementDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestationMoyenDeplacementDto> getByCriteria(Request<PrestationMoyenDeplacementDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get PrestationMoyenDeplacement-----");

		Response<PrestationMoyenDeplacementDto> response = new Response<PrestationMoyenDeplacementDto>();
		List<PrestationMoyenDeplacement> items 			 = prestationMoyenDeplacementRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<PrestationMoyenDeplacementDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrestationMoyenDeplacementTransformer.INSTANCE.toLiteDtos(items) : PrestationMoyenDeplacementTransformer.INSTANCE.toDtos(items);

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
			response.setCount(prestationMoyenDeplacementRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("prestationMoyenDeplacement", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get PrestationMoyenDeplacement-----");
		return response;
	}

	/**
	 * get full PrestationMoyenDeplacementDto by using PrestationMoyenDeplacement as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private PrestationMoyenDeplacementDto getFullInfos(PrestationMoyenDeplacementDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
