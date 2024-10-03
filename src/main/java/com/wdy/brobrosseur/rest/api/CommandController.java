

/*
 * Java controller for entity table command 
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
Controller for table "command"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/command")
public class CommandController {

	@Autowired
    private ControllerFactory<CommandDto> controllerFactory;
	@Autowired
	private CommandBusiness commandBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CommandDto> create(@RequestBody Request<CommandDto> request) {
    	// System.out.println("start method /command/create");
        Response<CommandDto> response = controllerFactory.create(commandBusiness, request, FunctionalityEnum.CREATE_COMMAND);
		// System.out.println("end method /command/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CommandDto> update(@RequestBody Request<CommandDto> request) {
    	// System.out.println("start method /command/update");
        Response<CommandDto> response = controllerFactory.update(commandBusiness, request, FunctionalityEnum.UPDATE_COMMAND);
		// System.out.println("end method /command/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CommandDto> delete(@RequestBody Request<CommandDto> request) {
    	// System.out.println("start method /command/delete");
        Response<CommandDto> response = controllerFactory.delete(commandBusiness, request, FunctionalityEnum.DELETE_COMMAND);
		// System.out.println("end method /command/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<CommandDto> getByCriteria(@RequestBody Request<CommandDto> request) {
    	// System.out.println("start method /command/getByCriteria");
        Response<CommandDto> response = controllerFactory.getByCriteria(commandBusiness, request, FunctionalityEnum.VIEW_COMMAND);
		// System.out.println("end method /command/getByCriteria");
        return response;
    }
}
