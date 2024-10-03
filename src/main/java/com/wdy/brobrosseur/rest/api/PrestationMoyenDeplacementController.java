

/*
 * Java controller for entity table prestation_moyen_deplacement 
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
Controller for table "prestation_moyen_deplacement"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/prestationMoyenDeplacement")
public class PrestationMoyenDeplacementController {

	@Autowired
    private ControllerFactory<PrestationMoyenDeplacementDto> controllerFactory;
	@Autowired
	private PrestationMoyenDeplacementBusiness prestationMoyenDeplacementBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestationMoyenDeplacementDto> create(@RequestBody Request<PrestationMoyenDeplacementDto> request) {
    	// System.out.println("start method /prestationMoyenDeplacement/create");
        Response<PrestationMoyenDeplacementDto> response = controllerFactory.create(prestationMoyenDeplacementBusiness, request, FunctionalityEnum.CREATE_PRESTATION_MOYEN_DEPLACEMENT);
		// System.out.println("end method /prestationMoyenDeplacement/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestationMoyenDeplacementDto> update(@RequestBody Request<PrestationMoyenDeplacementDto> request) {
    	// System.out.println("start method /prestationMoyenDeplacement/update");
        Response<PrestationMoyenDeplacementDto> response = controllerFactory.update(prestationMoyenDeplacementBusiness, request, FunctionalityEnum.UPDATE_PRESTATION_MOYEN_DEPLACEMENT);
		// System.out.println("end method /prestationMoyenDeplacement/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestationMoyenDeplacementDto> delete(@RequestBody Request<PrestationMoyenDeplacementDto> request) {
    	// System.out.println("start method /prestationMoyenDeplacement/delete");
        Response<PrestationMoyenDeplacementDto> response = controllerFactory.delete(prestationMoyenDeplacementBusiness, request, FunctionalityEnum.DELETE_PRESTATION_MOYEN_DEPLACEMENT);
		// System.out.println("end method /prestationMoyenDeplacement/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<PrestationMoyenDeplacementDto> getByCriteria(@RequestBody Request<PrestationMoyenDeplacementDto> request) {
    	// System.out.println("start method /prestationMoyenDeplacement/getByCriteria");
        Response<PrestationMoyenDeplacementDto> response = controllerFactory.getByCriteria(prestationMoyenDeplacementBusiness, request, FunctionalityEnum.VIEW_PRESTATION_MOYEN_DEPLACEMENT);
		// System.out.println("end method /prestationMoyenDeplacement/getByCriteria");
        return response;
    }
}
