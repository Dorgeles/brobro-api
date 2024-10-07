//package com.wdy.brobrosseur.utils;
//
//import io.minio.MinioClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.net.UnknownHostException;
//
//@Component
//public class MinioClientConfig {
//    @Autowired
//    private ParamsUtils paramsUtils;
//
//    @Bean
//    public MinioClient getMinioClientVIP() {
//        log.info(String.format("addresse VIP minio:: %s", paramsUtils.getEndpoint()));
//        return MinioClient
//                .builder()
//                .endpoint(paramsUtils.getEndpoint())
//                .credentials(paramsUtils.getAccessKey(), paramsUtils.getSecretKey())
//                .build();
//    }
//
//    @Bean
//    public MinioClient getMinioClientCurrentServer() throws UnknownHostException {
//        String localhost = "http://174.18.3.201:8080";
//        log.info(String.format("addresse local minio:: %s", localhost));
//        return MinioClient
//                .builder()
//                .endpoint(localhost)
//                .credentials(paramsUtils.getAccessKey(), paramsUtils.getSecretKey())
//                .build();
//    }
//}
