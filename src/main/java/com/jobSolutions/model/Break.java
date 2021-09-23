package com.jobSolutions.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Break {

    private LocalTime paidBreakTime;
    private LocalTime requiredWorkingTime;
    private LocalDate from;
    private LocalDate until;

    public Break setPaidBreakTime(int hour, int minute) {
        this.paidBreakTime = LocalTime.of(hour, minute);
        return this;
    }

    public Break setRequiredWorkingTime(int hour, int minute) {
        this.requiredWorkingTime = LocalTime.of(hour, minute);
        return this;
    }

    public Break setFrom(int year, int month, int dayOfMonth) {
        this.from = LocalDate.of(year, month, dayOfMonth);
        return this;
    }

    public Break setUntil(int year, int month, int dayOfMonth) {
        this.until = LocalDate.of(year, month, dayOfMonth);
        return this;
    }

    public LocalTime getPaidBreakTime() {
        return paidBreakTime;
    }

    public LocalTime getRequiredWorkingTime() {
        return requiredWorkingTime;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getUntil() {
        return until;
    }
}
