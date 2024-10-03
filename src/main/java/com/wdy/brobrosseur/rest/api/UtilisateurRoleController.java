

/*
 * Java controller for entity table utilisateur_role 
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
Controller for table "utilisateur_role"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/utilisateurRole")
public class UtilisateurRoleController {

	@Autowired
    private ControllerFactory<UtilisateurRoleDto> controllerFactory;
	@Autowired
	private UtilisateurRoleBusiness utilisateurRoleBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurRoleDto> create(@RequestBody Request<UtilisateurRoleDto> request) {
    	// System.out.println("start method /utilisateurRole/create");
        Response<UtilisateurRoleDto> response = controllerFactory.create(utilisateurRoleBusiness, request, FunctionalityEnum.CREATE_UTILISATEUR_ROLE);
		// System.out.println("end method /utilisateurRole/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurRoleDto> update(@RequestBody Request<UtilisateurRoleDto> request) {
    	// System.out.println("start method /utilisateurRole/update");
        Response<UtilisateurRoleDto> response = controllerFactory.update(utilisateurRoleBusiness, request, FunctionalityEnum.UPDATE_UTILISATEUR_ROLE);
		// System.out.println("end method /utilisateurRole/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurRoleDto> delete(@RequestBody Request<UtilisateurRoleDto> request) {
    	// System.out.println("start method /utilisateurRole/delete");
        Response<UtilisateurRoleDto> response = controllerFactory.delete(utilisateurRoleBusiness, request, FunctionalityEnum.DELETE_UTILISATEUR_ROLE);
		// System.out.println("end method /utilisateurRole/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<UtilisateurRoleDto> getByCriteria(@RequestBody Request<UtilisateurRoleDto> request) {
    	// System.out.println("start method /utilisateurRole/getByCriteria");
        Response<UtilisateurRoleDto> response = controllerFactory.getByCriteria(utilisateurRoleBusiness, request, FunctionalityEnum.VIEW_UTILISATEUR_ROLE);
		// System.out.println("end method /utilisateurRole/getByCriteria");
        return response;
    }
}
