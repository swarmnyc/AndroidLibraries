package com.swarmnyc.core.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {
    private static final int MILLISECONDS_PER_SECOND = 1000;
    private static final int MILLISECONDS_PER_MINUTE = 60 * MILLISECONDS_PER_SECOND;
    private static final int MILLISECONDS_PER_HOUR = 60 * MILLISECONDS_PER_MINUTE;
    private static final int MILLISECONDS_PER_DAY = 24 * MILLISECONDS_PER_HOUR;

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

    public static long toMillisecond(int days, int hours, int mins, int seconds) {
        return (days * MILLISECONDS_PER_DAY +
                hours * MILLISECONDS_PER_HOUR +
                mins * MILLISECONDS_PER_MINUTE +
                seconds * MILLISECONDS_PER_SECOND);
    }

    public static String msToString(long ms) {
        StringBuilder stringBuilder = new StringBuilder();
        if (ms >= MILLISECONDS_PER_DAY) {
            long days = ms / MILLISECONDS_PER_DAY;
            ms -= days * MILLISECONDS_PER_DAY;
            stringBuilder.append(days);
            if (days == 1) {
                stringBuilder.append(" day");
            } else {
                stringBuilder.append(" days");
            }
        }

        if (ms >= MILLISECONDS_PER_HOUR) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }

            long hours = ms / MILLISECONDS_PER_HOUR;
            ms -= hours * MILLISECONDS_PER_HOUR;

            stringBuilder.append(hours);
            if (hours == 1) {
                stringBuilder.append(" hour");
            } else {
                stringBuilder.append(" hours");
            }
        }

        if (ms >= MILLISECONDS_PER_MINUTE) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }

            long mins = ms / MILLISECONDS_PER_MINUTE;
            ms -= mins * MILLISECONDS_PER_MINUTE;
            stringBuilder.append(mins);
            if (mins == 1) {
                stringBuilder.append(" min");
            } else {
                stringBuilder.append(" mins");
            }
        }

        if (ms >= MILLISECONDS_PER_SECOND) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }

            long secs = ms / MILLISECONDS_PER_SECOND;
            stringBuilder.append(secs);
            if (secs == 1) {
                stringBuilder.append(" sec");
            } else {
                stringBuilder.append(" secs");
            }
        }

        if (stringBuilder.length() == 0) {
            stringBuilder.append("Less than a second");
        }

        return stringBuilder.toString();
    }
}
