

/*
 * Java controller for entity table coursier_moyen_deplacement 
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
Controller for table "coursier_moyen_deplacement"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/coursierMoyenDeplacement")
public class CoursierMoyenDeplacementController {

	@Autowired
    private ControllerFactory<CoursierMoyenDeplacementDto> controllerFactory;
	@Autowired
	private CoursierMoyenDeplacementBusiness coursierMoyenDeplacementBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CoursierMoyenDeplacementDto> create(@RequestBody Request<CoursierMoyenDeplacementDto> request) {
    	// System.out.println("start method /coursierMoyenDeplacement/create");
        Response<CoursierMoyenDeplacementDto> response = controllerFactory.create(coursierMoyenDeplacementBusiness, request, FunctionalityEnum.CREATE_COURSIER_MOYEN_DEPLACEMENT);
		// System.out.println("end method /coursierMoyenDeplacement/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CoursierMoyenDeplacementDto> update(@RequestBody Request<CoursierMoyenDeplacementDto> request) {
    	// System.out.println("start method /coursierMoyenDeplacement/update");
        Response<CoursierMoyenDeplacementDto> response = controllerFactory.update(coursierMoyenDeplacementBusiness, request, FunctionalityEnum.UPDATE_COURSIER_MOYEN_DEPLACEMENT);
		// System.out.println("end method /coursierMoyenDeplacement/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CoursierMoyenDeplacementDto> delete(@RequestBody Request<CoursierMoyenDeplacementDto> request) {
    	// System.out.println("start method /coursierMoyenDeplacement/delete");
        Response<CoursierMoyenDeplacementDto> response = controllerFactory.delete(coursierMoyenDeplacementBusiness, request, FunctionalityEnum.DELETE_COURSIER_MOYEN_DEPLACEMENT);
		// System.out.println("end method /coursierMoyenDeplacement/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CoursierMoyenDeplacementDto> getByCriteria(@RequestBody Request<CoursierMoyenDeplacementDto> request) {
    	// System.out.println("start method /coursierMoyenDeplacement/getByCriteria");
        Response<CoursierMoyenDeplacementDto> response = controllerFactory.getByCriteria(coursierMoyenDeplacementBusiness, request, FunctionalityEnum.VIEW_COURSIER_MOYEN_DEPLACEMENT);
		// System.out.println("end method /coursierMoyenDeplacement/getByCriteria");
        return response;
    }
}
