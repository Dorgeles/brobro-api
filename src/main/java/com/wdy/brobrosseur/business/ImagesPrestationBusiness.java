                                                        													
/*
 * Java business for entity table images_prestation 
 * Created on 2024-10-03 ( Time 13:00:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.business;

import com.wdy.brobrosseur.utils.okhttp.MinioExternalService;
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
import com.wdy.brobrosseur.dao.entity.ImagesPrestation;
import com.wdy.brobrosseur.dao.entity.Prestation;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "images_prestation"
 * 
 * @author Geo
 *
 */

@Component
public class ImagesPrestationBusiness implements IBasicBusiness<Request<ImagesPrestationDto>, Response<ImagesPrestationDto>> {

	private Response<ImagesPrestationDto> response;
	@Autowired
	private ImagesPrestationRepository imagesPrestationRepository;
	@Autowired
	private MinioExternalService minioExternalService;
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

	public ImagesPrestationBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create ImagesPrestation by using ImagesPrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ImagesPrestationDto> create(Request<ImagesPrestationDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create ImagesPrestation-----");

		Response<ImagesPrestationDto> response = new Response<ImagesPrestationDto>();
		List<ImagesPrestation>        items    = new ArrayList<ImagesPrestation>();
			
		for (ImagesPrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("prestationId", dto.getPrestationId());
			fieldsToVerify.put("imageBase64", dto.getFileBase64());
			fieldsToVerify.put("ordre", dto.getOrdre());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}


			// Verify if imagesPrestation to insert do not exist
			ImagesPrestation existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("imagesPrestation id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
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
			dto.setPathName(existingPrestation.getLibelle() + "/" + existingPrestation.getProjetId());
				ImagesPrestation entityToSave = null;
			String imageUrl = null;
			try {
				imageUrl = minioExternalService.saveImage(dto);
				dto.setUrl(imageUrl);
			} catch (Exception e) {
			}
			entityToSave = ImagesPrestationTransformer.INSTANCE.toEntity(dto, existingPrestation);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<ImagesPrestation> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = imagesPrestationRepository.saveAll((Iterable<ImagesPrestation>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("imagesPrestation", locale));
				response.setHasError(true);
				return response;
			}
			List<ImagesPrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ImagesPrestationTransformer.INSTANCE.toLiteDtos(itemsSaved) : ImagesPrestationTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create ImagesPrestation-----");
		return response;
	}

	/**
	 * update ImagesPrestation by using ImagesPrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ImagesPrestationDto> update(Request<ImagesPrestationDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update ImagesPrestation-----");

		Response<ImagesPrestationDto> response = new Response<ImagesPrestationDto>();
		List<ImagesPrestation>        items    = new ArrayList<ImagesPrestation>();
			
		for (ImagesPrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la imagesPrestation existe
			ImagesPrestation entityToSave = null;
			entityToSave = imagesPrestationRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("imagesPrestation id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
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
			if (Utilities.notBlank(dto.getFileBase64())) {
				dto.setPathName(entityToSave.getPrestation().getLibelle() + "/" + entityToSave.getPrestation().getProjetId());
				String imageUrl = null;
				try {
					imageUrl = minioExternalService.saveImage(dto);
					entityToSave.setUrl(imageUrl);
				} catch (Exception e) {
				}
			}
			if (Utilities.notBlank(dto.getDescription())) {
				entityToSave.setDescription(dto.getDescription());
			}
			if (dto.getOrdre() != null && dto.getOrdre() > 0) {
				entityToSave.setOrdre(dto.getOrdre());
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
			List<ImagesPrestation> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = imagesPrestationRepository.saveAll((Iterable<ImagesPrestation>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("imagesPrestation", locale));
				response.setHasError(true);
				return response;
			}
			List<ImagesPrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ImagesPrestationTransformer.INSTANCE.toLiteDtos(itemsSaved) : ImagesPrestationTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update ImagesPrestation-----");
		return response;
	}

	/**
	 * delete ImagesPrestation by using ImagesPrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ImagesPrestationDto> delete(Request<ImagesPrestationDto> request, Locale locale)  {
		// System.out.println("----begin delete ImagesPrestation-----");

		Response<ImagesPrestationDto> response = new Response<ImagesPrestationDto>();
		List<ImagesPrestation>        items    = new ArrayList<ImagesPrestation>();
			
		for (ImagesPrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la imagesPrestation existe
			ImagesPrestation existingEntity = null;

			existingEntity = imagesPrestationRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("imagesPrestation -> " + dto.getId(), locale));
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
			imagesPrestationRepository.saveAll((Iterable<ImagesPrestation>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete ImagesPrestation-----");
		return response;
	}

	/**
	 * get ImagesPrestation by using ImagesPrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ImagesPrestationDto> getByCriteria(Request<ImagesPrestationDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get ImagesPrestation-----");

		Response<ImagesPrestationDto> response = new Response<ImagesPrestationDto>();
		List<ImagesPrestation> items 			 = imagesPrestationRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ImagesPrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ImagesPrestationTransformer.INSTANCE.toLiteDtos(items) : ImagesPrestationTransformer.INSTANCE.toDtos(items);

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
			response.setCount(imagesPrestationRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("imagesPrestation", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get ImagesPrestation-----");
		return response;
	}

	/**
	 * get full ImagesPrestationDto by using ImagesPrestation as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ImagesPrestationDto getFullInfos(ImagesPrestationDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
