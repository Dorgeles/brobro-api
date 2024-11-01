package com.wdy.brobrosseur.utils;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
public class MinioClientConfig {
    @Autowired
    private ParamsUtils paramsUtils;

}
