package com.jobSolutions.model;

import java.util.ArrayList;
import java.util.List;

public class PresenceConfirmationSequence {
    private final List<PresenceConfirmation> presenceConfirmationSequence;

    public PresenceConfirmationSequence() {
        this.presenceConfirmationSequence = new ArrayList<>();
    }

    public List<PresenceConfirmation> getPresenceConfirmationSequence() {
        return presenceConfirmationSequence;
    }
}
