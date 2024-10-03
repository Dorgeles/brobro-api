

/*
 * Java controller for entity table coursier 
 * Created on 2024-09-29 ( Time 22:05:54 )
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
Controller for table "coursier"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/coursier")
public class CoursierController {

	@Autowired
    private ControllerFactory<CoursierDto> controllerFactory;
	@Autowired
	private CoursierBusiness coursierBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CoursierDto> create(@RequestBody Request<CoursierDto> request) {
    	// System.out.println("start method /coursier/create");
        Response<CoursierDto> response = controllerFactory.create(coursierBusiness, request, FunctionalityEnum.CREATE_COURSIER);
		// System.out.println("end method /coursier/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CoursierDto> update(@RequestBody Request<CoursierDto> request) {
    	// System.out.println("start method /coursier/update");
        Response<CoursierDto> response = controllerFactory.update(coursierBusiness, request, FunctionalityEnum.UPDATE_COURSIER);
		// System.out.println("end method /coursier/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CoursierDto> delete(@RequestBody Request<CoursierDto> request) {
    	// System.out.println("start method /coursier/delete");
        Response<CoursierDto> response = controllerFactory.delete(coursierBusiness, request, FunctionalityEnum.DELETE_COURSIER);
		// System.out.println("end method /coursier/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CoursierDto> getByCriteria(@RequestBody Request<CoursierDto> request) {
    	// System.out.println("start method /coursier/getByCriteria");
        Response<CoursierDto> response = controllerFactory.getByCriteria(coursierBusiness, request, FunctionalityEnum.VIEW_COURSIER);
		// System.out.println("end method /coursier/getByCriteria");
        return response;
    }
}
