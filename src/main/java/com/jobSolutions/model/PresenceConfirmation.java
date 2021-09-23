package com.jobSolutions.model;

import java.time.LocalDate;

public class PresenceConfirmation {

    private final LocalDate date;

    public PresenceConfirmation(int year, int month, int dayOfMonth) {
        this.date = LocalDate.of(year, month, dayOfMonth);
    }

    public LocalDate getDate() {
        return date;
    }
}
