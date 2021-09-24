package com.jobSolutions.model;


import org.joda.time.LocalDate;

public class PresenceConfirmation {

    private final LocalDate date;

    public PresenceConfirmation(int year, int month, int dayOfMonth) {
        this.date = new LocalDate(year, month, dayOfMonth);
    }

    public LocalDate getDate() {
        return date;
    }
}
