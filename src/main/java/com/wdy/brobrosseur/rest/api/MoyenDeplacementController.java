

/*
 * Java controller for entity table moyen_deplacement 
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
Controller for table "moyen_deplacement"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/moyenDeplacement")
public class MoyenDeplacementController {

	@Autowired
    private ControllerFactory<MoyenDeplacementDto> controllerFactory;
	@Autowired
	private MoyenDeplacementBusiness moyenDeplacementBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MoyenDeplacementDto> create(@RequestBody Request<MoyenDeplacementDto> request) {
    	// System.out.println("start method /moyenDeplacement/create");
        Response<MoyenDeplacementDto> response = controllerFactory.create(moyenDeplacementBusiness, request, FunctionalityEnum.CREATE_MOYEN_DEPLACEMENT);
		// System.out.println("end method /moyenDeplacement/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MoyenDeplacementDto> update(@RequestBody Request<MoyenDeplacementDto> request) {
    	// System.out.println("start method /moyenDeplacement/update");
        Response<MoyenDeplacementDto> response = controllerFactory.update(moyenDeplacementBusiness, request, FunctionalityEnum.UPDATE_MOYEN_DEPLACEMENT);
		// System.out.println("end method /moyenDeplacement/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MoyenDeplacementDto> delete(@RequestBody Request<MoyenDeplacementDto> request) {
    	// System.out.println("start method /moyenDeplacement/delete");
        Response<MoyenDeplacementDto> response = controllerFactory.delete(moyenDeplacementBusiness, request, FunctionalityEnum.DELETE_MOYEN_DEPLACEMENT);
		// System.out.println("end method /moyenDeplacement/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<MoyenDeplacementDto> getByCriteria(@RequestBody Request<MoyenDeplacementDto> request) {
    	// System.out.println("start method /moyenDeplacement/getByCriteria");
        Response<MoyenDeplacementDto> response = controllerFactory.getByCriteria(moyenDeplacementBusiness, request, FunctionalityEnum.VIEW_MOYEN_DEPLACEMENT);
		// System.out.println("end method /moyenDeplacement/getByCriteria");
        return response;
    }
}
