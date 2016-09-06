package com.yufei.apptemplet.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wangyufei on 16/9/5.
 */
public class DateUtil {

    /**
     * cannot be instantiated
     */
    private DateUtil() {

        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * String to date
     *
     * @param style
     * @param date
     * @return
     */
    public static Date strToDate(String style, String date) {

        SimpleDateFormat formatter = new SimpleDateFormat(style, Locale.ENGLISH);

        try {

            return formatter.parse(date);
        } catch (ParseException e) {

            e.printStackTrace();

            return new Date();
        }
    }

    /**
     * Date to String
     *
     * @param style
     * @param date
     * @return
     */
    public static String dateToStr(String style, Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat(style, Locale.ENGLISH);

        return formatter.format(date);
    }

}
