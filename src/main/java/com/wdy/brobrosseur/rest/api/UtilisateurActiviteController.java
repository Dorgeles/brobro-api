

/*
 * Java controller for entity table utilisateur_activite 
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
Controller for table "utilisateur_activite"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/utilisateurActivite")
public class UtilisateurActiviteController {

	@Autowired
    private ControllerFactory<UtilisateurActiviteDto> controllerFactory;
	@Autowired
	private UtilisateurActiviteBusiness utilisateurActiviteBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurActiviteDto> create(@RequestBody Request<UtilisateurActiviteDto> request) {
    	// System.out.println("start method /utilisateurActivite/create");
        Response<UtilisateurActiviteDto> response = controllerFactory.create(utilisateurActiviteBusiness, request, FunctionalityEnum.CREATE_UTILISATEUR_ACTIVITE);
		// System.out.println("end method /utilisateurActivite/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurActiviteDto> update(@RequestBody Request<UtilisateurActiviteDto> request) {
    	// System.out.println("start method /utilisateurActivite/update");
        Response<UtilisateurActiviteDto> response = controllerFactory.update(utilisateurActiviteBusiness, request, FunctionalityEnum.UPDATE_UTILISATEUR_ACTIVITE);
		// System.out.println("end method /utilisateurActivite/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurActiviteDto> delete(@RequestBody Request<UtilisateurActiviteDto> request) {
    	// System.out.println("start method /utilisateurActivite/delete");
        Response<UtilisateurActiviteDto> response = controllerFactory.delete(utilisateurActiviteBusiness, request, FunctionalityEnum.DELETE_UTILISATEUR_ACTIVITE);
		// System.out.println("end method /utilisateurActivite/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurActiviteDto> getByCriteria(@RequestBody Request<UtilisateurActiviteDto> request) {
    	// System.out.println("start method /utilisateurActivite/getByCriteria");
        Response<UtilisateurActiviteDto> response = controllerFactory.getByCriteria(utilisateurActiviteBusiness, request, FunctionalityEnum.VIEW_UTILISATEUR_ACTIVITE);
		// System.out.println("end method /utilisateurActivite/getByCriteria");
        return response;
    }
}
