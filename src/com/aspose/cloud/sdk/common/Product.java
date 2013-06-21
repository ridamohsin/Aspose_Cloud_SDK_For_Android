package com.aspose.cloud.sdk.common;

import java.lang.String;
public class Product {
    /// <summary>
    /// this property represents the base product uri i.e. http://api.aspose.com/v1.1
    /// you can set this property according to the current version you're using
    /// </summary>
    private static String baseProductUri;
    
    public static String getBaseProductUri(){return baseProductUri;}
    
    public static void setBaseProductUri(String temBaseProductUri){ baseProductUri=temBaseProductUri;}
    
}
