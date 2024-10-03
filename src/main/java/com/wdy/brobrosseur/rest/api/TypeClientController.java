

/*
 * Java controller for entity table type_client 
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
Controller for table "type_client"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/typeClient")
public class TypeClientController {

	@Autowired
    private ControllerFactory<TypeClientDto> controllerFactory;
	@Autowired
	private TypeClientBusiness typeClientBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<TypeClientDto> create(@RequestBody Request<TypeClientDto> request) {
    	// System.out.println("start method /typeClient/create");
        Response<TypeClientDto> response = controllerFactory.create(typeClientBusiness, request, FunctionalityEnum.CREATE_TYPE_CLIENT);
		// System.out.println("end method /typeClient/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<TypeClientDto> update(@RequestBody Request<TypeClientDto> request) {
    	// System.out.println("start method /typeClient/update");
        Response<TypeClientDto> response = controllerFactory.update(typeClientBusiness, request, FunctionalityEnum.UPDATE_TYPE_CLIENT);
		// System.out.println("end method /typeClient/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<TypeClientDto> delete(@RequestBody Request<TypeClientDto> request) {
    	// System.out.println("start method /typeClient/delete");
        Response<TypeClientDto> response = controllerFactory.delete(typeClientBusiness, request, FunctionalityEnum.DELETE_TYPE_CLIENT);
		// System.out.println("end method /typeClient/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<TypeClientDto> getByCriteria(@RequestBody Request<TypeClientDto> request) {
    	// System.out.println("start method /typeClient/getByCriteria");
        Response<TypeClientDto> response = controllerFactory.getByCriteria(typeClientBusiness, request, FunctionalityEnum.VIEW_TYPE_CLIENT);
		// System.out.println("end method /typeClient/getByCriteria");
        return response;
    }
}
