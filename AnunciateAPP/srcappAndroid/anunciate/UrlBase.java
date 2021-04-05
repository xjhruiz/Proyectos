package com.example.jhonatan.anunciate;

import android.app.Application;

/**
 * Created by Jhonatan on 11/06/2018.
 */

public class UrlBase extends Application {
    public static final String urlBase ="http://192.168.1.122:8080/Anunciate/";

    public static String getUrlBase() {
        return urlBase;
    }
}
