

/*
 * Java controller for entity table utilisateur 
 * Created on 2024-10-03 ( Time 13:00:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package com.wdy.brobrosseur.rest.api;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wdy.brobrosseur.utils.*;
import com.wdy.brobrosseur.utils.dto.*;
import com.wdy.brobrosseur.utils.contract.*;
import com.wdy.brobrosseur.utils.contract.Request;
import com.wdy.brobrosseur.utils.contract.Response;
import com.wdy.brobrosseur.utils.enums.FunctionalityEnum;
import com.wdy.brobrosseur.business.*;
import com.wdy.brobrosseur.rest.fact.ControllerFactory;

/**
Controller for table "utilisateur"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/utilisateur")
public class UtilisateurController {

	@Autowired
    private ControllerFactory<UtilisateurDto> controllerFactory;
	@Autowired
	private UtilisateurBusiness utilisateurBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurDto> create(@RequestBody Request<UtilisateurDto> request) {
    	// System.out.println("start method /utilisateur/create");
        Response<UtilisateurDto> response = controllerFactory.create(utilisateurBusiness, request, FunctionalityEnum.CREATE_UTILISATEUR);
		// System.out.println("end method /utilisateur/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurDto> update(@RequestBody Request<UtilisateurDto> request) {
    	// System.out.println("start method /utilisateur/update");
        Response<UtilisateurDto> response = controllerFactory.update(utilisateurBusiness, request, FunctionalityEnum.UPDATE_UTILISATEUR);
		// System.out.println("end method /utilisateur/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurDto> delete(@RequestBody Request<UtilisateurDto> request) {
    	// System.out.println("start method /utilisateur/delete");
        Response<UtilisateurDto> response = controllerFactory.delete(utilisateurBusiness, request, FunctionalityEnum.DELETE_UTILISATEUR);
		// System.out.println("end method /utilisateur/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurDto> getByCriteria(@RequestBody Request<UtilisateurDto> request) {
    	// System.out.println("start method /utilisateur/getByCriteria");
        Response<UtilisateurDto> response = controllerFactory.getByCriteria(utilisateurBusiness, request, FunctionalityEnum.VIEW_UTILISATEUR);
		// System.out.println("end method /utilisateur/getByCriteria");
        return response;
    }
}
