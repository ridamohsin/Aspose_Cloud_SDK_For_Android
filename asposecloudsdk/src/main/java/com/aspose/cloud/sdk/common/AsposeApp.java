package com.aspose.cloud.sdk.common;


import java.lang.String;
public class AsposeApp {
    
    public static String APP_SID = "a87ada7a-9a2a-403e-b4be-2db7f33be289";
    public static String APP_KEY = "8581cee5dcf1f68f378ff7b0fa63261d";
    public static String BASE_PRODUCT_URI = "http://api.aspose.com/v1.1";

    public static void setAppKeyAndAppSID(String appKey, String appSID) {
        APP_KEY = appKey;
        APP_SID = appSID;
    }

    public static void setBaseProductURI(String baseProductURI) {
        BASE_PRODUCT_URI = baseProductURI;
    }

}
