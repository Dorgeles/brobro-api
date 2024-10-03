                                                											
/*
 * Java business for entity table coursier 
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
import com.wdy.brobrosseur.dao.entity.Coursier;
import com.wdy.brobrosseur.dao.entity.Utilisateur;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "coursier"
 * 
 * @author Geo
 *
 */

@Component
public class CoursierBusiness implements IBasicBusiness<Request<CoursierDto>, Response<CoursierDto>> {

	private Response<CoursierDto> response;
	@Autowired
	private CoursierRepository coursierRepository;
	@Autowired
	private CoursierMoyenDeplacementRepository coursierMoyenDeplacementRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private CommandRepository commandRepository;
	@Autowired
	private ZoneLivraisonRepository zoneLivraisonRepository;
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

	public CoursierBusiness() {
		dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateTimeFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	}
	
	/**
	 * create Coursier by using CoursierDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CoursierDto> create(Request<CoursierDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Coursier-----");

		Response<CoursierDto> response = new Response<CoursierDto>();
		List<Coursier>        items    = new ArrayList<Coursier>();
			
		for (CoursierDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("utilisateurId", dto.getUtilisateurId());
			fieldsToVerify.put("disponible", dto.getDisponible());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if coursier to insert do not exist
			Coursier existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("coursier id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if utilisateur exist
			Utilisateur existingUtilisateur = null;
			if (dto.getUtilisateurId() != null && dto.getUtilisateurId() > 0){
				existingUtilisateur = utilisateurRepository.findOne(dto.getUtilisateurId(), false);
				if (existingUtilisateur == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("utilisateur utilisateurId -> " + dto.getUtilisateurId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				Coursier entityToSave = null;
			entityToSave = CoursierTransformer.INSTANCE.toEntity(dto, existingUtilisateur);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Coursier> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = coursierRepository.saveAll((Iterable<Coursier>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("coursier", locale));
				response.setHasError(true);
				return response;
			}
			List<CoursierDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CoursierTransformer.INSTANCE.toLiteDtos(itemsSaved) : CoursierTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create Coursier-----");
		return response;
	}

	/**
	 * update Coursier by using CoursierDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CoursierDto> update(Request<CoursierDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Coursier-----");

		Response<CoursierDto> response = new Response<CoursierDto>();
		List<Coursier>        items    = new ArrayList<Coursier>();
			
		for (CoursierDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la coursier existe
			Coursier entityToSave = null;
			entityToSave = coursierRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("coursier id -> " + dto.getId(), locale));
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
			if (dto.getDisponible() != null) {
				entityToSave.setDisponible(dto.getDisponible());
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
			List<Coursier> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = coursierRepository.saveAll((Iterable<Coursier>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("coursier", locale));
				response.setHasError(true);
				return response;
			}
			List<CoursierDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CoursierTransformer.INSTANCE.toLiteDtos(itemsSaved) : CoursierTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update Coursier-----");
		return response;
	}

	/**
	 * delete Coursier by using CoursierDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CoursierDto> delete(Request<CoursierDto> request, Locale locale)  {
		// System.out.println("----begin delete Coursier-----");

		Response<CoursierDto> response = new Response<CoursierDto>();
		List<Coursier>        items    = new ArrayList<Coursier>();
			
		for (CoursierDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la coursier existe
			Coursier existingEntity = null;

			existingEntity = coursierRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("coursier -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// coursierMoyenDeplacement
			List<CoursierMoyenDeplacement> listOfCoursierMoyenDeplacement = coursierMoyenDeplacementRepository.findByCoursierId(existingEntity.getId(), false);
			if (listOfCoursierMoyenDeplacement != null && !listOfCoursierMoyenDeplacement.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfCoursierMoyenDeplacement.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// command
			List<Command> listOfCommand = commandRepository.findByCoursierId(existingEntity.getId(), false);
			if (listOfCommand != null && !listOfCommand.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfCommand.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// zoneLivraison
			List<ZoneLivraison> listOfZoneLivraison = zoneLivraisonRepository.findByCoursierId(existingEntity.getId(), false);
			if (listOfZoneLivraison != null && !listOfZoneLivraison.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfZoneLivraison.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			coursierRepository.saveAll((Iterable<Coursier>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Coursier-----");
		return response;
	}

	/**
	 * get Coursier by using CoursierDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<CoursierDto> getByCriteria(Request<CoursierDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Coursier-----");

		Response<CoursierDto> response = new Response<CoursierDto>();
		List<Coursier> items 			 = coursierRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<CoursierDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? CoursierTransformer.INSTANCE.toLiteDtos(items) : CoursierTransformer.INSTANCE.toDtos(items);

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
			response.setCount(coursierRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("coursier", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Coursier-----");
		return response;
	}

	/**
	 * get full CoursierDto by using Coursier as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private CoursierDto getFullInfos(CoursierDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
