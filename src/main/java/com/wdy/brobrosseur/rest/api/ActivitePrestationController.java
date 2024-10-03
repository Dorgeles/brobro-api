

/*
 * Java controller for entity table activite_prestation 
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
Controller for table "activite_prestation"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/activitePrestation")
public class ActivitePrestationController {

	@Autowired
    private ControllerFactory<ActivitePrestationDto> controllerFactory;
	@Autowired
	private ActivitePrestationBusiness activitePrestationBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ActivitePrestationDto> create(@RequestBody Request<ActivitePrestationDto> request) {
    	// System.out.println("start method /activitePrestation/create");
        Response<ActivitePrestationDto> response = controllerFactory.create(activitePrestationBusiness, request, FunctionalityEnum.CREATE_ACTIVITE_PRESTATION);
		// System.out.println("end method /activitePrestation/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ActivitePrestationDto> update(@RequestBody Request<ActivitePrestationDto> request) {
    	// System.out.println("start method /activitePrestation/update");
        Response<ActivitePrestationDto> response = controllerFactory.update(activitePrestationBusiness, request, FunctionalityEnum.UPDATE_ACTIVITE_PRESTATION);
		// System.out.println("end method /activitePrestation/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ActivitePrestationDto> delete(@RequestBody Request<ActivitePrestationDto> request) {
    	// System.out.println("start method /activitePrestation/delete");
        Response<ActivitePrestationDto> response = controllerFactory.delete(activitePrestationBusiness, request, FunctionalityEnum.DELETE_ACTIVITE_PRESTATION);
		// System.out.println("end method /activitePrestation/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ActivitePrestationDto> getByCriteria(@RequestBody Request<ActivitePrestationDto> request) {
    	// System.out.println("start method /activitePrestation/getByCriteria");
        Response<ActivitePrestationDto> response = controllerFactory.getByCriteria(activitePrestationBusiness, request, FunctionalityEnum.VIEW_ACTIVITE_PRESTATION);
		// System.out.println("end method /activitePrestation/getByCriteria");
        return response;
    }
}
