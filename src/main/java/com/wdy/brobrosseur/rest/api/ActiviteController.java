

/*
 * Java controller for entity table activite 
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
Controller for table "activite"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/activite")
public class ActiviteController {

	@Autowired
    private ControllerFactory<ActiviteDto> controllerFactory;
	@Autowired
	private ActiviteBusiness activiteBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ActiviteDto> create(@RequestBody Request<ActiviteDto> request) {
    	// System.out.println("start method /activite/create");
        Response<ActiviteDto> response = controllerFactory.create(activiteBusiness, request, FunctionalityEnum.CREATE_ACTIVITE);
		// System.out.println("end method /activite/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ActiviteDto> update(@RequestBody Request<ActiviteDto> request) {
    	// System.out.println("start method /activite/update");
        Response<ActiviteDto> response = controllerFactory.update(activiteBusiness, request, FunctionalityEnum.UPDATE_ACTIVITE);
		// System.out.println("end method /activite/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ActiviteDto> delete(@RequestBody Request<ActiviteDto> request) {
    	// System.out.println("start method /activite/delete");
        Response<ActiviteDto> response = controllerFactory.delete(activiteBusiness, request, FunctionalityEnum.DELETE_ACTIVITE);
		// System.out.println("end method /activite/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ActiviteDto> getByCriteria(@RequestBody Request<ActiviteDto> request) {
    	// System.out.println("start method /activite/getByCriteria");
        Response<ActiviteDto> response = controllerFactory.getByCriteria(activiteBusiness, request, FunctionalityEnum.VIEW_ACTIVITE);
		// System.out.println("end method /activite/getByCriteria");
        return response;
    }
}
