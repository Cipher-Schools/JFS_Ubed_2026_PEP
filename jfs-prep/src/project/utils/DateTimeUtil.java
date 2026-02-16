package project.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-mm-dd");

    private static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss.SSS");

    public static String getDate() {
        return LocalDateTime.now().format(DATE_FORMAT);
    };

    public static String getDateTime() {
        return LocalDateTime.now().format(DATETIME_FORMAT);
    }
}
