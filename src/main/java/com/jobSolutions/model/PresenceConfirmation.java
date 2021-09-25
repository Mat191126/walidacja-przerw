package com.jobSolutions.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class PresenceConfirmation {

    private final DateTime date;

    public PresenceConfirmation(int year, int month, int dayOfMonth) {
        this.date = new DateTime(year, month, dayOfMonth, 0, 0);
    }

    public DateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "PresenceConfirmation{" +
                "date=" + date.toString(DateTimeFormat.forPattern("dd-MM-yyyy")) +
                '}';
    }
}
