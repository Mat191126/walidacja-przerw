package com.jobSolutions;

import com.jobSolutions.model.Break;
import com.jobSolutions.model.BreakSequence;
import com.jobSolutions.model.PresenceConfirmationSequence;
import org.joda.time.Interval;

public class BreakValidatorService {

    public boolean changePreviousSequence(BreakSequence previousBreakSequence, BreakSequence newBreakSequence,
                                          PresenceConfirmationSequence confirmationSequence) {
        return checkNewSequence(newBreakSequence, confirmationSequence);
        // TODO: possible additional functionalities
        //  e.g. changing previous break definition to new one if checkNewSequence return true
    }

    private boolean checkNewSequence(BreakSequence newBreakSequence,
                                    PresenceConfirmationSequence confirmationSequence) {
        System.out.println("Periods overlaps: " + checkIfBreakPeriodsOverlaps(newBreakSequence));
        return true;
    }

    private boolean checkIfBreakPeriodsOverlaps(BreakSequence newBreakSequence) {
        for (Break singleBreak : newBreakSequence.getBreakSequence()) {
            Interval singleBreakInterval = new Interval(singleBreak.getFrom(), singleBreak.getUntil());
            for (Break singleBreakToCompare :  newBreakSequence.getBreakSequence()) {
                if (!singleBreak.equals(singleBreakToCompare)) {
                    Interval singleBreakToCompareInterval = new Interval(singleBreakToCompare.getFrom(),
                                                                         singleBreakToCompare.getUntil());
                    if (singleBreakInterval.overlaps(singleBreakToCompareInterval)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
