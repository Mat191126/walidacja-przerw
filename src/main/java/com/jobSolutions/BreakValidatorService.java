package com.jobSolutions;

import com.jobSolutions.model.BreakSequence;
import com.jobSolutions.model.PresenceConfirmationSequence;

public class BreakValidatorService {

    public boolean changePreviousSequence(BreakSequence previousBreakSequence, BreakSequence newBreakSequence,
                                          PresenceConfirmationSequence confirmationSequence) {
        return checkNewSequence(newBreakSequence, confirmationSequence);
        // TODO: possible additional functionalities
        //  e.g. changing previous break definition to new one if checkNewSequence return true
    }

    private boolean checkNewSequence(BreakSequence newBreakSequence,
                                    PresenceConfirmationSequence confirmationSequence) {
        return true;
    }
}
