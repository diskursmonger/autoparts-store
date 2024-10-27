package ru.nsu.ccfit.kozlova.autoparts.app.utils;

import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

@UtilityClass
public class LocalDateFormatter {

    private static final String dateFormat = "dd-MM-yyyy";
    private static final String dateTimeFormat = "dd-MM-yyyy HH:mm";

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
    private static final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat(dateTimeFormat);
    private static final DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern(dateFormat);
    private static final DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);

    public static String getFormattedDate(Date date) {
        return dateFormatter.format(date);
    }

    public static String getFormattedDate(LocalDate date) {
        return date.format(localDateFormatter);
    }

    public static String getFormattedDate(long timeMillis) {
        return dateFormatter.format(new Date(timeMillis));
    }

    public static String getFormattedDateTime(Date timestamp) {
        return dateTimeFormatter.format(timestamp);
    }

    public static String getFormattedDateTime(LocalDateTime dateTime) {
        return dateTime.format(localDateTimeFormatter);
    }

    public static String getFormattedDateTime(long timeMillis) {
        return dateTimeFormatter.format(new Date(timeMillis));
    }

    public static Date parseDate(String date) throws ParseException {
        return dateFormatter.parse(date);
    }

    public static Date parseDateTime(String dateTime) throws ParseException {
        return dateFormatter.parse(dateTime);
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public String getDateTimeFormat() {
        return dateTimeFormat;
    }

}
