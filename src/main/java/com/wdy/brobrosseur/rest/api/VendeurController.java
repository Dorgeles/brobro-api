

/*
 * Java controller for entity table vendeur 
 * Created on 2024-09-29 ( Time 22:05:55 )
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
Controller for table "vendeur"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/vendeur")
public class VendeurController {

	@Autowired
    private ControllerFactory<VendeurDto> controllerFactory;
	@Autowired
	private VendeurBusiness vendeurBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<VendeurDto> create(@RequestBody Request<VendeurDto> request) {
    	// System.out.println("start method /vendeur/create");
        Response<VendeurDto> response = controllerFactory.create(vendeurBusiness, request, FunctionalityEnum.CREATE_VENDEUR);
		// System.out.println("end method /vendeur/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<VendeurDto> update(@RequestBody Request<VendeurDto> request) {
    	// System.out.println("start method /vendeur/update");
        Response<VendeurDto> response = controllerFactory.update(vendeurBusiness, request, FunctionalityEnum.UPDATE_VENDEUR);
		// System.out.println("end method /vendeur/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<VendeurDto> delete(@RequestBody Request<VendeurDto> request) {
    	// System.out.println("start method /vendeur/delete");
        Response<VendeurDto> response = controllerFactory.delete(vendeurBusiness, request, FunctionalityEnum.DELETE_VENDEUR);
		// System.out.println("end method /vendeur/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<VendeurDto> getByCriteria(@RequestBody Request<VendeurDto> request) {
    	// System.out.println("start method /vendeur/getByCriteria");
        Response<VendeurDto> response = controllerFactory.getByCriteria(vendeurBusiness, request, FunctionalityEnum.VIEW_VENDEUR);
		// System.out.println("end method /vendeur/getByCriteria");
        return response;
    }
}
