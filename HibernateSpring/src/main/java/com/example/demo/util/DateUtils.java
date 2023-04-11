package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");

    public static Date parseDate(String dateString) throws ParseException {
        return formatter.parse(dateString);
    }

    public static String formatDate(Date theDate) {
        String result = null;

        if (theDate != null) {
            result = formatter.format(theDate);
        }

        return result;
    }
}
