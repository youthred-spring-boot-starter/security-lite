package io.github.youthredspringbootstarter.securitylite.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Jackson ObjectMapper Wrap
 */
public class OM {

    private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String TIME_PATTERN = "HH:mm:ss";

    public static final ObjectMapper OM = new ObjectMapper()
            .setLocale(Locale.CHINA)
            .setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()))
            .registerModule(
                    new JavaTimeModule()
                            .addSerializer(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_PATTERN)))
                            .addSerializer(new LocalDateSerializer(DateTimeFormatter.ofPattern(DATE_PATTERN)))
                            .addSerializer(new LocalTimeSerializer(DateTimeFormatter.ofPattern(TIME_PATTERN)))
                            .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DATETIME_PATTERN)))
                            .addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(DATE_PATTERN)))
                            .addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(TIME_PATTERN)))
            )
            .setDateFormat(new SimpleDateFormat(DATETIME_PATTERN))
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .findAndRegisterModules();
}
