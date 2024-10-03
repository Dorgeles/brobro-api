

/*
 * Java controller for entity table prestation 
 * Created on 2024-09-29 ( Time 23:04:15 )
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
Controller for table "prestation"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/prestation")
public class PrestationController {

	@Autowired
    private ControllerFactory<PrestationDto> controllerFactory;
	@Autowired
	private PrestationBusiness prestationBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestationDto> create(@RequestBody Request<PrestationDto> request) {
    	// System.out.println("start method /prestation/create");
        Response<PrestationDto> response = controllerFactory.create(prestationBusiness, request, FunctionalityEnum.CREATE_PRESTATION);
		// System.out.println("end method /prestation/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestationDto> update(@RequestBody Request<PrestationDto> request) {
    	// System.out.println("start method /prestation/update");
        Response<PrestationDto> response = controllerFactory.update(prestationBusiness, request, FunctionalityEnum.UPDATE_PRESTATION);
		// System.out.println("end method /prestation/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestationDto> delete(@RequestBody Request<PrestationDto> request) {
    	// System.out.println("start method /prestation/delete");
        Response<PrestationDto> response = controllerFactory.delete(prestationBusiness, request, FunctionalityEnum.DELETE_PRESTATION);
		// System.out.println("end method /prestation/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestationDto> getByCriteria(@RequestBody Request<PrestationDto> request) {
    	// System.out.println("start method /prestation/getByCriteria");
        Response<PrestationDto> response = controllerFactory.getByCriteria(prestationBusiness, request, FunctionalityEnum.VIEW_PRESTATION);
		// System.out.println("end method /prestation/getByCriteria");
        return response;
    }
}
