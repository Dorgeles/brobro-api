

/*
 * Java controller for entity table role 
 * Created on 2024-10-03 ( Time 13:00:22 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package com.wdy.brobrosseur.rest.api;

import io.minio.errors.MinioException;
import io.minio.messages.Bucket;
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

import java.util.List;

/**
Controller for table "role"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/role")
public class RoleController {

	@Autowired
    private ControllerFactory<RoleDto> controllerFactory;
	@Autowired
	private RoleBusiness roleBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RoleDto> create(@RequestBody Request<RoleDto> request) {
    	// System.out.println("start method /role/create");
        Response<RoleDto> response = controllerFactory.create(roleBusiness, request, FunctionalityEnum.CREATE_ROLE);
		// System.out.println("end method /role/create");
        return response;
    }

    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public String get() throws Exception {
    	 System.out.println("start method /role/get");
         String status = roleBusiness.getMinioTry();
        return status;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RoleDto> update(@RequestBody Request<RoleDto> request) {
    	// System.out.println("start method /role/update");
        Response<RoleDto> response = controllerFactory.update(roleBusiness, request, FunctionalityEnum.UPDATE_ROLE);
		// System.out.println("end method /role/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RoleDto> delete(@RequestBody Request<RoleDto> request) {
    	// System.out.println("start method /role/delete");
        Response<RoleDto> response = controllerFactory.delete(roleBusiness, request, FunctionalityEnum.DELETE_ROLE);
		// System.out.println("end method /role/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<RoleDto> getByCriteria(@RequestBody Request<RoleDto> request) {
    	// System.out.println("start method /role/getByCriteria");
        Response<RoleDto> response = controllerFactory.getByCriteria(roleBusiness, request, FunctionalityEnum.VIEW_ROLE);
		// System.out.println("end method /role/getByCriteria");
        return response;
    }
}
