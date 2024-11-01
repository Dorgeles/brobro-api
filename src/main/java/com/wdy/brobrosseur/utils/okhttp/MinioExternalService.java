package com.wdy.brobrosseur.utils.okhttp;

import com.google.gson.JsonArray;
import com.wdy.brobrosseur.utils.ParamsUtils;
import com.wdy.brobrosseur.utils.dto.ImagesPrestationDto;
import com.wdy.brobrosseur.utils.dto.RecordImageDto;
import com.wdy.brobrosseur.utils.okhttp.base.OkHttpClientUtilsBase;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;


@Component
public class MinioExternalService extends OkHttpClientUtilsBase {
    @Autowired
    private ParamsUtils paramUtils;


    public String saveImage(RecordImageDto recordImageDto) throws Exception {
        try {
            Map<String, Object> data = new HashMap<>();
            Map<String, Object> req = new HashMap<>();
            data.put("file", recordImageDto.getFileBase64());
            data.put("filename", recordImageDto.getFileName());
            data.put("bucket_name", paramUtils.getMinioBucketName());
            data.put("subdirectory_name", recordImageDto.getPathName());
            req.put("data", data);
            final String request = new Gson().toJson(data);
            okhttp3.Response apiResponse = post(paramUtils.getMinioUrl(), request, "json");
            Map<String, Object> respMap = toResponseAsMap(apiResponse);
            JSONObject json = new JSONObject(respMap);
            if (json.has("items")) {
                JSONArray items = json.getJSONArray("items");
                if (items != null && items.length() > 0) {
                    return items.get(0).toString();
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return  null;
    }

    public String saveImage(ImagesPrestationDto recordImageDto) throws Exception {
        try {
            Map<String, Object> data = new HashMap<>();
            Map<String, Object> req = new HashMap<>();
            data.put("file", recordImageDto.getFileBase64());
            data.put("filename", recordImageDto.getFileName());
            data.put("bucket_name", paramUtils.getMinioBucketName());
            data.put("subdirectory_name", recordImageDto.getPathName());
            req.put("data", data);
            final String request = new Gson().toJson(data);
            okhttp3.Response apiResponse = post(paramUtils.getMinioUrl() + "/minio-api/uploadFileFromBase64", request, "json");
            Map<String, Object> respMap = toResponseAsMap(apiResponse);
            JSONObject json = new JSONObject(respMap);
            if (json.has("items")) {
                JSONArray items = json.getJSONArray("items");
                if (items != null && items.length() > 0) {
                    return items.get(0).toString();
                }
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return  null;
    }


}
