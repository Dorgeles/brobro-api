

/*
 * Java controller for entity table evaluation_prestation 
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
Controller for table "evaluation_prestation"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/evaluationPrestation")
public class EvaluationPrestationController {

	@Autowired
    private ControllerFactory<EvaluationPrestationDto> controllerFactory;
	@Autowired
	private EvaluationPrestationBusiness evaluationPrestationBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvaluationPrestationDto> create(@RequestBody Request<EvaluationPrestationDto> request) {
    	// System.out.println("start method /evaluationPrestation/create");
        Response<EvaluationPrestationDto> response = controllerFactory.create(evaluationPrestationBusiness, request, FunctionalityEnum.CREATE_EVALUATION_PRESTATION);
		// System.out.println("end method /evaluationPrestation/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvaluationPrestationDto> update(@RequestBody Request<EvaluationPrestationDto> request) {
    	// System.out.println("start method /evaluationPrestation/update");
        Response<EvaluationPrestationDto> response = controllerFactory.update(evaluationPrestationBusiness, request, FunctionalityEnum.UPDATE_EVALUATION_PRESTATION);
		// System.out.println("end method /evaluationPrestation/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvaluationPrestationDto> delete(@RequestBody Request<EvaluationPrestationDto> request) {
    	// System.out.println("start method /evaluationPrestation/delete");
        Response<EvaluationPrestationDto> response = controllerFactory.delete(evaluationPrestationBusiness, request, FunctionalityEnum.DELETE_EVALUATION_PRESTATION);
		// System.out.println("end method /evaluationPrestation/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvaluationPrestationDto> getByCriteria(@RequestBody Request<EvaluationPrestationDto> request) {
    	// System.out.println("start method /evaluationPrestation/getByCriteria");
        Response<EvaluationPrestationDto> response = controllerFactory.getByCriteria(evaluationPrestationBusiness, request, FunctionalityEnum.VIEW_EVALUATION_PRESTATION);
		// System.out.println("end method /evaluationPrestation/getByCriteria");
        return response;
    }
}
