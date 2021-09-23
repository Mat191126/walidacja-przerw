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

    public void createExampleData() {
        PresenceConfirmation presenceConfirmation1 = new PresenceConfirmation(2021, 1, 2);
        PresenceConfirmation presenceConfirmation2 = new PresenceConfirmation(2020, 12, 23);
        PresenceConfirmation presenceConfirmation3 = new PresenceConfirmation(2020, 10, 21);
        PresenceConfirmation presenceConfirmation4 = new PresenceConfirmation(2020, 7, 5);
        PresenceConfirmation presenceConfirmation5 = new PresenceConfirmation(2020, 4, 12);

        presenceConfirmationSequence.add(presenceConfirmation1);
        presenceConfirmationSequence.add(presenceConfirmation2);
        presenceConfirmationSequence.add(presenceConfirmation3);
        presenceConfirmationSequence.add(presenceConfirmation4);
        presenceConfirmationSequence.add(presenceConfirmation5);
    }
}
