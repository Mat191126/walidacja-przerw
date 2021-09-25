package com.jobSolutions.model;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;

public class Break {

    // Constant variables symbolizing periods without specified dates from or until
    private final DateTime MIN_DATETIME = DateTime.now().minusYears(2000);
    private final DateTime MAX_DATETIME = DateTime.now().plusYears(2000);

    private Duration paidBreakTime;
    private Duration requiredWorkingTime;
    private DateTime from;
    private DateTime until;

    public Break() {
        this.from = MIN_DATETIME;
        this.until = MAX_DATETIME;
    }

    public Break setPaidBreakTime(int hour, int minute) {
        long minutes = hour * 60L + minute;
        this.paidBreakTime = Duration.standardMinutes(minutes);
        return this;
    }

    public Break setRequiredWorkingTime(int hour, int minute) {
        long minutes = hour * 60L + minute;
        this.requiredWorkingTime = Duration.standardMinutes(minutes);
        return this;
    }

    public Break setFrom(int year, int month, int dayOfMonth) {
        this.from = new DateTime(year, month, dayOfMonth, 0, 0);
        return this;
    }

    public Break setFrom(DateTime from) {
        this.from = from;
        return this;
    }

    public Break setUntil(int year, int month, int dayOfMonth) {
        this.until = new DateTime(year, month, dayOfMonth, 0, 0);
        return this;
    }

    public Break setUntil(DateTime until) {
        this.until = until;
        return this;
    }

    public Duration getPaidBreakTime() {
        return paidBreakTime;
    }

    public Duration getRequiredWorkingTime() {
        return requiredWorkingTime;
    }

    public DateTime getFrom() {
        return from;
    }

    public DateTime getUntil() {
        return until;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Break{paidBreakTime=");
        if (paidBreakTime == null) {
            stringBuilder.append("null");
        } else {
            long hours = paidBreakTime.getStandardMinutes() / 60;
            long minutes = paidBreakTime.getStandardMinutes() % 60;
            if (hours < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(hours)
                    .append(":")
                    .append(minutes);
            if (minutes == 0) {
                stringBuilder.append("0");
            }
        }
        stringBuilder.append(", requiredWorkingHours=");
        if (requiredWorkingTime == null) {
            stringBuilder.append("null");
        } else {
            long hours = requiredWorkingTime.getStandardMinutes() / 60;
            long minutes = requiredWorkingTime.getStandardMinutes() % 60;
            if (hours < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(hours)
                    .append(":")
                    .append(minutes);
            if (minutes == 0) {
                stringBuilder.append("0");
            }
        }
        stringBuilder.append(", from=")
                .append(from.toString(DateTimeFormat.forPattern("dd-MM-yyyy")))
                .append(", until=")
                .append(until.toString(DateTimeFormat.forPattern("dd-MM-yyyy")))
                .append("}");
        return stringBuilder.toString();
    }
}
