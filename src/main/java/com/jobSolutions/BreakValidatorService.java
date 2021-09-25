package com.jobSolutions;

import com.jobSolutions.model.*;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;

public class BreakValidatorService {
    // Constant variable for temporary toggle working time check
    private final boolean IS_WORKING_TIME_CHECKED = false;

    public boolean changePreviousSequence(BreakSequence previousBreakSequence, BreakSequence newBreakSequence,
                                          PresenceConfirmationSequence confirmationSequence) {
        return checkNewSequence(newBreakSequence, confirmationSequence);
        // TODO: possible additional functionalities
        //  e.g. changing previous break definition to new one if checkNewSequence return true
    }

    private boolean checkNewSequence(BreakSequence newBreakSequence,
                                    PresenceConfirmationSequence confirmationSequence) {
        StringBuilder info = new StringBuilder();
        info.append("--------- New break definition info -----------\n");

        // Check break periods overlapping
        boolean isPeriodOverlap = checkIfBreakPeriodsOverlaps(newBreakSequence);
        info.append("Periods overlaps: ")
                .append(isPeriodOverlap)
                .append("\n");

        //Optionally check if required working time is at least 6h
        boolean isRequiredWorkingTimeEnough = true;
        if (IS_WORKING_TIME_CHECKED) {
            isRequiredWorkingTimeEnough = checkIfRequiredWorkingTimeEnough(newBreakSequence);
            info.append("Is required working time enough: ")
                    .append(isRequiredWorkingTimeEnough)
                    .append("\n");
        }
        info.append("Is required working time enough: not required\n");

        // Check if there is no presence confirmation set during the new break definition period
        boolean hasPresenceConfirmation = checkIfPresenceConfirmationCollideBreakPeriod(newBreakSequence,
                                                                                        confirmationSequence);
        info.append("Break have presence confirmation: ")
                .append(hasPresenceConfirmation)
                .append("\n")
                .append("-----------------------------------------------");

        System.out.println(info.toString());
        return !isPeriodOverlap && isRequiredWorkingTimeEnough && !hasPresenceConfirmation;
    }

    public boolean checkIfBreakPeriodsOverlaps(BreakSequence newBreakSequence) {
        for (Break singleBreak : newBreakSequence.getBreakSequence()) {
            Interval singleBreakInterval = new Interval(singleBreak.getFrom(), singleBreak.getUntil());
//            System.out.println(singleBreak.toString());
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
