package com.example.app.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DateBucketTest {

    @Test
    @DisplayName("Should get proper date objects between fromDate and toDate")
    public void shouldGetProperDatesInsideInterval() {

        ZoneId zoneId = ZoneId.of("Europe/Paris");

        ZonedDateTime fromDate = ZonedDateTime.of(2021, Month.FEBRUARY.getValue(), 7, 12, 00, 00, 1234, zoneId);
        ZonedDateTime toDate = ZonedDateTime.of(2021, Month.FEBRUARY.getValue(), 12, 12, 00, 00, 1234, zoneId);

        final List<DateBucket> bucketList = DateBucket.bucketize(fromDate, toDate, 1, ChronoUnit.DAYS);
        assertNotNull(bucketList);
        assertThat(bucketList.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("Should get proper date objects between fromDate and toDate - V2")
    public void shouldGetProperDatesInsideIntervalV2() {

        ZoneId zoneId = ZoneId.of("Europe/Paris");

        ZonedDateTime fromDate = ZonedDateTime.of(2021, Month.FEBRUARY.getValue(), 7, 12, 00, 00, 1234, zoneId);
        ZonedDateTime toDate = ZonedDateTime.of(2021, Month.FEBRUARY.getValue(), 12, 12, 00, 00, 1234, zoneId);

        final List<DateBucket> bucketList = DateBucket.bucketizeV2(fromDate, toDate, 1, ChronoUnit.DAYS);
        assertNotNull(bucketList);
        assertThat(bucketList.size()).isEqualTo(6);
    }


}