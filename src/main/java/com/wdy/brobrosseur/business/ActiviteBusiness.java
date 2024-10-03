                                                                        																	
/*
 * Java business for entity table activite 
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
import com.wdy.brobrosseur.dao.entity.Activite;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "activite"
 * 
 * @author Geo
 *
 */

@Component
public class ActiviteBusiness implements IBasicBusiness<Request<ActiviteDto>, Response<ActiviteDto>> {

	private Response<ActiviteDto> response;
	@Autowired
	private ActiviteRepository activiteRepository;
	@Autowired
	private RecordImageRepository recordImageRepository;
	@Autowired
	private ActivitePrestationRepository activitePrestationRepository;
	@Autowired
	private UtilisateurActiviteRepository utilisateurActiviteRepository;
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

	public ActiviteBusiness() {
		dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateTimeFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	}
	
	/**
	 * create Activite by using ActiviteDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ActiviteDto> create(Request<ActiviteDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Activite-----");

		Response<ActiviteDto> response = new Response<ActiviteDto>();
		List<Activite>        items    = new ArrayList<Activite>();
			
		for (ActiviteDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("libelle", dto.getLibelle());
			fieldsToVerify.put("description", dto.getDescription());
			fieldsToVerify.put("latitude", dto.getLatitude());
			fieldsToVerify.put("longitude", dto.getLongitude());
			fieldsToVerify.put("noteMoyenne", dto.getNoteMoyenne());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("dateOuverture", dto.getDateOuverture());
			fieldsToVerify.put("dateFermeture", dto.getDateFermeture());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			fieldsToVerify.put("dateFin", dto.getDateFin());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if activite to insert do not exist
			Activite existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("activite id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// verif unique libelle in db
			existingEntity = activiteRepository.findByLibelle(dto.getLibelle(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("activite libelle -> " + dto.getLibelle(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique libelle in items to save
			if (items.stream().anyMatch(a -> a.getLibelle().equalsIgnoreCase(dto.getLibelle()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" libelle ", locale));
				response.setHasError(true);
				return response;
			}

				Activite entityToSave = null;
			entityToSave = ActiviteTransformer.INSTANCE.toEntity(dto);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Activite> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = activiteRepository.saveAll((Iterable<Activite>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("activite", locale));
				response.setHasError(true);
				return response;
			}
			List<ActiviteDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ActiviteTransformer.INSTANCE.toLiteDtos(itemsSaved) : ActiviteTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create Activite-----");
		return response;
	}

	/**
	 * update Activite by using ActiviteDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ActiviteDto> update(Request<ActiviteDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Activite-----");

		Response<ActiviteDto> response = new Response<ActiviteDto>();
		List<Activite>        items    = new ArrayList<Activite>();
			
		for (ActiviteDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la activite existe
			Activite entityToSave = null;
			entityToSave = activiteRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("activite id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getLibelle())) {
				entityToSave.setLibelle(dto.getLibelle());
			}
			if (Utilities.notBlank(dto.getDescription())) {
				entityToSave.setDescription(dto.getDescription());
			}
			if (Utilities.notBlank(dto.getLatitude())) {
				entityToSave.setLatitude(dto.getLatitude());
			}
			if (Utilities.notBlank(dto.getLongitude())) {
				entityToSave.setLongitude(dto.getLongitude());
			}
			if (dto.getNoteMoyenne() != null && dto.getNoteMoyenne() > 0) {
				entityToSave.setNoteMoyenne(dto.getNoteMoyenne());
			}
			if (dto.getStatusId() != null && dto.getStatusId() > 0) {
				entityToSave.setStatusId(dto.getStatusId());
			}
			if (Utilities.notBlank(dto.getDateOuverture())) {
				entityToSave.setDateOuverture(dateFormat.parse(dto.getDateOuverture()));
			}
			if (Utilities.notBlank(dto.getDateFermeture())) {
				entityToSave.setDateFermeture(dateFormat.parse(dto.getDateFermeture()));
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
			List<Activite> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = activiteRepository.saveAll((Iterable<Activite>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("activite", locale));
				response.setHasError(true);
				return response;
			}
			List<ActiviteDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ActiviteTransformer.INSTANCE.toLiteDtos(itemsSaved) : ActiviteTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update Activite-----");
		return response;
	}

	/**
	 * delete Activite by using ActiviteDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ActiviteDto> delete(Request<ActiviteDto> request, Locale locale)  {
		// System.out.println("----begin delete Activite-----");

		Response<ActiviteDto> response = new Response<ActiviteDto>();
		List<Activite>        items    = new ArrayList<Activite>();
			
		for (ActiviteDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la activite existe
			Activite existingEntity = null;

			existingEntity = activiteRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("activite -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// recordImage
			List<RecordImage> listOfRecordImage = recordImageRepository.findByActiviteId(existingEntity.getId(), false);
			if (listOfRecordImage != null && !listOfRecordImage.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfRecordImage.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// activitePrestation
			List<ActivitePrestation> listOfActivitePrestation = activitePrestationRepository.findByActiviteId(existingEntity.getId(), false);
			if (listOfActivitePrestation != null && !listOfActivitePrestation.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfActivitePrestation.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// utilisateurActivite
			List<UtilisateurActivite> listOfUtilisateurActivite = utilisateurActiviteRepository.findByActiviteId(existingEntity.getId(), false);
			if (listOfUtilisateurActivite != null && !listOfUtilisateurActivite.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUtilisateurActivite.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			activiteRepository.saveAll((Iterable<Activite>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Activite-----");
		return response;
	}

	/**
	 * get Activite by using ActiviteDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ActiviteDto> getByCriteria(Request<ActiviteDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Activite-----");

		Response<ActiviteDto> response = new Response<ActiviteDto>();
		List<Activite> items 			 = activiteRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ActiviteDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ActiviteTransformer.INSTANCE.toLiteDtos(items) : ActiviteTransformer.INSTANCE.toDtos(items);

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
			response.setCount(activiteRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("activite", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Activite-----");
		return response;
	}

	/**
	 * get full ActiviteDto by using Activite as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ActiviteDto getFullInfos(ActiviteDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
