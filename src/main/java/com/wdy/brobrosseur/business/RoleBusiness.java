                                                    												
/*
 * Java business for entity table role 
 * Created on 2024-10-03 ( Time 13:00:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.business;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.UploadObjectArgs;
import io.minio.messages.Bucket;
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
import com.wdy.brobrosseur.dao.entity.Role;
import com.wdy.brobrosseur.dao.entity.*;
import com.wdy.brobrosseur.dao.repository.*;

/**
BUSINESS for table "role"
 * 
 * @author Geo
 *
 */

@Component
public class RoleBusiness implements IBasicBusiness<Request<RoleDto>, Response<RoleDto>> {

	private Response<RoleDto> response;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UtilisateurRoleRepository utilisateurRoleRepository;
	@Autowired
	private FunctionalError functionalError;
	@Autowired
	private TechnicalError technicalError;
	@Autowired
	private MinioClientConfig minioClientConfig;
	@Autowired
	private ExceptionUtils exceptionUtils;
	@PersistenceContext
	private EntityManager em;

	private SimpleDateFormat dateFormat;
	private SimpleDateFormat dateTimeFormat;

	public RoleBusiness() {
		dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		dateTimeFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}
	
	/**
	 * create Role by using RoleDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<RoleDto> create(Request<RoleDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin create Role-----");

		Response<RoleDto> response = new Response<RoleDto>();
		List<Role>        items    = new ArrayList<Role>();
			
		for (RoleDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
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

			// Verify if role to insert do not exist
			Role existingEntity = null;

/*
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("role id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

*/
			// verif unique libelle in db
			existingEntity = roleRepository.findByLibelle(dto.getLibelle(), false);
			if (existingEntity != null) {
				response.setStatus(functionalError.DATA_EXIST("role libelle -> " + dto.getLibelle(), locale));
				response.setHasError(true);
				return response;
			}
			// verif unique libelle in items to save
			if (items.stream().anyMatch(a -> a.getLibelle().equalsIgnoreCase(dto.getLibelle()))) {
				response.setStatus(functionalError.DATA_DUPLICATE(" libelle ", locale));
				response.setHasError(true);
				return response;
			}

				Role entityToSave = null;
			entityToSave = RoleTransformer.INSTANCE.toEntity(dto);
			entityToSave.setIsDeleted(false);
			entityToSave.setCreatedBy(request.getUser());
			entityToSave.setCreatedAt(Utilities.getCurrentDate());
			entityToSave.setStatusId(StatusEnum.ACTIVE);
			items.add(entityToSave);
		}

		if (!items.isEmpty()) {
			List<Role> itemsSaved = null;
			// inserer les donnees en base de donnees
			itemsSaved = roleRepository.saveAll((Iterable<Role>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("role", locale));
				response.setHasError(true);
				return response;
			}
			List<RoleDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? RoleTransformer.INSTANCE.toLiteDtos(itemsSaved) : RoleTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end create Role-----");
		return response;
	}


	public String getMinioTry()  throws Exception {
		try {
//			MinioClient minioClient = minioClientConfig.getMinioClientVIP();
//			List<Bucket> bList = minioClient.listBuckets();
//			System.out.println("Connection successful, total buckets : " + bList.size());
//
//			PutObjectArgs args = PutObjectArgs.builder()
//					.bucket("robrosseur")
//					.stream()
//					.build();
//
//			minioClient.putObject(args);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "ok";
	}

	/**
	 * update Role by using RoleDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<RoleDto> update(Request<RoleDto> request, Locale locale)  throws ParseException {
		// System.out.println("----begin update Role-----");

		Response<RoleDto> response = new Response<RoleDto>();
		List<Role>        items    = new ArrayList<Role>();
			
		for (RoleDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la role existe
			Role entityToSave = null;
			entityToSave = roleRepository.findOne(dto.getId(), false);
			if (entityToSave == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("role id -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
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
			List<Role> itemsSaved = null;
			// maj les donnees en base
			itemsSaved = roleRepository.saveAll((Iterable<Role>) items);
			if (itemsSaved == null) {
				response.setStatus(functionalError.SAVE_FAIL("role", locale));
				response.setHasError(true);
				return response;
			}
			List<RoleDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? RoleTransformer.INSTANCE.toLiteDtos(itemsSaved) : RoleTransformer.INSTANCE.toDtos(itemsSaved);

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

		// System.out.println("----end update Role-----");
		return response;
	}

	/**
	 * delete Role by using RoleDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<RoleDto> delete(Request<RoleDto> request, Locale locale)  {
		// System.out.println("----begin delete Role-----");

		Response<RoleDto> response = new Response<RoleDto>();
		List<Role>        items    = new ArrayList<Role>();
			
		for (RoleDto dto : request.getDatas()) {
			// Definir les parametres obligatoires
			Map<String, java.lang.Object> fieldsToVerify = new HashMap<String, java.lang.Object>();
			fieldsToVerify.put("id", dto.getId());
			if (!Validate.RequiredValue(fieldsToVerify).isGood()) {
				response.setStatus(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale));
				response.setHasError(true);
				return response;
			}

			// Verifier si la role existe
			Role existingEntity = null;

			existingEntity = roleRepository.findOne(dto.getId(), false);
			if (existingEntity == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("role -> " + dto.getId(), locale));
				response.setHasError(true);
				return response;
			}

			// -----------------------------------------------------------------------
			// ----------- CHECK IF DATA IS USED
			// -----------------------------------------------------------------------

			// utilisateurRole
			List<UtilisateurRole> listOfUtilisateurRole = utilisateurRoleRepository.findByRoleId(existingEntity.getId(), false);
			if (listOfUtilisateurRole != null && !listOfUtilisateurRole.isEmpty()){
				response.setStatus(functionalError.DATA_NOT_DELETABLE("(" + listOfUtilisateurRole.size() + ")", locale));
				response.setHasError(true);
				return response;
			}


			existingEntity.setIsDeleted(true);
			existingEntity.setDeletedAt(Utilities.getCurrentDate());
			items.add(existingEntity);
		}

		if (!items.isEmpty()) {
			// supprimer les donnees en base
			roleRepository.saveAll((Iterable<Role>) items);

			response.setHasError(false);
		}

		// System.out.println("----end delete Role-----");
		return response;
	}

	/**
	 * get Role by using RoleDto as object.
	 * 
	 * @param request
	 * @return response
	 * 
	 */
	@Override
	public Response<RoleDto> getByCriteria(Request<RoleDto> request, Locale locale)  throws Exception {
		// System.out.println("----begin get Role-----");

		Response<RoleDto> response = new Response<RoleDto>();
		List<Role> items 			 = roleRepository.getByCriteria(request, em, locale);

		if (items != null && !items.isEmpty()) {
			List<RoleDto> itemsDto = (Utilities.isTrue(request.getIsSimpleLoading())) ? RoleTransformer.INSTANCE.toLiteDtos(items) : RoleTransformer.INSTANCE.toDtos(items);

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
			response.setCount(roleRepository.count(request, em, locale));
			response.setHasError(false);
		} else {
			response.setStatus(functionalError.DATA_EMPTY("role", locale));
			response.setHasError(false);
			return response;
		}

		// System.out.println("----end get Role-----");
		return response;
	}

	/**
	 * get full RoleDto by using Role as object.
	 * 
	 * @param dto
	 * @param size
	 * @param isSimpleLoading
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	private RoleDto getFullInfos(RoleDto dto, Integer size, Boolean isSimpleLoading, Locale locale) throws Exception {
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
