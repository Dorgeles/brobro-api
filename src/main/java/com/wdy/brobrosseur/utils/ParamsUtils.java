
/*
 * Created on 2024-09-29 ( Time 22:05:30 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2018 Geo. All Rights Reserved.
 */

package com.wdy.brobrosseur.utils;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Params Utils
 *
 * @author Geo
 */

@Component
@Getter
@NoArgsConstructor
@ToString
public class ParamsUtils {


    @Value("${spring.minio.url}")
    private String minioUrl;

    @Value("${spring.minio.access-key}")
    private String minioAccessKey;

    @Value("${spring.minio.secret-key}")
    private String minioSecretKey;

    @Value("${spring.minio.bucket}")
    private String minioBucketName;
}
