

/*
 * Java controller for entity table prestataire_zone_livraison 
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
Controller for table "prestataire_zone_livraison"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/prestataireZoneLivraison")
public class PrestataireZoneLivraisonController {

	@Autowired
    private ControllerFactory<PrestataireZoneLivraisonDto> controllerFactory;
	@Autowired
	private PrestataireZoneLivraisonBusiness prestataireZoneLivraisonBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestataireZoneLivraisonDto> create(@RequestBody Request<PrestataireZoneLivraisonDto> request) {
    	// System.out.println("start method /prestataireZoneLivraison/create");
        Response<PrestataireZoneLivraisonDto> response = controllerFactory.create(prestataireZoneLivraisonBusiness, request, FunctionalityEnum.CREATE_PRESTATAIRE_ZONE_LIVRAISON);
		// System.out.println("end method /prestataireZoneLivraison/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestataireZoneLivraisonDto> update(@RequestBody Request<PrestataireZoneLivraisonDto> request) {
    	// System.out.println("start method /prestataireZoneLivraison/update");
        Response<PrestataireZoneLivraisonDto> response = controllerFactory.update(prestataireZoneLivraisonBusiness, request, FunctionalityEnum.UPDATE_PRESTATAIRE_ZONE_LIVRAISON);
		// System.out.println("end method /prestataireZoneLivraison/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestataireZoneLivraisonDto> delete(@RequestBody Request<PrestataireZoneLivraisonDto> request) {
    	// System.out.println("start method /prestataireZoneLivraison/delete");
        Response<PrestataireZoneLivraisonDto> response = controllerFactory.delete(prestataireZoneLivraisonBusiness, request, FunctionalityEnum.DELETE_PRESTATAIRE_ZONE_LIVRAISON);
		// System.out.println("end method /prestataireZoneLivraison/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestataireZoneLivraisonDto> getByCriteria(@RequestBody Request<PrestataireZoneLivraisonDto> request) {
    	// System.out.println("start method /prestataireZoneLivraison/getByCriteria");
        Response<PrestataireZoneLivraisonDto> response = controllerFactory.getByCriteria(prestataireZoneLivraisonBusiness, request, FunctionalityEnum.VIEW_PRESTATAIRE_ZONE_LIVRAISON);
		// System.out.println("end method /prestataireZoneLivraison/getByCriteria");
        return response;
    }
}
