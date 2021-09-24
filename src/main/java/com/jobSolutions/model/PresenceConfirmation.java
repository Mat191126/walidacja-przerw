package com.jobSolutions.model;

import org.joda.time.DateTime;

public class PresenceConfirmation {

    private final DateTime date;

    public PresenceConfirmation(int year, int month, int dayOfMonth) {
        this.date = new DateTime(year, month, dayOfMonth, 0, 0);
    }

    public DateTime getDate() {
        return date;
    }
}
