package com.pratamawijaya.blog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import timber.log.Timber;

/**
 * Created by Pratama Nur Wijaya
 * Date : Dec - 12/10/16
 * Project Name : PratamaBlog
 */

public class DateUtils {
  public static final String FORMAT_DATE_1 = "EEE, d MMM yyyy";
  public static final String FORMAT_DATE_2 = "d MMM yyyy";
  public static final String FORMAT_DATE_3 = "d/MMM/yyyy";
  public static final String FORMAT_DATE_SERVER = "yyyy-MM-dd";

  /**
   * transform Date to String
   */
  public static String formatDate(Date date, String format) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    return dateFormat.format(date);
  }

  /**
   * transform string to Date
   *
   * @throws ParseException
   */
  public static Date formatStringToDate(String date, String format) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    return dateFormat.parse(date);
  }

  /**
   * addition days
   */
  public static Date plusDays(Date startDate, int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);
    calendar.add(Calendar.DATE, day);
    return calendar.getTime();
  }

  /**
   * get days between two date
   */
  public static long dayBetween(Date starDate, Date endDate) {
    final long day = (endDate.getTime() - starDate.getTime()) / (24 * 60 * 60 * 1000);
    Timber.d("dayBetween() :  %s - %s = %s", starDate, endDate, day);
    return day;
  }
}
