package com.multimotors.utils;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;

/**
 * @author Fabian
 * @author Sergio
 */
public class ApiRequests {
    
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client;

    public ApiRequests(){
        client = new OkHttpClient();
    }

    public String getRequest(String url) throws IOException {
        Request request= new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public String postRequest(String url, String json) throws IOException{
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }
    
    public String deleteRequest(String url) throws IOException{
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }
    
    public String putRequest(String url, String json) throws IOException{
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public String postRequestWithParams(String url, String json) throws IOException {
        RequestBody formBody = new FormEncodingBuilder()
                .add("json", json)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }
}