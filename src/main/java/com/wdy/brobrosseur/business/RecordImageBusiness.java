                                                											
/*
 * Java business for entity table record_image 
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
import com.wdy.brobrosseur.dao.entity.RecordImage;
import com.wdy.brobrosseur.dao.entity.Activite;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "record_image"
 * 
 * @author Geo
 *
 */

@Component
public class RecordImageBusiness implements IBasicBusiness<Request<RecordImageDto>, Response<RecordImageDto>> {

	private Response<RecordImageDto> response;
	@Autowired
	private RecordImageRepository recordImageRepository;
	@Autowired
	private ActiviteRepository activiteRepository;
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

	public RecordImageBusiness() {
		dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateTimeFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	}
	
	/**
	 * create RecordImage by using RecordImageDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<RecordImageDto> create(Request<RecordImageDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create RecordImage-----");

		Response<RecordImageDto> response = new Response<RecordImageDto>();
		List<RecordImage>        items    = new ArrayList<RecordImage>();
			
		for (RecordImageDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("activiteId", dto.getActiviteId());
			fieldsToVerify.put("url", dto.getUrl());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if recordImage to insert do not exist
			RecordImage existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("recordImage id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
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
				RecordImage entityToSave = null;
			entityToSave = RecordImageTransformer.INSTANCE.toEntity(dto, existingActivite);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<RecordImage> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = recordImageRepository.saveAll((Iterable<RecordImage>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("recordImage", locale));
				response.setHasError(true);
				return response;
			}
			List<RecordImageDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? RecordImageTransformer.INSTANCE.toLiteDtos(itemsSaved) : RecordImageTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create RecordImage-----");
		return response;
	}

	/**
	 * update RecordImage by using RecordImageDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<RecordImageDto> update(Request<RecordImageDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update RecordImage-----");

		Response<RecordImageDto> response = new Response<RecordImageDto>();
		List<RecordImage>        items    = new ArrayList<RecordImage>();
			
		for (RecordImageDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la recordImage existe
			RecordImage entityToSave = null;
			entityToSave = recordImageRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("recordImage id -> " + dto.getId(), locale));
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
			if (Utilities.notBlank(dto.getUrl())) {
				entityToSave.setUrl(dto.getUrl());
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
			List<RecordImage> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = recordImageRepository.saveAll((Iterable<RecordImage>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("recordImage", locale));
				response.setHasError(true);
				return response;
			}
			List<RecordImageDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? RecordImageTransformer.INSTANCE.toLiteDtos(itemsSaved) : RecordImageTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update RecordImage-----");
		return response;
	}

	/**
	 * delete RecordImage by using RecordImageDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<RecordImageDto> delete(Request<RecordImageDto> request, Locale locale)  {
		// System.out.println("----begin delete RecordImage-----");

		Response<RecordImageDto> response = new Response<RecordImageDto>();
		List<RecordImage>        items    = new ArrayList<RecordImage>();
			
		for (RecordImageDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la recordImage existe
			RecordImage existingEntity = null;

			existingEntity = recordImageRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("recordImage -> " + dto.getId(), locale));
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
			recordImageRepository.saveAll((Iterable<RecordImage>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete RecordImage-----");
		return response;
	}

	/**
	 * get RecordImage by using RecordImageDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<RecordImageDto> getByCriteria(Request<RecordImageDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get RecordImage-----");

		Response<RecordImageDto> response = new Response<RecordImageDto>();
		List<RecordImage> items 			 = recordImageRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<RecordImageDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? RecordImageTransformer.INSTANCE.toLiteDtos(items) : RecordImageTransformer.INSTANCE.toDtos(items);

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
			response.setCount(recordImageRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("recordImage", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get RecordImage-----");
		return response;
	}

	/**
	 * get full RecordImageDto by using RecordImage as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private RecordImageDto getFullInfos(RecordImageDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
