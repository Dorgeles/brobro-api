                                                                            																		
/*
 * Java business for entity table utilisateur 
 * Created on 2024-09-29 ( Time 22:52:48 )
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
import java.util.stream.Collectors;

import com.wdy.brobrosseur.utils.*;
import com.wdy.brobrosseur.utils.dto.*;
import com.wdy.brobrosseur.utils.enums.*;
import com.wdy.brobrosseur.utils.contract.*;
import com.wdy.brobrosseur.utils.contract.IBasicBusiness;
import com.wdy.brobrosseur.utils.contract.Request;
import com.wdy.brobrosseur.utils.contract.Response;
import com.wdy.brobrosseur.utils.dto.transformer.*;
import com.wdy.brobrosseur.dao.entity.Utilisateur;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "utilisateur"
 * 
 * @author Geo
 *
 */

@Component
public class UtilisateurBusiness implements IBasicBusiness<Request<UtilisateurDto>, Response<UtilisateurDto>> {

	private Response<UtilisateurDto> response;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private VendeurRepository vendeurRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CoursierRepository coursierRepository;
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

	public UtilisateurBusiness() {
		dateFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dateTimeFormat =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	}
	
	/**
	 * create Utilisateur by using UtilisateurDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurDto> create(Request<UtilisateurDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Utilisateur-----");

		Response<UtilisateurDto> response = new Response<UtilisateurDto>();
		List<Utilisateur>        items    = new ArrayList<Utilisateur>();
			
		for (UtilisateurDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("nom", dto.getNom());
			fieldsToVerify.put("prenom", dto.getPrenom());
			fieldsToVerify.put("email", dto.getEmail());
			fieldsToVerify.put("telephone", dto.getTelephone());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verify if utilisateur to insert do not exist
			Utilisateur existingEntity = null;
			// verif unique email in db
			existingEntity = utilisateurRepository.findByEmail(dto.getEmail(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("utilisateur email -> " + dto.getEmail(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique email in items to save
			if (items.stream().anyMatch(a -> a.getEmail().equalsIgnoreCase(dto.getEmail()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" email ", locale));
				response.setHasError(true);
				return response;
			}
			existingEntity = utilisateurRepository.findByTelephone(dto.getTelephone(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("utilisateur contact -> " + dto.getTelephone(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique email in items to save
			if (items.stream().anyMatch(a -> a.getTelephone().equalsIgnoreCase(dto.getTelephone()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" contact ", locale));
				response.setHasError(true);
				return response;
			}
			if (Utilities.isNotBlank(dto.getUsername())){
				String generatedUserName =Utilities.getUsernameFromFullName(dto.getNom()+ dto.getPrenom());
				// vérification de l'unicité du username
				List<Utilisateur> existingUsername = utilisateurRepository.findByUsername(generatedUserName, false);
				if (Utilities.isNotEmpty(existingUsername)) {
					// recuperer le dernier caractère du username
					String foundUsername = existingUsername.get(existingUsername.size() - 1).getUsername();
					// incrementer le dernier caractère du username s'il est un chiffre
					if (Character.isDigit(foundUsername.charAt(foundUsername.length() - 1))) {
						int incrementer = Integer.parseInt(foundUsername.substring(foundUsername.length() - 1)) + 1;
						// le username incrementé
						generatedUserName = generatedUserName.substring(0, generatedUserName.length() - 1);
						generatedUserName = generatedUserName + incrementer;
					} else {
						generatedUserName = generatedUserName + "1";
					}
					dto.setUsername(generatedUserName);
				}
			} else {
				List<Utilisateur> existingUsername = utilisateurRepository.findByUsername(dto.getUsername(), false);
				if (Utilities.isNotEmpty(existingUsername)) {
					Status status = new Status();
					status.setCode("409");
					status.setMessage("Le username "+  dto.getUsername() +" proposé existe déjà");
					response.setStatus(status);
					response.setHasError(true);
					return response;
				}
			}
			Utilisateur entityToSave = null;
			entityToSave = UtilisateurTransformer.INSTANCE.toEntity(dto);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Utilisateur> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = utilisateurRepository.saveAll((Iterable<Utilisateur>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("utilisateur", locale));
				response.setHasError(true);
				return response;
			}
			List<UtilisateurDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UtilisateurTransformer.INSTANCE.toLiteDtos(itemsSaved) : UtilisateurTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create Utilisateur-----");
		return response;
	}

	/**
	 * update Utilisateur by using UtilisateurDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurDto> update(Request<UtilisateurDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Utilisateur-----");

		Response<UtilisateurDto> response = new Response<UtilisateurDto>();
		List<Utilisateur>        items    = new ArrayList<Utilisateur>();
			
		for (UtilisateurDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la utilisateur existe
			Utilisateur entityToSave = null;
			entityToSave = utilisateurRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("utilisateur id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			if (Utilities.notBlank(dto.getNom())) {
				entityToSave.setNom(dto.getNom());
			}
			if (Utilities.notBlank(dto.getUsername())) {
				entityToSave.setUsername(dto.getUsername());
			}
			if (Utilities.notBlank(dto.getPrenom())) {
				entityToSave.setPrenom(dto.getPrenom());
			}
			if (Utilities.notBlank(dto.getEmail())) {
				entityToSave.setEmail(dto.getEmail());
			}
			if (Utilities.notBlank(dto.getTelephone())) {
				entityToSave.setTelephone(dto.getTelephone());
			}
			if (Utilities.notBlank(dto.getTelephone2())) {
				entityToSave.setTelephone2(dto.getTelephone2());
			}
			if (Utilities.notBlank(dto.getMotDePasse())) {
				entityToSave.setMotDePasse(dto.getMotDePasse());
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
			if (dto.getIsLocked() != null) {
				entityToSave.setIsLocked(dto.getIsLocked());
			}
			if (dto.getTypeClient() != null && dto.getTypeClient() > 0) {
				entityToSave.setTypeClient(dto.getTypeClient());
			}
			entityToSave.setUpdatedBy(request.getUser());
			entityToSave.setUpdatedAt(Utilities.getCurrentDate());
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Utilisateur> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = utilisateurRepository.saveAll((Iterable<Utilisateur>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("utilisateur", locale));
				response.setHasError(true);
				return response;
			}
			List<UtilisateurDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UtilisateurTransformer.INSTANCE.toLiteDtos(itemsSaved) : UtilisateurTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update Utilisateur-----");
		return response;
	}

	/**
	 * delete Utilisateur by using UtilisateurDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurDto> delete(Request<UtilisateurDto> request, Locale locale)  {
		// System.out.println("----begin delete Utilisateur-----");

		Response<UtilisateurDto> response = new Response<UtilisateurDto>();
		List<Utilisateur>        items    = new ArrayList<Utilisateur>();
			
		for (UtilisateurDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la utilisateur existe
			Utilisateur existingEntity = null;

			existingEntity = utilisateurRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("utilisateur -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// vendeur
			List<Vendeur> listOfVendeur = vendeurRepository.findByUtilisateurId(existingEntity.getId(), false);
			if (listOfVendeur != null && !listOfVendeur.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfVendeur.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// customer
			List<Customer> listOfCustomer = customerRepository.findByUtilisateurId(existingEntity.getId(), false);
			if (listOfCustomer != null && !listOfCustomer.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfCustomer.size() + ")", locale));
				response.setHasError(true);
				return response;
			}
			// coursier
			List<Coursier> listOfCoursier = coursierRepository.findByUtilisateurId(existingEntity.getId(), false);
			if (listOfCoursier != null && !listOfCoursier.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfCoursier.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			utilisateurRepository.saveAll((Iterable<Utilisateur>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Utilisateur-----");
		return response;
	}

	/**
	 * get Utilisateur by using UtilisateurDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<UtilisateurDto> getByCriteria(Request<UtilisateurDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Utilisateur-----");

		Response<UtilisateurDto> response = new Response<UtilisateurDto>();
		List<Utilisateur> items 			 = utilisateurRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<UtilisateurDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? UtilisateurTransformer.INSTANCE.toLiteDtos(items) : UtilisateurTransformer.INSTANCE.toDtos(items);

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
			response.setCount(utilisateurRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("utilisateur", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Utilisateur-----");
		return response;
	}

	/**
	 * get full UtilisateurDto by using Utilisateur as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private UtilisateurDto getFullInfos(UtilisateurDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
