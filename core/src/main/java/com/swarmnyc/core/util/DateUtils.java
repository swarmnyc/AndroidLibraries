package com.swarmnyc.core.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    private static DateFormat iso8601Format;
    private static DateFormat fileFormat;

    public static String isoFormat(Date date) {
        if (iso8601Format == null) {
            iso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
        }

        return iso8601Format.format(date);
    }

    public static String fileFormat(Date date) {
        if (fileFormat == null) {
            fileFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);
        }

        return fileFormat.format(date);
    }

    public static String format(Date date, String patten) {
        DateFormat dateFormat = new SimpleDateFormat(patten, Locale.US);
        return dateFormat.format(date);
    }
}
