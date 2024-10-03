

/*
 * Java controller for entity table zone_livraison 
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
Controller for table "zone_livraison"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/zoneLivraison")
public class ZoneLivraisonController {

	@Autowired
    private ControllerFactory<ZoneLivraisonDto> controllerFactory;
	@Autowired
	private ZoneLivraisonBusiness zoneLivraisonBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ZoneLivraisonDto> create(@RequestBody Request<ZoneLivraisonDto> request) {
    	// System.out.println("start method /zoneLivraison/create");
        Response<ZoneLivraisonDto> response = controllerFactory.create(zoneLivraisonBusiness, request, FunctionalityEnum.CREATE_ZONE_LIVRAISON);
		// System.out.println("end method /zoneLivraison/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ZoneLivraisonDto> update(@RequestBody Request<ZoneLivraisonDto> request) {
    	// System.out.println("start method /zoneLivraison/update");
        Response<ZoneLivraisonDto> response = controllerFactory.update(zoneLivraisonBusiness, request, FunctionalityEnum.UPDATE_ZONE_LIVRAISON);
		// System.out.println("end method /zoneLivraison/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ZoneLivraisonDto> delete(@RequestBody Request<ZoneLivraisonDto> request) {
    	// System.out.println("start method /zoneLivraison/delete");
        Response<ZoneLivraisonDto> response = controllerFactory.delete(zoneLivraisonBusiness, request, FunctionalityEnum.DELETE_ZONE_LIVRAISON);
		// System.out.println("end method /zoneLivraison/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<ZoneLivraisonDto> getByCriteria(@RequestBody Request<ZoneLivraisonDto> request) {
    	// System.out.println("start method /zoneLivraison/getByCriteria");
        Response<ZoneLivraisonDto> response = controllerFactory.getByCriteria(zoneLivraisonBusiness, request, FunctionalityEnum.VIEW_ZONE_LIVRAISON);
		// System.out.println("end method /zoneLivraison/getByCriteria");
        return response;
    }
}
