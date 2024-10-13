

/*
 * Java controller for entity table setting 
 * Created on 2024-10-12 ( Time 17:44:58 )
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
Controller for table "setting"
 * 
 * @author SFL Back-End developper
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping(value="/setting")
public class SettingController {

	@Autowired
    private ControllerFactory<SettingDto> controllerFactory;
	@Autowired
	private SettingBusiness settingBusiness;

	@RequestMapping(value="/create",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<SettingDto> create(@RequestBody Request<SettingDto> request) {
    	// System.out.println("start method /setting/create");
        Response<SettingDto> response = controllerFactory.create(settingBusiness, request, FunctionalityEnum.CREATE_SETTING);
		// System.out.println("end method /setting/create");
        return response;
    }

	@RequestMapping(value="/update",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<SettingDto> update(@RequestBody Request<SettingDto> request) {
    	// System.out.println("start method /setting/update");
        Response<SettingDto> response = controllerFactory.update(settingBusiness, request, FunctionalityEnum.UPDATE_SETTING);
		// System.out.println("end method /setting/update");
        return response;
    }

	@RequestMapping(value="/delete",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<SettingDto> delete(@RequestBody Request<SettingDto> request) {
    	// System.out.println("start method /setting/delete");
        Response<SettingDto> response = controllerFactory.delete(settingBusiness, request, FunctionalityEnum.DELETE_SETTING);
		// System.out.println("end method /setting/delete");
        return response;
    }

	@RequestMapping(value="/getByCriteria",method=RequestMethod.POST,consumes = {"application/json"},produces={"application/json"})
    public Response<SettingDto> getByCriteria(@RequestBody Request<SettingDto> request) {
    	// System.out.println("start method /setting/getByCriteria");
        Response<SettingDto> response = controllerFactory.getByCriteria(settingBusiness, request, FunctionalityEnum.VIEW_SETTING);
		// System.out.println("end method /setting/getByCriteria");
        return response;
    }
}
