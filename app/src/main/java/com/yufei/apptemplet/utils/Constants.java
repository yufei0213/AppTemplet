package com.yufei.apptemplet.utils;

/**
 * Created by wangyufei on 16/9/3.
 *
 */
public class Constants {

    /**
     * cannot be instantiated
     */
    private Constants() {

        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 开发的时候设置为true，发布的时候设置为false
     */
    public final static boolean isDebugModel = false;

    /**
     * api root
     */
    public final static String API_URL_ROOT = "http://track.ubt.io/api/";

    /**
     * api version
     */
    public final static String API_VERSION = "v1";

    /**
     * api url
     */
    public final static String API_URL_BASE = API_URL_ROOT + API_VERSION + "/";

    /**
     * login url
     */
    public final static String API_URL_LOGIN = API_URL_BASE + "account/login";

    /**
     * logout url
     */
    public final static String API_URL_LOGOUT = API_URL_BASE + "account/logout";
}
