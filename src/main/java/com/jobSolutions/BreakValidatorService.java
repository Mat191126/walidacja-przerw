package com.jobSolutions;

import com.jobSolutions.model.Break;
import com.jobSolutions.model.BreakSequence;
import com.jobSolutions.model.PresenceConfirmation;
import com.jobSolutions.model.PresenceConfirmationSequence;
import org.joda.time.DateTime;
import org.joda.time.Duration;
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
        boolean isPeriodOverlap = checkIfBreakPeriodsOverlaps(newBreakSequence);
        boolean isRequiredWorkingTimeEnough = checkIfRequiredWorkingTimeEnough(newBreakSequence);
        boolean hasPresenceConfirmation = checkIfPresenceConfirmationCollideBreakPeriod(newBreakSequence,
                                                                                        confirmationSequence);
        System.out.println("---------info-----------");
        System.out.println("Periods overlaps: " + isPeriodOverlap);
        System.out.println("Is required working time enough: " + isRequiredWorkingTimeEnough);
        System.out.println("Break have presence confirmation: " + hasPresenceConfirmation);
        return true;
    }

    public boolean checkIfBreakPeriodsOverlaps(BreakSequence newBreakSequence) {
        for (Break singleBreak : newBreakSequence.getBreakSequence()) {
            Interval singleBreakInterval = new Interval(singleBreak.getFrom(), singleBreak.getUntil());
            System.out.println(singleBreak.toString());
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

    public boolean checkIfRequiredWorkingTimeEnough(BreakSequence newBreakSequence) {
        for (Break singleBreak :  newBreakSequence.getBreakSequence()) {
            if (singleBreak.getRequiredWorkingTime().isShorterThan(Duration.standardHours(6))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfPresenceConfirmationCollideBreakPeriod(BreakSequence newBreakSequence,
                                                                 PresenceConfirmationSequence presenceSequence) {
        for (Break singleBreak : newBreakSequence.getBreakSequence()) {
            Interval singleBreakInterval = new Interval(singleBreak.getFrom(), singleBreak.getUntil());
            for (PresenceConfirmation presenceConfirmation :  presenceSequence.getPresenceConfirmationSequence()) {
                DateTime presenceDate = presenceConfirmation.getDate();
                System.out.println(presenceConfirmation.toString());
                if (singleBreakInterval.contains(presenceDate)) {
                    return true;
                }
            }
        }
        return false;
    }
}
