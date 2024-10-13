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

    @Bean
    public MinioClient getMinioClientVIP() {
        System.out.println(String.format("addresse VIP minio:: %s", paramsUtils.getMinioUrl()));
        return MinioClient
                .builder()
                .endpoint(paramsUtils.getMinioUrl())
                .credentials(paramsUtils.getMinioAccessKey(), paramsUtils.getMinioSecretKey())
                .build();
    }

    @Bean
    public MinioClient getMinioClientCurrentServer() throws UnknownHostException {
        String localhost = "http://localhost:9000";
        System.out.println(String.format("addresse local minio:: %s", localhost));
        return MinioClient
                .builder()
                .endpoint(localhost)
                .credentials(paramsUtils.getMinioAccessKey(), paramsUtils.getMinioSecretKey())
                .build();
    }
}
