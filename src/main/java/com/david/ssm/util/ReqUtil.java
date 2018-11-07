package com.david.ssm.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class ReqUtil {
    public ReqUtil() {
    }

    public static Map<String, String[]> getReqKeyVals(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        if (params == null) {
            Enumeration keys = request.getParameterNames();

            while(keys != null && keys.hasMoreElements()) {
                if (params == null) {
                    params = new HashMap();
                }

                String keyName = (String)keys.nextElement();
                String[] val = request.getParameterValues(keyName);
                ((Map)params).put(keyName, val);
            }
        }

        return (Map)params;
    }

    public static Map<String, String> getReqKeyVals(HttpServletRequest request, String[] names) {
        Map<String, String> params = new HashMap();
        int i = 0;

        for(int len = names.length; i < len; ++i) {
            String v = request.getParameter(names[i]);
            params.put(names[i], v);
        }

        return params;
    }

    public static String getRemoteIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }
}
