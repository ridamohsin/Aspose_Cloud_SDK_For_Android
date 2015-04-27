package com.aspose.cloud.sdk.common;


import java.lang.String;
public class AsposeApp {
    
    public static String APP_SID = "b01a15e5-1b83-4b9a-8eb3-0f2bfa6ac766";
    public static String APP_KEY = "da77c9f5da014d91faf2961ecec2de66";
    public static String BASE_PRODUCT_URI = "http://api.aspose.com/v1.1";

    public static void setAppKeyAndAppSID(String appKey, String appSID) {
        APP_KEY = appKey;
        APP_SID = appSID;
    }

    public static void setBaseProductURI(String baseProductURI) {
        BASE_PRODUCT_URI = baseProductURI;
    }

}
