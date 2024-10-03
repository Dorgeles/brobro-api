

/*
 * Created on 2024-09-29 ( Time 22:05:30 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package com.wdy.brobrosseur.business.fact;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wdy.brobrosseur.utils.ExceptionUtils;
import com.wdy.brobrosseur.utils.FunctionalError;
import com.wdy.brobrosseur.utils.Validate;
import com.wdy.brobrosseur.utils.Utilities;
import com.wdy.brobrosseur.utils.contract.IBasicBusiness;
import com.wdy.brobrosseur.utils.contract.Request;
import com.wdy.brobrosseur.utils.contract.Response;
import com.wdy.brobrosseur.utils.enums.FunctionalityEnum;
import com.wdy.brobrosseur.business.fact.BusinessFactory;

import com.wdy.brobrosseur.dao.entity.Utilisateur;
import com.wdy.brobrosseur.dao.repository.UtilisateurRepository;
import com.wdy.brobrosseur.utils.dto.UtilisateurDto;


/**
 * BUSINESS factory
 *
 * @author Geo
 */

@Component
public class BusinessFactory<DTO> {

    @Autowired
    private UtilisateurRepository userRepository;
    @Autowired
    private FunctionalError functionalError;
    @Autowired
    private ExceptionUtils exceptionUtils;

    /**
     * create entity by using dto as object.
     *
     * @param request
     * @return response
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public Response<DTO> create(IBasicBusiness<Request<DTO>, Response<DTO>> iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum, Locale locale) {
        Response<DTO> response = new Response<DTO>();
        try {
            checkUserAccess(request, functionalityEnum, locale);
            response = iBasicBusiness.create(request, locale);
        } catch (PermissionDeniedDataAccessException e) {
            exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (DataAccessResourceFailureException e) {
            exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
        } catch (DataAccessException e) {
            exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        } finally {
            if (response.isHasError() && response.getStatus() != null) {
                 throw new RuntimeException(response.getStatus().getCode() + ";" + response.getStatus().getMessage());
            }
        }
        return response;
    }

    /**
     * update entity by using dto as object.
     *
     * @param request
     * @return response
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public Response<DTO> update(IBasicBusiness<Request<DTO>, Response<DTO>> iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum, Locale locale) {
        Response<DTO> response = new Response<DTO>();
        try {
            checkUserAccess(request, functionalityEnum, locale);
            response = iBasicBusiness.update(request, locale);
        } catch (PermissionDeniedDataAccessException e) {
            exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (DataAccessResourceFailureException e) {
            exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
        } catch (DataAccessException e) {
            exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        } finally {
            if (response.isHasError() && response.getStatus() != null) {
                 throw new RuntimeException(response.getStatus().getCode() + ";" + response.getStatus().getMessage());
            }
        }
        return response;
    }

    /**
     * delete entity by using dto as object.
     *
     * @param request
     * @return response
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public Response<DTO> delete(IBasicBusiness<Request<DTO>, Response<DTO>> iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum, Locale locale) {
        Response<DTO> response = new Response<DTO>();
        try {
            checkUserAccess(request, functionalityEnum, locale);
            response = iBasicBusiness.delete(request, locale);
        } catch (PermissionDeniedDataAccessException e) {
            exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (DataAccessResourceFailureException e) {
            exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
        } catch (DataAccessException e) {
            exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        } finally {
            if (response.isHasError() && response.getStatus() != null) {
                 throw new RuntimeException(response.getStatus().getCode() + ";" + response.getStatus().getMessage());
            }
        }
        return response;
    }

    /**
     * delete entity by using dto as object.
     *
     * @param request
     * @return response
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public Response<DTO> getByCriteria(IBasicBusiness<Request<DTO>, Response<DTO>> iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum, Locale locale) {
        Response<DTO> response = new Response<DTO>();
        try {
            checkUserAccess(request, functionalityEnum, locale);
            response = iBasicBusiness.getByCriteria(request, locale);
        } catch (PermissionDeniedDataAccessException e) {
            exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (DataAccessResourceFailureException e) {
            exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
        } catch (DataAccessException e) {
            exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        } finally {
            if (response.isHasError() && response.getStatus() != null) {
                 throw new RuntimeException(response.getStatus().getCode() + ";" + response.getStatus().getMessage());
            }
        }
        return response;
    }

    private void checkUserAccess(Request<DTO> request, FunctionalityEnum functionalityEnum, Locale locale) {
        Map<String, java.lang.Object> fieldsToVerifyUser = new HashMap<String, java.lang.Object>();
        fieldsToVerifyUser.put("user", request.getUser());
        if (!Validate.RequiredValue(fieldsToVerifyUser).isGood()) {
            throw new RuntimeException(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale).getMessage());
        }

        Response<UtilisateurDto> userResponse = isGranted(request.getUser(), functionalityEnum.getValue(), locale);
        if (userResponse.isHasError()) {
            throw new RuntimeException(userResponse.getStatus().getMessage());
        }
    }

    /**
     * @param userId
     * @param functionalityCode
     * @param locale
     * @return
     */
    private Response<UtilisateurDto> isGranted(Integer userId, String functionalityCode, Locale locale) {
        // System.out.println("----begin get isGranted-----");

        Response<UtilisateurDto> response = new Response<UtilisateurDto>();

        try {
            Utilisateur currentUser = userRepository.findOne(userId, false);
            if (currentUser == null) {
                response.setStatus(functionalError.DATA_NOT_EXIST("Utilisateur -> " + userId, locale));
                response.setHasError(true);
                return response;
            }
            if (Utilities.isTrue(currentUser.getIsLocked())) {
                response.setStatus(functionalError.REQUEST_FAIL("L'utilisateur " + currentUser.getUsername() + " est verouille(e)", locale));
                response.setHasError(true);
                return response;
            }
            response.setHasError(false);
        } catch (PermissionDeniedDataAccessException e) {
            exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (DataAccessResourceFailureException e) {
            exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
        } catch (DataAccessException e) {
            exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        } finally {
            if (response.isHasError() && response.getStatus() != null) {
                throw new RuntimeException(response.getStatus().getCode() + ";" + response.getStatus().getMessage());
            }
        }

        return response;
    }

}
