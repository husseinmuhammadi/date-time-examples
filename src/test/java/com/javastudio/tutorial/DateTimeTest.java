package com.javastudio.tutorial;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.DateUtil.parse;

class DateTimeTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeTest.class);

    @Test
    void whenConvertLocalDate2Date_thenTheyShouldBeEqual() {
        // LocalDate -> Date
        LocalDate localDate = LocalDate.of(2020, 2, 20);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        assertThat(date).isEqualTo(parse("2020-2-20")).isEqualTo("2020-2-20");

        // LocalDateTime -> Date
        LocalDateTime localDateTime = LocalDateTime.of(2020, 2, 20, 21, 46, 31);
        Date date2 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        // ZonedDateTime -> Date
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        Date date3 = Date.from(zonedDateTime.toInstant());
    }
}