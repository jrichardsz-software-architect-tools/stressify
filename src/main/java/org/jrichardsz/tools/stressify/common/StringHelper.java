package org.jrichardsz.tools.stressify.common;

import java.net.URL;

public class StringHelper {
  public static String sanitizeUrlToFileLocation(String url) throws Exception {
    return url.replaceAll("http://", "").replaceAll("/", "_").replaceAll(":", "_");
  }
  public static String sanitizeEndpoint(String url) throws Exception {
    return url.replaceAll("/", "_");
  }
  public static String getEndpoint(String stringUrl) throws Exception {
    URL url = new URL(stringUrl);        
    return stringUrl.substring(stringUrl.indexOf(url.getPath()));
  }  
}
