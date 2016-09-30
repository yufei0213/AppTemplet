package com.yufei.apptemplet.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
     * String to date
     *
     * @param style
     * @param date
     * @param locale
     * @return
     */
    public static Date strtoDate(String style, String date, Locale locale) {

        SimpleDateFormat formatter = new SimpleDateFormat(style, locale);

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

    /**
     * Date to String
     *
     * @param style
     * @param date
     * @param locale
     * @return
     */
    public static String dateToStr(String style, Date date, Locale locale) {

        SimpleDateFormat formatter = new SimpleDateFormat(style, locale);

        return formatter.format(date);
    }

    /**
     * get the day
     *
     * @param calendar
     * @return
     */
    public static int getDay(Calendar calendar) {

        return calendar.get(Calendar.DATE);
    }

    /**
     * get the day of week
     *
     * @param calendar
     * @param isSimple
     * @return
     */
    public static String getDayOfWeek(Calendar calendar, boolean isSimple) {

        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if (day == 1)
            day = 7;
        else
            day = day - 1;

        switch (day) {

            case 1:
                if (isSimple)
                    return "Mon";
                else
                    return "Monday";
            case 2:
                if (isSimple)
                    return "Tue";
                else
                    return "Tuesday";
            case 3:
                if (isSimple)
                    return "Wed";
                else
                    return "Wednesday";
            case 4:
                if (isSimple)
                    return "Thu";
                else
                    return "Thursday";
            case 5:
                if (isSimple)
                    return "Fri";
                else
                    return "Friday";
            case 6:
                if (isSimple)
                    return "Sat";
                else
                    return "Saturday";
            case 7:
                if (isSimple)
                    return "Sun";
                else
                    return "Sunday";
            default:
                return "";
        }
    }

    /**
     * get month
     *
     * @param calendar
     * @param isSimple
     * @return
     */
    public static String getMonth(Calendar calendar, boolean isSimple) {

        int month = calendar.get(Calendar.MONTH) + 1;

        switch (month) {
            case 1:
                if (isSimple)
                    return "Jan";
                else
                    return "January";
            case 2:
                if (isSimple)
                    return "Feb";
                else
                    return "February";
            case 3:
                if (isSimple)
                    return "Mar";
                else
                    return "March";
            case 4:
                if (isSimple)
                    return "Apr";
                else
                    return "April";
            case 5:
                if (isSimple)
                    return "May";
                else
                    return "May";
            case 6:
                if (isSimple)
                    return "Jun";
                else
                    return "June";
            case 7:
                if (isSimple)
                    return "Jul";
                else
                    return "July";
            case 8:
                if (isSimple)
                    return "Aug";
                else
                    return "August";
            case 9:
                if (isSimple)
                    return "Sep";
                else
                    return "September";
            case 10:
                if (isSimple)
                    return "Oct";
                else
                    return "October";
            case 11:
                if (isSimple)
                    return "Nov";
                else
                    return "November";
            case 12:
                if (isSimple)
                    return "Dec";
                else
                    return "December";
            default:
                return "";
        }
    }
}