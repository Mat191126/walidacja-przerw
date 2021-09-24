package com.jobSolutions.model;

import org.joda.time.DateTime;
import org.joda.time.Period;

public class Break {

    // Constant variables symbolizing periods without specified dates from or until
    private final DateTime MIN_DATETIME = DateTime.now().minusYears(2000);
    private final DateTime MAX_DATETIME = DateTime.now().plusYears(2000);

    private Period paidBreakTime;
    private Period requiredWorkingTime;
    private DateTime from;
    private DateTime until;

    public Break() {
        this.from = MIN_DATETIME;
        this.until = MAX_DATETIME;
    }

    public Break setPaidBreakTime(int hour, int minute) {
        this.paidBreakTime = new Period(hour, minute, 0, 0);
        return this;
    }

    public Break setRequiredWorkingTime(int hour, int minute) {
        this.requiredWorkingTime = new Period(hour, minute, 0, 0);
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

    public Period getPaidBreakTime() {
        return paidBreakTime;
    }

    public Period getRequiredWorkingTime() {
        return requiredWorkingTime;
    }

    public DateTime getFrom() {
        return from;
    }

    public DateTime getUntil() {
        return until;
    }
}
