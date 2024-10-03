

/*
 * Java controller for entity table customer 
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
Controller for table "customer"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
    private ControllerFactory<CustomerDto> controllerFactory;
	@Autowired
	private CustomerBusiness customerBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CustomerDto> create(@RequestBody Request<CustomerDto> request) {
    	// System.out.println("start method /customer/create");
        Response<CustomerDto> response = controllerFactory.create(customerBusiness, request, FunctionalityEnum.CREATE_CUSTOMER);
		// System.out.println("end method /customer/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CustomerDto> update(@RequestBody Request<CustomerDto> request) {
    	// System.out.println("start method /customer/update");
        Response<CustomerDto> response = controllerFactory.update(customerBusiness, request, FunctionalityEnum.UPDATE_CUSTOMER);
		// System.out.println("end method /customer/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CustomerDto> delete(@RequestBody Request<CustomerDto> request) {
    	// System.out.println("start method /customer/delete");
        Response<CustomerDto> response = controllerFactory.delete(customerBusiness, request, FunctionalityEnum.DELETE_CUSTOMER);
		// System.out.println("end method /customer/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CustomerDto> getByCriteria(@RequestBody Request<CustomerDto> request) {
    	// System.out.println("start method /customer/getByCriteria");
        Response<CustomerDto> response = controllerFactory.getByCriteria(customerBusiness, request, FunctionalityEnum.VIEW_CUSTOMER);
		// System.out.println("end method /customer/getByCriteria");
        return response;
    }
}
