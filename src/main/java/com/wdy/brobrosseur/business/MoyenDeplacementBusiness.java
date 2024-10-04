                                            										
/*
 * Java business for entity table moyen_deplacement 
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
import com.wdy.brobrosseur.dao.entity.MoyenDeplacement;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "moyen_deplacement"
 * 
 * @author Geo
 *
 */

@Component
public class MoyenDeplacementBusiness implements IBasicBusiness<Request<MoyenDeplacementDto>, Response<MoyenDeplacementDto>> {

	private Response<MoyenDeplacementDto> response;
	@Autowired
	private MoyenDeplacementRepository moyenDeplacementRepository;
	@Autowired
	private PrestationMoyenDeplacementRepository prestationMoyenDeplacementRepository;
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

	public MoyenDeplacementBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create MoyenDeplacement by using MoyenDeplacementDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MoyenDeplacementDto> create(Request<MoyenDeplacementDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create MoyenDeplacement-----");

		Response<MoyenDeplacementDto> response = new Response<MoyenDeplacementDto>();
		List<MoyenDeplacement>        items    = new ArrayList<MoyenDeplacement>();
			
		for (MoyenDeplacementDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("libelle", dto.getLibelle());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if moyenDeplacement to insert do not exist
			MoyenDeplacement existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("moyenDeplacement id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// verif unique libelle in db
			existingEntity = moyenDeplacementRepository.findByLibelle(dto.getLibelle(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("moyenDeplacement libelle -> " + dto.getLibelle(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique libelle in items to save
			if (items.stream().anyMatch(a -> a.getLibelle().equalsIgnoreCase(dto.getLibelle()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" libelle ", locale));
				response.setHasError(true);
				return response;
			}

				MoyenDeplacement entityToSave = null;
			entityToSave = MoyenDeplacementTransformer.INSTANCE.toEntity(dto);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<MoyenDeplacement> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = moyenDeplacementRepository.saveAll((Iterable<MoyenDeplacement>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("moyenDeplacement", locale));
				response.setHasError(true);
				return response;
			}
			List<MoyenDeplacementDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? MoyenDeplacementTransformer.INSTANCE.toLiteDtos(itemsSaved) : MoyenDeplacementTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create MoyenDeplacement-----");
		return response;
	}

	/**
	 * update MoyenDeplacement by using MoyenDeplacementDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MoyenDeplacementDto> update(Request<MoyenDeplacementDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update MoyenDeplacement-----");

		Response<MoyenDeplacementDto> response = new Response<MoyenDeplacementDto>();
		List<MoyenDeplacement>        items    = new ArrayList<MoyenDeplacement>();
			
		for (MoyenDeplacementDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la moyenDeplacement existe
			MoyenDeplacement entityToSave = null;
			entityToSave = moyenDeplacementRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("moyenDeplacement id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
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
			entityToSave.setUpdatedBy(request.getUser());
			entityToSave.setUpdatedAt(Utilities.getCurrentDate());
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<MoyenDeplacement> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = moyenDeplacementRepository.saveAll((Iterable<MoyenDeplacement>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("moyenDeplacement", locale));
				response.setHasError(true);
				return response;
			}
			List<MoyenDeplacementDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? MoyenDeplacementTransformer.INSTANCE.toLiteDtos(itemsSaved) : MoyenDeplacementTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update MoyenDeplacement-----");
		return response;
	}

	/**
	 * delete MoyenDeplacement by using MoyenDeplacementDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MoyenDeplacementDto> delete(Request<MoyenDeplacementDto> request, Locale locale)  {
		// System.out.println("----begin delete MoyenDeplacement-----");

		Response<MoyenDeplacementDto> response = new Response<MoyenDeplacementDto>();
		List<MoyenDeplacement>        items    = new ArrayList<MoyenDeplacement>();
			
		for (MoyenDeplacementDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la moyenDeplacement existe
			MoyenDeplacement existingEntity = null;

			existingEntity = moyenDeplacementRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("moyenDeplacement -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// prestationMoyenDeplacement
			List<PrestationMoyenDeplacement> listOfPrestationMoyenDeplacement = prestationMoyenDeplacementRepository.findByMoyenDeplacementId(existingEntity.getId(), false);
			if (listOfPrestationMoyenDeplacement != null && !listOfPrestationMoyenDeplacement.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPrestationMoyenDeplacement.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			moyenDeplacementRepository.saveAll((Iterable<MoyenDeplacement>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete MoyenDeplacement-----");
		return response;
	}

	/**
	 * get MoyenDeplacement by using MoyenDeplacementDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<MoyenDeplacementDto> getByCriteria(Request<MoyenDeplacementDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get MoyenDeplacement-----");

		Response<MoyenDeplacementDto> response = new Response<MoyenDeplacementDto>();
		List<MoyenDeplacement> items 			 = moyenDeplacementRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<MoyenDeplacementDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? MoyenDeplacementTransformer.INSTANCE.toLiteDtos(items) : MoyenDeplacementTransformer.INSTANCE.toDtos(items);

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
			response.setCount(moyenDeplacementRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("moyenDeplacement", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get MoyenDeplacement-----");
		return response;
	}

	/**
	 * get full MoyenDeplacementDto by using MoyenDeplacement as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private MoyenDeplacementDto getFullInfos(MoyenDeplacementDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
