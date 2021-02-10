package com.example.app.utils;

import lombok.Data;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class DateBucket {

    final Instant from;
    final Instant to;

    public static List<DateBucket> bucketize(ZonedDateTime fromDate,
                                             ZonedDateTime toDate,
                                             int bucketSize,
                                             ChronoUnit bucketSizeUnit) {
        List<DateBucket> buckets = new ArrayList<>();
        boolean reachedDate = false;

        for (int i = 0; !reachedDate; i++) {
            ZonedDateTime minDate = fromDate.plus(i * bucketSize, bucketSizeUnit);
            ZonedDateTime maxDate = fromDate.plus((i + 1) * bucketSize, bucketSizeUnit);
            reachedDate = toDate.isBefore(maxDate);
            buckets.add(new DateBucket(minDate.toInstant(), maxDate.toInstant()));
        }

        return buckets;
    }

    public static List<DateBucket> bucketizeV2(ZonedDateTime fromDate,
                                               ZonedDateTime toDate,
                                               int bucketSize,
                                               ChronoUnit days) {

        return Stream.iterate(fromDate, date -> date.plusDays(bucketSize))
                .limit(days.between(fromDate, toDate.plus(1, days)))
                .map(d -> new DateBucket(d.toInstant(), d.plus(1, days).toInstant()))
                .collect(Collectors.toList());
    }
}
