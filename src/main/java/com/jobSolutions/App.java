package com.jobSolutions;

import com.jobSolutions.model.BreakSequence;
import com.jobSolutions.model.PresenceConfirmationSequence;

public class App {

    public static void main(String[] args) {
        BreakSequence previousSequence = new BreakSequence();
        previousSequence.createExampleDataForPreviousBreakSequence();

        BreakSequence newSequence = new BreakSequence();
        newSequence.createExampleDataForNewBreakSequence();

        PresenceConfirmationSequence confirmationSequence = new PresenceConfirmationSequence();
        confirmationSequence.createExampleData();

        BreakValidatorService breakValidatorService = new BreakValidatorService();
        boolean isProper = breakValidatorService.changePreviousSequence(previousSequence,
                                                                        newSequence, confirmationSequence);

        if (isProper) {
            System.out.println("New break definition proper");
        } else {
            System.out.println("New break definition incorrect");
        }
    }

}
