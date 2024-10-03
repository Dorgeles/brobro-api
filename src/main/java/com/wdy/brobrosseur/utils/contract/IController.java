
/*
 * Created on 2024-09-29 ( Time 22:05:30 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.contract;

import com.wdy.brobrosseur.utils.enums.*;

/**
 * IController
 * 
 * @author Geo
 *
 */
public interface IController<DTO> {
    Response<DTO> create(IBasicBusiness iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum);

    Response<DTO> update(IBasicBusiness iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum);

    Response<DTO> delete(IBasicBusiness iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum);

    Response<DTO> getByCriteria(IBasicBusiness iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum);
}

