                                                            														
/*
 * Java business for entity table prestation 
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
import com.wdy.brobrosseur.dao.entity.Prestation;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "prestation"
 * 
 * @author Geo
 *
 */

@Component
public class PrestationBusiness implements IBasicBusiness<Request<PrestationDto>, Response<PrestationDto>> {

	private Response<PrestationDto> response;
	@Autowired
	private PrestationRepository prestationRepository;
	@Autowired
	private PrestationMoyenDeplacementRepository prestationMoyenDeplacementRepository;
	@Autowired
	private CommandRepository commandRepository;
	@Autowired
	private ImagesPrestationRepository imagesPrestationRepository;
	@Autowired
	private PrestataireZoneLivraisonRepository prestataireZoneLivraisonRepository;
	@Autowired
	private ActivitePrestationRepository activitePrestationRepository;
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

	public PrestationBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Prestation by using PrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestationDto> create(Request<PrestationDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Prestation-----");

		Response<PrestationDto> response = new Response<PrestationDto>();
		List<Prestation>        items    = new ArrayList<Prestation>();
			
		for (PrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("projetId", dto.getProjetId());
			fieldsToVerify.put("libelle", dto.getLibelle());
			fieldsToVerify.put("description", dto.getDescription());
			fieldsToVerify.put("prix", dto.getPrix());
			fieldsToVerify.put("dureeEstimee", dto.getDureeEstimee());
			fieldsToVerify.put("statusId", dto.getStatusId());
			fieldsToVerify.put("deletedAt", dto.getDeletedAt());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if prestation to insert do not exist
			Prestation existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("prestation id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// verif unique libelle in db
			existingEntity = prestationRepository.findByLibelle(dto.getLibelle(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("prestation libelle -> " + dto.getLibelle(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique libelle in items to save
			if (items.stream().anyMatch(a -> a.getLibelle().equalsIgnoreCase(dto.getLibelle()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" libelle ", locale));
				response.setHasError(true);
				return response;
			}

				Prestation entityToSave = null;
			entityToSave = PrestationTransformer.INSTANCE.toEntity(dto);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Prestation> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = prestationRepository.saveAll((Iterable<Prestation>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prestation", locale));
				response.setHasError(true);
				return response;
			}
			List<PrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrestationTransformer.INSTANCE.toLiteDtos(itemsSaved) : PrestationTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create Prestation-----");
		return response;
	}

	/**
	 * update Prestation by using PrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestationDto> update(Request<PrestationDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Prestation-----");

		Response<PrestationDto> response = new Response<PrestationDto>();
		List<Prestation>        items    = new ArrayList<Prestation>();
			
		for (PrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prestation existe
			Prestation entityToSave = null;
			entityToSave = prestationRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prestation id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			if (dto.getProjetId() != null && dto.getProjetId() > 0) {
				entityToSave.setProjetId(dto.getProjetId());
			}
			if (Utilities.notBlank(dto.getLibelle())) {
				entityToSave.setLibelle(dto.getLibelle());
			}
			if (Utilities.notBlank(dto.getDescription())) {
				entityToSave.setDescription(dto.getDescription());
			}
			if (Utilities.notBlank(dto.getPrix())) {
				entityToSave.setPrix(dto.getPrix());
			}
			if (dto.getDureeEstimee() != null && dto.getDureeEstimee() > 0) {
				entityToSave.setDureeEstimee(dto.getDureeEstimee());
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
			List<Prestation> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = prestationRepository.saveAll((Iterable<Prestation>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("prestation", locale));
				response.setHasError(true);
				return response;
			}
			List<PrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrestationTransformer.INSTANCE.toLiteDtos(itemsSaved) : PrestationTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update Prestation-----");
		return response;
	}

	/**
	 * delete Prestation by using PrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestationDto> delete(Request<PrestationDto> request, Locale locale)  {
		// System.out.println("----begin delete Prestation-----");

		Response<PrestationDto> response = new Response<PrestationDto>();
		List<Prestation>        items    = new ArrayList<Prestation>();
			
		for (PrestationDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la prestation existe
			Prestation existingEntity = null;

			existingEntity = prestationRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("prestation -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// prestationMoyenDeplacement
			List<PrestationMoyenDeplacement> listOfPrestationMoyenDeplacement = prestationMoyenDeplacementRepository.findByPresatationId(existingEntity.getId(), false);
			if (listOfPrestationMoyenDeplacement != null && !listOfPrestationMoyenDeplacement.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPrestationMoyenDeplacement.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// command
			List<Command> listOfCommand = commandRepository.findByPrestationId(existingEntity.getId(), false);
			if (listOfCommand != null && !listOfCommand.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfCommand.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// imagesPrestation
			List<ImagesPrestation> listOfImagesPrestation = imagesPrestationRepository.findByPrestationId(existingEntity.getId(), false);
			if (listOfImagesPrestation != null && !listOfImagesPrestation.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfImagesPrestation.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// prestataireZoneLivraison
			List<PrestataireZoneLivraison> listOfPrestataireZoneLivraison = prestataireZoneLivraisonRepository.findByPrestataireId(existingEntity.getId(), false);
			if (listOfPrestataireZoneLivraison != null && !listOfPrestataireZoneLivraison.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfPrestataireZoneLivraison.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// activitePrestation
			List<ActivitePrestation> listOfActivitePrestation = activitePrestationRepository.findByPrestationId(existingEntity.getId(), false);
			if (listOfActivitePrestation != null && !listOfActivitePrestation.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfActivitePrestation.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			prestationRepository.saveAll((Iterable<Prestation>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Prestation-----");
		return response;
	}

	/**
	 * get Prestation by using PrestationDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<PrestationDto> getByCriteria(Request<PrestationDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Prestation-----");

		Response<PrestationDto> response = new Response<PrestationDto>();
		List<Prestation> items 			 = prestationRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<PrestationDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? PrestationTransformer.INSTANCE.toLiteDtos(items) : PrestationTransformer.INSTANCE.toDtos(items);

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
			response.setCount(prestationRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("prestation", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Prestation-----");
		return response;
	}

	/**
	 * get full PrestationDto by using Prestation as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private PrestationDto getFullInfos(PrestationDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
