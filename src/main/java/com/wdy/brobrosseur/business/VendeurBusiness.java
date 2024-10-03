                                            										
/*
 * Java business for entity table vendeur 
 * Created on 2024-09-29 ( Time 22:05:55 )
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
import com.wdy.brobrosseur.dao.entity.Vendeur;
import com.wdy.brobrosseur.dao.entity.Utilisateur;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "vendeur"
 * 
 * @author Geo
 *
 */

@Component
public class VendeurBusiness implements IBasicBusiness<Request<VendeurDto>, Response<VendeurDto>> {

	private Response<VendeurDto> response;
	@Autowired
	private VendeurRepository vendeurRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private ProjetRepository projetRepository;
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

	public VendeurBusiness() {
		dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateTimeFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	}
	
	/**
	 * create Vendeur by using VendeurDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<VendeurDto> create(Request<VendeurDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Vendeur-----");

		Response<VendeurDto> response = new Response<VendeurDto>();
		List<Vendeur>        items    = new ArrayList<Vendeur>();
			
		for (VendeurDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("utilisateurId", dto.getUtilisateurId());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if vendeur to insert do not exist
			Vendeur existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("vendeur id -> " + dto.getId(), locale));
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
				Vendeur entityToSave = null;
			entityToSave = VendeurTransformer.INSTANCE.toEntity(dto, existingUtilisateur);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Vendeur> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = vendeurRepository.saveAll((Iterable<Vendeur>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("vendeur", locale));
				response.setHasError(true);
				return response;
			}
			List<VendeurDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? VendeurTransformer.INSTANCE.toLiteDtos(itemsSaved) : VendeurTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create Vendeur-----");
		return response;
	}

	/**
	 * update Vendeur by using VendeurDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<VendeurDto> update(Request<VendeurDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Vendeur-----");

		Response<VendeurDto> response = new Response<VendeurDto>();
		List<Vendeur>        items    = new ArrayList<Vendeur>();
			
		for (VendeurDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la vendeur existe
			Vendeur entityToSave = null;
			entityToSave = vendeurRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("vendeur id -> " + dto.getId(), locale));
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
			List<Vendeur> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = vendeurRepository.saveAll((Iterable<Vendeur>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("vendeur", locale));
				response.setHasError(true);
				return response;
			}
			List<VendeurDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? VendeurTransformer.INSTANCE.toLiteDtos(itemsSaved) : VendeurTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update Vendeur-----");
		return response;
	}

	/**
	 * delete Vendeur by using VendeurDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<VendeurDto> delete(Request<VendeurDto> request, Locale locale)  {
		// System.out.println("----begin delete Vendeur-----");

		Response<VendeurDto> response = new Response<VendeurDto>();
		List<Vendeur>        items    = new ArrayList<Vendeur>();
			
		for (VendeurDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la vendeur existe
			Vendeur existingEntity = null;

			existingEntity = vendeurRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("vendeur -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// projet
			List<Projet> listOfProjet = projetRepository.findByVendeurId(existingEntity.getId(), false);
			if (listOfProjet != null && !listOfProjet.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfProjet.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			vendeurRepository.saveAll((Iterable<Vendeur>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Vendeur-----");
		return response;
	}

	/**
	 * get Vendeur by using VendeurDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<VendeurDto> getByCriteria(Request<VendeurDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Vendeur-----");

		Response<VendeurDto> response = new Response<VendeurDto>();
		List<Vendeur> items 			 = vendeurRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<VendeurDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? VendeurTransformer.INSTANCE.toLiteDtos(items) : VendeurTransformer.INSTANCE.toDtos(items);

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
			response.setCount(vendeurRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("vendeur", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Vendeur-----");
		return response;
	}

	/**
	 * get full VendeurDto by using Vendeur as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private VendeurDto getFullInfos(VendeurDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
