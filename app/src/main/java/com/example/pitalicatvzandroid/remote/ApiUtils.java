package com.example.pitalicatvzandroid.remote;

/**
 * Created by Ivan on 2/12/2018.
 */

public class ApiUtils {

    private ApiUtils() {}

    //public static final String BASE_URL = "http://94.253.242.123:80/";//global
    public static final String BASE_URL = "http://88.207.32.218:80/";//local

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}