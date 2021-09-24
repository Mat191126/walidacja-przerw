package com.jobSolutions.model;

import org.joda.time.Period;

import org.joda.time.LocalDate;

public class Break {

    private Period paidBreakTime;
    private Period requiredWorkingTime;
    private LocalDate from;
    private LocalDate until;

    public Break setPaidBreakTime(int hour, int minute) {
        this.paidBreakTime = new Period(hour, minute, 0, 0);
        return this;
    }

    public Break setRequiredWorkingTime(int hour, int minute) {
        this.requiredWorkingTime = new Period(hour, minute, 0, 0);
        return this;
    }

    public Break setFrom(int year, int month, int dayOfMonth) {
        this.from = new LocalDate(year, month, dayOfMonth);
        return this;
    }

    public Break setUntil(int year, int month, int dayOfMonth) {
        this.until = new LocalDate(year, month, dayOfMonth);
        return this;
    }

    public Period getPaidBreakTime() {
        return paidBreakTime;
    }

    public Period getRequiredWorkingTime() {
        return requiredWorkingTime;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getUntil() {
        return until;
    }
}
