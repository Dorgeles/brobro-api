

/*
 * Java controller for entity table evaluation_command 
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
Controller for table "evaluation_command"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/evaluationCommand")
public class EvaluationCommandController {

	@Autowired
    private ControllerFactory<EvaluationCommandDto> controllerFactory;
	@Autowired
	private EvaluationCommandBusiness evaluationCommandBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvaluationCommandDto> create(@RequestBody Request<EvaluationCommandDto> request) {
    	// System.out.println("start method /evaluationCommand/create");
        Response<EvaluationCommandDto> response = controllerFactory.create(evaluationCommandBusiness, request, FunctionalityEnum.CREATE_EVALUATION_COMMAND);
		// System.out.println("end method /evaluationCommand/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvaluationCommandDto> update(@RequestBody Request<EvaluationCommandDto> request) {
    	// System.out.println("start method /evaluationCommand/update");
        Response<EvaluationCommandDto> response = controllerFactory.update(evaluationCommandBusiness, request, FunctionalityEnum.UPDATE_EVALUATION_COMMAND);
		// System.out.println("end method /evaluationCommand/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvaluationCommandDto> delete(@RequestBody Request<EvaluationCommandDto> request) {
    	// System.out.println("start method /evaluationCommand/delete");
        Response<EvaluationCommandDto> response = controllerFactory.delete(evaluationCommandBusiness, request, FunctionalityEnum.DELETE_EVALUATION_COMMAND);
		// System.out.println("end method /evaluationCommand/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<EvaluationCommandDto> getByCriteria(@RequestBody Request<EvaluationCommandDto> request) {
    	// System.out.println("start method /evaluationCommand/getByCriteria");
        Response<EvaluationCommandDto> response = controllerFactory.getByCriteria(evaluationCommandBusiness, request, FunctionalityEnum.VIEW_EVALUATION_COMMAND);
		// System.out.println("end method /evaluationCommand/getByCriteria");
        return response;
    }
}
