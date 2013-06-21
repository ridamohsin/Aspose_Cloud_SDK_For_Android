package com.aspose.cloud.sdk.common;


import java.lang.String;
public class AsposeApp {
    /// <summary>
    /// Represents AppSID for the app.
    /// </summary>
    private static String appSID;
    /// <summary>
    /// Represnts the AppKey for the app.
    /// </summary>
    private static String appKey;
    
    public static String getAppSID(){return appSID;}
    public static String getAppKey(){return appKey;}
    public static void setAppSID(String app_SID){ appSID=app_SID;}
    public static void setAppKey(String app_Key){ appKey=app_Key;}
    public static void setAppInfo(String app_Key, String app_SID)
    {
    	appSID=app_SID;
    	appKey=app_Key;
    }

}
