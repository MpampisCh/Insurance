package com.teamone.app;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateDiffInDays {

    long checkDateDiff(Date endDate){
        long dateDiff;
        LocalDate expirationDay = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();
        dateDiff = DAYS.between(now, expirationDay);
        return (dateDiff);
    }
}
