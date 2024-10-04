                                                    												
/*
 * Java business for entity table activite_prestation 
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
import com.wdy.brobrosseur.dao.entity.ActivitePrestation;
import com.wdy.brobrosseur.dao.entity.Activite;
import com.wdy.brobrosseur.dao.entity.Prestation;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "activite_prestation"
 * 
 * @author Geo
 *
 */

@Component
public class ActivitePrestationBusiness implements IBasicBusiness<Request<ActivitePrestationDto>, Response<ActivitePrestationDto>> {

	private Response<ActivitePrestationDto> response;
	@Autowired
	private ActivitePrestationRepository activitePrestationRepository;
	@Autowired
	private ActiviteRepository activiteRepository;
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

	public ActivitePrestationBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create ActivitePrestation by using ActivitePrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ActivitePrestationDto> create(Request<ActivitePrestationDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create ActivitePrestation-----");

		Response<ActivitePrestationDto> response = new Response<ActivitePrestationDto>();
		List<ActivitePrestation>        items    = new ArrayList<ActivitePrestation>();
			
		for (ActivitePrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("activiteId", dto.getActiviteId());
			fieldsToVerify.put("prestationId", dto.getPrestationId());
			fieldsToVerify.put("description", dto.getDescription());
			fieldsToVerify.put("libelle", dto.getLibelle());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if activitePrestation to insert do not exist
			ActivitePrestation existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("activitePrestation id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// verif unique libelle in db
			existingEntity = activitePrestationRepository.findByLibelle(dto.getLibelle(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("activitePrestation libelle -> " + dto.getLibelle(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique libelle in items to save
			if (items.stream().anyMatch(a -> a.getLibelle().equalsIgnoreCase(dto.getLibelle()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" libelle ", locale));
				response.setHasError(true);
				return response;
			}

			// Verify if activite exist
			Activite existingActivite = null;
			if (dto.getActiviteId() != null && dto.getActiviteId() > 0){
				existingActivite = activiteRepository.findOne(dto.getActiviteId(), false);
				if (existingActivite == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("activite activiteId -> " + dto.getActiviteId(), locale));
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
				ActivitePrestation entityToSave = null;
			entityToSave = ActivitePrestationTransformer.INSTANCE.toEntity(dto, existingActivite, existingPrestation);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<ActivitePrestation> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = activitePrestationRepository.saveAll((Iterable<ActivitePrestation>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("activitePrestation", locale));
				response.setHasError(true);
				return response;
			}
			List<ActivitePrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ActivitePrestationTransformer.INSTANCE.toLiteDtos(itemsSaved) : ActivitePrestationTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create ActivitePrestation-----");
		return response;
	}

	/**
	 * update ActivitePrestation by using ActivitePrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ActivitePrestationDto> update(Request<ActivitePrestationDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update ActivitePrestation-----");

		Response<ActivitePrestationDto> response = new Response<ActivitePrestationDto>();
		List<ActivitePrestation>        items    = new ArrayList<ActivitePrestation>();
			
		for (ActivitePrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la activitePrestation existe
			ActivitePrestation entityToSave = null;
			entityToSave = activitePrestationRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("activitePrestation id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if activite exist
			if (dto.getActiviteId() != null && dto.getActiviteId() > 0){
				Activite existingActivite = activiteRepository.findOne(dto.getActiviteId(), false);
				if (existingActivite == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("activite activiteId -> " + dto.getActiviteId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setActivite(existingActivite);
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
			if (Utilities.notBlank(dto.getDescription())) {
				entityToSave.setDescription(dto.getDescription());
			}
			if (Utilities.notBlank(dto.getLibelle())) {
				entityToSave.setLibelle(dto.getLibelle());
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
			List<ActivitePrestation> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = activitePrestationRepository.saveAll((Iterable<ActivitePrestation>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("activitePrestation", locale));
				response.setHasError(true);
				return response;
			}
			List<ActivitePrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ActivitePrestationTransformer.INSTANCE.toLiteDtos(itemsSaved) : ActivitePrestationTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update ActivitePrestation-----");
		return response;
	}

	/**
	 * delete ActivitePrestation by using ActivitePrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ActivitePrestationDto> delete(Request<ActivitePrestationDto> request, Locale locale)  {
		// System.out.println("----begin delete ActivitePrestation-----");

		Response<ActivitePrestationDto> response = new Response<ActivitePrestationDto>();
		List<ActivitePrestation>        items    = new ArrayList<ActivitePrestation>();
			
		for (ActivitePrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la activitePrestation existe
			ActivitePrestation existingEntity = null;

			existingEntity = activitePrestationRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("activitePrestation -> " + dto.getId(), locale));
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
			activitePrestationRepository.saveAll((Iterable<ActivitePrestation>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete ActivitePrestation-----");
		return response;
	}

	/**
	 * get ActivitePrestation by using ActivitePrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ActivitePrestationDto> getByCriteria(Request<ActivitePrestationDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get ActivitePrestation-----");

		Response<ActivitePrestationDto> response = new Response<ActivitePrestationDto>();
		List<ActivitePrestation> items 			 = activitePrestationRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ActivitePrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ActivitePrestationTransformer.INSTANCE.toLiteDtos(items) : ActivitePrestationTransformer.INSTANCE.toDtos(items);

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
			response.setCount(activitePrestationRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("activitePrestation", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get ActivitePrestation-----");
		return response;
	}

	/**
	 * get full ActivitePrestationDto by using ActivitePrestation as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ActivitePrestationDto getFullInfos(ActivitePrestationDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
