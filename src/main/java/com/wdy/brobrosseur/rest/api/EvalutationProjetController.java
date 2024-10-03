

/*
 * Java controller for entity table evalutation_projet 
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
Controller for table "evalutation_projet"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/evalutationProjet")
public class EvalutationProjetController {

	@Autowired
    private ControllerFactory<EvalutationProjetDto> controllerFactory;
	@Autowired
	private EvalutationProjetBusiness evalutationProjetBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvalutationProjetDto> create(@RequestBody Request<EvalutationProjetDto> request) {
    	// System.out.println("start method /evalutationProjet/create");
        Response<EvalutationProjetDto> response = controllerFactory.create(evalutationProjetBusiness, request, FunctionalityEnum.CREATE_EVALUTATION_PROJET);
		// System.out.println("end method /evalutationProjet/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvalutationProjetDto> update(@RequestBody Request<EvalutationProjetDto> request) {
    	// System.out.println("start method /evalutationProjet/update");
        Response<EvalutationProjetDto> response = controllerFactory.update(evalutationProjetBusiness, request, FunctionalityEnum.UPDATE_EVALUTATION_PROJET);
		// System.out.println("end method /evalutationProjet/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvalutationProjetDto> delete(@RequestBody Request<EvalutationProjetDto> request) {
    	// System.out.println("start method /evalutationProjet/delete");
        Response<EvalutationProjetDto> response = controllerFactory.delete(evalutationProjetBusiness, request, FunctionalityEnum.DELETE_EVALUTATION_PROJET);
		// System.out.println("end method /evalutationProjet/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvalutationProjetDto> getByCriteria(@RequestBody Request<EvalutationProjetDto> request) {
    	// System.out.println("start method /evalutationProjet/getByCriteria");
        Response<EvalutationProjetDto> response = controllerFactory.getByCriteria(evalutationProjetBusiness, request, FunctionalityEnum.VIEW_EVALUTATION_PROJET);
		// System.out.println("end method /evalutationProjet/getByCriteria");
        return response;
    }
}
