package com.jobSolutions.model;

import java.util.Date;

public class PresenceConfirmation {

    private final Date date;

    public PresenceConfirmation(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
