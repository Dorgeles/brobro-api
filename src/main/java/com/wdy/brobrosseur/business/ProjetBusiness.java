                                                                															
/*
 * Java business for entity table projet 
 * Created on 2024-09-29 ( Time 23:02:37 )
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
import com.wdy.brobrosseur.dao.entity.Projet;
import com.wdy.brobrosseur.dao.entity.Vendeur;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "projet"
 * 
 * @author Geo
 *
 */

@Component
public class ProjetBusiness implements IBasicBusiness<Request<ProjetDto>, Response<ProjetDto>> {

	private Response<ProjetDto> response;
	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private EvalutationProjetRepository evalutationProjetRepository;
	@Autowired
	private RecordImageRepository recordImageRepository;
	@Autowired
	private VendeurRepository vendeurRepository;
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

	public ProjetBusiness() {
		dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateTimeFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	}
	
	/**
	 * create Projet by using ProjetDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProjetDto> create(Request<ProjetDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Projet-----");

		Response<ProjetDto> response = new Response<ProjetDto>();
		List<Projet>        items    = new ArrayList<Projet>();
			
		for (ProjetDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("vendeurId", dto.getVendeurId());
			fieldsToVerify.put("nom", dto.getNom());
			fieldsToVerify.put("description", dto.getDescription());
			fieldsToVerify.put("latitude", dto.getLatitude());
			fieldsToVerify.put("longitude", dto.getLongitude());
			fieldsToVerify.put("noteMoyenne", dto.getNoteMoyenne());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if projet to insert do not exist
			Projet existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("projet id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// Verify if vendeur exist
			Vendeur existingVendeur = null;
			if (dto.getVendeurId() != null && dto.getVendeurId() > 0){
				existingVendeur = vendeurRepository.findOne(dto.getVendeurId(), false);
				if (existingVendeur == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("vendeur vendeurId -> " + dto.getVendeurId(), locale));
					response.setHasError(true);
					return response;
				}
			}
				Projet entityToSave = null;
			entityToSave = ProjetTransformer.INSTANCE.toEntity(dto, existingVendeur);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Projet> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = projetRepository.saveAll((Iterable<Projet>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("projet", locale));
				response.setHasError(true);
				return response;
			}
			List<ProjetDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProjetTransformer.INSTANCE.toLiteDtos(itemsSaved) : ProjetTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create Projet-----");
		return response;
	}

	/**
	 * update Projet by using ProjetDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProjetDto> update(Request<ProjetDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Projet-----");

		Response<ProjetDto> response = new Response<ProjetDto>();
		List<Projet>        items    = new ArrayList<Projet>();
			
		for (ProjetDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la projet existe
			Projet entityToSave = null;
			entityToSave = projetRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("projet id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if vendeur exist
			if (dto.getVendeurId() != null && dto.getVendeurId() > 0){
				Vendeur existingVendeur = vendeurRepository.findOne(dto.getVendeurId(), false);
				if (existingVendeur == null) {
					response.setStatus(functionalError.DATA_NOT_EXIST("vendeur vendeurId -> " + dto.getVendeurId(), locale));
					response.setHasError(true);
					return response;
				}
				entityToSave.setVendeur(existingVendeur);
			}
			if (Utilities.notBlank(dto.getNom())) {
				entityToSave.setNom(dto.getNom());
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
			List<Projet> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = projetRepository.saveAll((Iterable<Projet>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("projet", locale));
				response.setHasError(true);
				return response;
			}
			List<ProjetDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProjetTransformer.INSTANCE.toLiteDtos(itemsSaved) : ProjetTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update Projet-----");
		return response;
	}

	/**
	 * delete Projet by using ProjetDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProjetDto> delete(Request<ProjetDto> request, Locale locale)  {
		// System.out.println("----begin delete Projet-----");

		Response<ProjetDto> response = new Response<ProjetDto>();
		List<Projet>        items    = new ArrayList<Projet>();
			
		for (ProjetDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la projet existe
			Projet existingEntity = null;

			existingEntity = projetRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("projet -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// evalutationProjet
			List<EvalutationProjet> listOfEvalutationProjet = evalutationProjetRepository.findByProjetId(existingEntity.getId(), false);
			if (listOfEvalutationProjet != null && !listOfEvalutationProjet.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfEvalutationProjet.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// recordImage
			List<RecordImage> listOfRecordImage = recordImageRepository.findByProjetId(existingEntity.getId(), false);
			if (listOfRecordImage != null && !listOfRecordImage.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfRecordImage.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			projetRepository.saveAll((Iterable<Projet>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Projet-----");
		return response;
	}

	/**
	 * get Projet by using ProjetDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<ProjetDto> getByCriteria(Request<ProjetDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Projet-----");

		Response<ProjetDto> response = new Response<ProjetDto>();
		List<Projet> items 			 = projetRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<ProjetDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? ProjetTransformer.INSTANCE.toLiteDtos(items) : ProjetTransformer.INSTANCE.toDtos(items);

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
			response.setCount(projetRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("projet", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Projet-----");
		return response;
	}

	/**
	 * get full ProjetDto by using Projet as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private ProjetDto getFullInfos(ProjetDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
