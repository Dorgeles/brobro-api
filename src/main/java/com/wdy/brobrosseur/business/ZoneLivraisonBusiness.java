                                                        													
/*
 * Java business for entity table zone_livraison 
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
import com.wdy.brobrosseur.dao.entity.ZoneLivraison;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "zone_livraison"
 * 
 * @author Geo
 *
 */

@Component
public class ZoneLivraisonBusiness implements IBasicBusiness<Request<ZoneLivraisonDto>, Response<ZoneLivraisonDto>> {

	private Response<ZoneLivraisonDto> response;
	@Autowired
	private ZoneLivraisonRepository zoneLivraisonRepository;
	@Autowired
	private PrestataireZoneLivraisonRepository prestataireZoneLivraisonRepository;
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

	public ZoneLivraisonBusiness() {
		dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateTimeFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	}
	
	/**
	 * create ZoneLivraison by using ZoneLivraisonDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ZoneLivraisonDto> create(Request<ZoneLivraisonDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create ZoneLivraison-----");

		Response<ZoneLivraisonDto> response = new Response<ZoneLivraisonDto>();
		List<ZoneLivraison>        items    = new ArrayList<ZoneLivraison>();
			
		for (ZoneLivraisonDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("latitudeDepart", dto.getLatitudeDepart());
			fieldsToVerify.put("longitudeDepart", dto.getLongitudeDepart());
			fieldsToVerify.put("latitudeArrivee", dto.getLatitudeArrivee());
			fieldsToVerify.put("longitudeArrivee", dto.getLongitudeArrivee());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if zoneLivraison to insert do not exist
			ZoneLivraison existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("zoneLivraison id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
				ZoneLivraison entityToSave = null;
			entityToSave = ZoneLivraisonTransformer.INSTANCE.toEntity(dto);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<ZoneLivraison> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = zoneLivraisonRepository.saveAll((Iterable<ZoneLivraison>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("zoneLivraison", locale));
				response.setHasError(true);
				return response;
			}
			List<ZoneLivraisonDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ZoneLivraisonTransformer.INSTANCE.toLiteDtos(itemsSaved) : ZoneLivraisonTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create ZoneLivraison-----");
		return response;
	}

	/**
	 * update ZoneLivraison by using ZoneLivraisonDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ZoneLivraisonDto> update(Request<ZoneLivraisonDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update ZoneLivraison-----");

		Response<ZoneLivraisonDto> response = new Response<ZoneLivraisonDto>();
		List<ZoneLivraison>        items    = new ArrayList<ZoneLivraison>();
			
		for (ZoneLivraisonDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la zoneLivraison existe
			ZoneLivraison entityToSave = null;
			entityToSave = zoneLivraisonRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("zoneLivraison id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getLatitudeDepart())) {
				entityToSave.setLatitudeDepart(dto.getLatitudeDepart());
			}
			if (Utilities.notBlank(dto.getLongitudeDepart())) {
				entityToSave.setLongitudeDepart(dto.getLongitudeDepart());
			}
			if (Utilities.notBlank(dto.getLatitudeArrivee())) {
				entityToSave.setLatitudeArrivee(dto.getLatitudeArrivee());
			}
			if (Utilities.notBlank(dto.getLongitudeArrivee())) {
				entityToSave.setLongitudeArrivee(dto.getLongitudeArrivee());
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
			List<ZoneLivraison> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = zoneLivraisonRepository.saveAll((Iterable<ZoneLivraison>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("zoneLivraison", locale));
				response.setHasError(true);
				return response;
			}
			List<ZoneLivraisonDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ZoneLivraisonTransformer.INSTANCE.toLiteDtos(itemsSaved) : ZoneLivraisonTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update ZoneLivraison-----");
		return response;
	}

	/**
	 * delete ZoneLivraison by using ZoneLivraisonDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ZoneLivraisonDto> delete(Request<ZoneLivraisonDto> request, Locale locale)  {
		// System.out.println("----begin delete ZoneLivraison-----");

		Response<ZoneLivraisonDto> response = new Response<ZoneLivraisonDto>();
		List<ZoneLivraison>        items    = new ArrayList<ZoneLivraison>();
			
		for (ZoneLivraisonDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la zoneLivraison existe
			ZoneLivraison existingEntity = null;

			existingEntity = zoneLivraisonRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("zoneLivraison -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// prestataireZoneLivraison
			List<PrestataireZoneLivraison> listOfPrestataireZoneLivraison = prestataireZoneLivraisonRepository.findByZoneLivraisonId(existingEntity.getId(), false);
			if (listOfPrestataireZoneLivraison != null && !listOfPrestataireZoneLivraison.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPrestataireZoneLivraison.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			zoneLivraisonRepository.saveAll((Iterable<ZoneLivraison>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete ZoneLivraison-----");
		return response;
	}

	/**
	 * get ZoneLivraison by using ZoneLivraisonDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ZoneLivraisonDto> getByCriteria(Request<ZoneLivraisonDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get ZoneLivraison-----");

		Response<ZoneLivraisonDto> response = new Response<ZoneLivraisonDto>();
		List<ZoneLivraison> items 			 = zoneLivraisonRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ZoneLivraisonDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ZoneLivraisonTransformer.INSTANCE.toLiteDtos(items) : ZoneLivraisonTransformer.INSTANCE.toDtos(items);

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
			response.setCount(zoneLivraisonRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("zoneLivraison", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get ZoneLivraison-----");
		return response;
	}

	/**
	 * get full ZoneLivraisonDto by using ZoneLivraison as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ZoneLivraisonDto getFullInfos(ZoneLivraisonDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
