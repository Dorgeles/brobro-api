                                                            														
/*
 * Java business for entity table prestataire_zone_livraison 
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
import com.wdy.brobrosseur.dao.entity.PrestataireZoneLivraison;
import com.wdy.brobrosseur.dao.entity.ZoneLivraison;
import com.wdy.brobrosseur.dao.entity.Prestation;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "prestataire_zone_livraison"
 * 
 * @author Geo
 *
 */

@Component
public class PrestataireZoneLivraisonBusiness implements IBasicBusiness<Request<PrestataireZoneLivraisonDto>, Response<PrestataireZoneLivraisonDto>> {

	private Response<PrestataireZoneLivraisonDto> response;
	@Autowired
	private PrestataireZoneLivraisonRepository prestataireZoneLivraisonRepository;
	@Autowired
	private ZoneLivraisonRepository zoneLivraisonRepository;
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

	public PrestataireZoneLivraisonBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create PrestataireZoneLivraison by using PrestataireZoneLivraisonDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestataireZoneLivraisonDto> create(Request<PrestataireZoneLivraisonDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create PrestataireZoneLivraison-----");

		Response<PrestataireZoneLivraisonDto> response = new Response<PrestataireZoneLivraisonDto>();
		List<PrestataireZoneLivraison>        items    = new ArrayList<PrestataireZoneLivraison>();
			
		for (PrestataireZoneLivraisonDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("prestataireId", dto.getPrestataireId());
			fieldsToVerify.put("zoneLivraisonId", dto.getZoneLivraisonId());
			fieldsToVerify.put("description", dto.getDescription());
			fieldsToVerify.put("libelle", dto.getLibelle());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			fieldsToVerify.put("dateFin", dto.getDateFin());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if prestataireZoneLivraison to insert do not exist
			PrestataireZoneLivraison existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("prestataireZoneLivraison id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// verif unique libelle in db
			existingEntity = prestataireZoneLivraisonRepository.findByLibelle(dto.getLibelle(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("prestataireZoneLivraison libelle -> " + dto.getLibelle(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique libelle in items to save
			if (items.stream().anyMatch(a -> a.getLibelle().equalsIgnoreCase(dto.getLibelle()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" libelle ", locale));
				response.setHasError(true);
				return response;
			}

			// Verify if zoneLivraison exist
			ZoneLivraison existingZoneLivraison = null;
			if (dto.getZoneLivraisonId() != null && dto.getZoneLivraisonId() > 0){
				existingZoneLivraison = zoneLivraisonRepository.findOne(dto.getZoneLivraisonId(), false);
				if (existingZoneLivraison == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("zoneLivraison zoneLivraisonId -> " + dto.getZoneLivraisonId(), locale));
					response.setHasError(true);
					return response;
				}
			}
			// Verify if prestation exist
			Prestation existingPrestation = null;
			if (dto.getPrestataireId() != null && dto.getPrestataireId() > 0){
				existingPrestation = prestationRepository.findOne(dto.getPrestataireId(), false);
				if (existingPrestation == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("prestation prestataireId -> " + dto.getPrestataireId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				PrestataireZoneLivraison entityToSave = null;
			entityToSave = PrestataireZoneLivraisonTransformer.INSTANCE.toEntity(dto, existingZoneLivraison, existingPrestation);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<PrestataireZoneLivraison> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = prestataireZoneLivraisonRepository.saveAll((Iterable<PrestataireZoneLivraison>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prestataireZoneLivraison", locale));
				response.setHasError(true);
				return response;
			}
			List<PrestataireZoneLivraisonDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrestataireZoneLivraisonTransformer.INSTANCE.toLiteDtos(itemsSaved) : PrestataireZoneLivraisonTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create PrestataireZoneLivraison-----");
		return response;
	}

	/**
	 * update PrestataireZoneLivraison by using PrestataireZoneLivraisonDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestataireZoneLivraisonDto> update(Request<PrestataireZoneLivraisonDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update PrestataireZoneLivraison-----");

		Response<PrestataireZoneLivraisonDto> response = new Response<PrestataireZoneLivraisonDto>();
		List<PrestataireZoneLivraison>        items    = new ArrayList<PrestataireZoneLivraison>();
			
		for (PrestataireZoneLivraisonDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prestataireZoneLivraison existe
			PrestataireZoneLivraison entityToSave = null;
			entityToSave = prestataireZoneLivraisonRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prestataireZoneLivraison id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if zoneLivraison exist
			if (dto.getZoneLivraisonId() != null && dto.getZoneLivraisonId() > 0){
				ZoneLivraison existingZoneLivraison = zoneLivraisonRepository.findOne(dto.getZoneLivraisonId(), false);
				if (existingZoneLivraison == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("zoneLivraison zoneLivraisonId -> " + dto.getZoneLivraisonId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setZoneLivraison(existingZoneLivraison);
			}
			// Verify if prestation exist
			if (dto.getPrestataireId() != null && dto.getPrestataireId() > 0){
				Prestation existingPrestation = prestationRepository.findOne(dto.getPrestataireId(), false);
				if (existingPrestation == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("prestation prestataireId -> " + dto.getPrestataireId(), locale));
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
			if (Utilities.notBlank(dto.getDateFin())) {
				entityToSave.setDateFin(dateFormat.parse(dto.getDateFin()));
			}
			entityToSave.setUpdatedBy(request.getUser());
			entityToSave.setUpdatedAt(Utilities.getCurrentDate());
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<PrestataireZoneLivraison> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = prestataireZoneLivraisonRepository.saveAll((Iterable<PrestataireZoneLivraison>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prestataireZoneLivraison", locale));
				response.setHasError(true);
				return response;
			}
			List<PrestataireZoneLivraisonDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrestataireZoneLivraisonTransformer.INSTANCE.toLiteDtos(itemsSaved) : PrestataireZoneLivraisonTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update PrestataireZoneLivraison-----");
		return response;
	}

	/**
	 * delete PrestataireZoneLivraison by using PrestataireZoneLivraisonDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestataireZoneLivraisonDto> delete(Request<PrestataireZoneLivraisonDto> request, Locale locale)  {
		// System.out.println("----begin delete PrestataireZoneLivraison-----");

		Response<PrestataireZoneLivraisonDto> response = new Response<PrestataireZoneLivraisonDto>();
		List<PrestataireZoneLivraison>        items    = new ArrayList<PrestataireZoneLivraison>();
			
		for (PrestataireZoneLivraisonDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prestataireZoneLivraison existe
			PrestataireZoneLivraison existingEntity = null;

			existingEntity = prestataireZoneLivraisonRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prestataireZoneLivraison -> " + dto.getId(), locale));
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
			prestataireZoneLivraisonRepository.saveAll((Iterable<PrestataireZoneLivraison>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete PrestataireZoneLivraison-----");
		return response;
	}

	/**
	 * get PrestataireZoneLivraison by using PrestataireZoneLivraisonDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestataireZoneLivraisonDto> getByCriteria(Request<PrestataireZoneLivraisonDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get PrestataireZoneLivraison-----");

		Response<PrestataireZoneLivraisonDto> response = new Response<PrestataireZoneLivraisonDto>();
		List<PrestataireZoneLivraison> items 			 = prestataireZoneLivraisonRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<PrestataireZoneLivraisonDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrestataireZoneLivraisonTransformer.INSTANCE.toLiteDtos(items) : PrestataireZoneLivraisonTransformer.INSTANCE.toDtos(items);

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
			response.setCount(prestataireZoneLivraisonRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("prestataireZoneLivraison", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get PrestataireZoneLivraison-----");
		return response;
	}

	/**
	 * get full PrestataireZoneLivraisonDto by using PrestataireZoneLivraison as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private PrestataireZoneLivraisonDto getFullInfos(PrestataireZoneLivraisonDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
