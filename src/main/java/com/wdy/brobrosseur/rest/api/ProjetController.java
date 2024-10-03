

/*
 * Java controller for entity table projet 
 * Created on 2024-09-29 ( Time 23:02:37 )
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
Controller for table "projet"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/projet")
public class ProjetController {

	@Autowired
    private ControllerFactory<ProjetDto> controllerFactory;
	@Autowired
	private ProjetBusiness projetBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProjetDto> create(@RequestBody Request<ProjetDto> request) {
    	// System.out.println("start method /projet/create");
        Response<ProjetDto> response = controllerFactory.create(projetBusiness, request, FunctionalityEnum.CREATE_PROJET);
		// System.out.println("end method /projet/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProjetDto> update(@RequestBody Request<ProjetDto> request) {
    	// System.out.println("start method /projet/update");
        Response<ProjetDto> response = controllerFactory.update(projetBusiness, request, FunctionalityEnum.UPDATE_PROJET);
		// System.out.println("end method /projet/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProjetDto> delete(@RequestBody Request<ProjetDto> request) {
    	// System.out.println("start method /projet/delete");
        Response<ProjetDto> response = controllerFactory.delete(projetBusiness, request, FunctionalityEnum.DELETE_PROJET);
		// System.out.println("end method /projet/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ProjetDto> getByCriteria(@RequestBody Request<ProjetDto> request) {
    	// System.out.println("start method /projet/getByCriteria");
        Response<ProjetDto> response = controllerFactory.getByCriteria(projetBusiness, request, FunctionalityEnum.VIEW_PROJET);
		// System.out.println("end method /projet/getByCriteria");
        return response;
    }
}
