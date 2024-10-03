
/*
 * Created on 2024-09-29 ( Time 22:05:30 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils.contract;

import java.util.List;
import lombok.*;

/**
 * Search Param
 * 
 * @author Geo
 *
 */
@Data
@ToString
@NoArgsConstructor
public class SearchParam<T> {
	String  operator;
    T       start;
    T       end;
    List<T> datas;
    Float   distance;

    public SearchParam(String operator, T start, T end, List<T> datas, Float distance) {
        super();
        this.operator = operator;
        this.start    = start;
        this.end      = end;
        this.datas    = datas;
        this.distance = distance;
    }

    public SearchParam(String operator, T start, T end, List<T> datas) {
        this(operator, start, end, datas, null);
    }

    public SearchParam(String operator) {
        this(operator, null, null, null);
    }

    public SearchParam(String operator, T start, T end) {
        this(operator, start, end, null);
    }

    public SearchParam(String operator, List<T> datas) {
        this(operator, null, null, datas);
    }

    public SearchParam(String operator, Float distance) {
        this(operator, null, null, null, distance);
    }
}