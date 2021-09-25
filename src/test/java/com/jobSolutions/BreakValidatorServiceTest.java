package com.jobSolutions;

import com.jobSolutions.model.BreakSequence;
import com.jobSolutions.model.PresenceConfirmationSequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreakValidatorServiceTest {

    @Test
    void checkIfBreakPeriodsOverlaps_ReturnTrue_WhenPeriodsOverlap() {
        //Arrange
        BreakValidatorService breakValidatorService = new BreakValidatorService();
        BreakSequence breakSequence = new BreakSequence();
        breakSequence.createExampleOverlappingDataForNewBreakSequence();
        //Act
        boolean actual = breakValidatorService.checkIfBreakPeriodsOverlaps(breakSequence);
        //Assert
        assertTrue(actual, "Method should return true");
    }

    @Test
    void checkIfBreakPeriodsOverlaps_ReturnFalse_WhenPeriodsNotOverlap() {
        //Arrange
        BreakValidatorService breakValidatorService = new BreakValidatorService();
        BreakSequence breakSequence = new BreakSequence();
        breakSequence.createExampleDataForNewBreakSequence();
        //Act
        boolean actual = breakValidatorService.checkIfBreakPeriodsOverlaps(breakSequence);
        //Assert
        assertFalse(actual, "Method should return false");
    }

    @Test
    void checkIfRequiredWorkingTimeEnough_ReturnFalse_WhenRequiredWorkingTimeNotEnough() {
        //Arrange
        BreakValidatorService breakValidatorService = new BreakValidatorService();
        BreakSequence breakSequence = new BreakSequence();
        breakSequence.createExampleDataForNewBreakSequence();
        //Act
        boolean actual = breakValidatorService.checkIfRequiredWorkingTimeEnough(breakSequence);
        //Assert
        assertFalse(actual, "Method should return false");
    }

    @Test
    void checkIfRequiredWorkingTimeEnough_ReturnTrue_WhenRequiredWorkingTimeEnough() {
        //Arrange
        BreakValidatorService breakValidatorService = new BreakValidatorService();
        BreakSequence breakSequence = new BreakSequence();
        breakSequence.createExampleDataForNewBreakSequenceWithEnoughWorkingHours();
        //Act
        boolean actual = breakValidatorService.checkIfRequiredWorkingTimeEnough(breakSequence);
        //Assert
        assertTrue(actual, "Method should return true");
    }

    @Test
    void checkIfPresenceConfirmationCollideBreakPeriod_ReturnFalse_WhenPresenceConfirmationNotCollideBreakPeriod() {
        //Arrange
        BreakValidatorService breakValidatorService = new BreakValidatorService();
        BreakSequence breakSequence = new BreakSequence();
        breakSequence.createExampleDataForNewBreakSequence();
        PresenceConfirmationSequence presenceSequence = new PresenceConfirmationSequence();
        presenceSequence.createExampleNotCollidingData();
        //Act
        boolean actual = breakValidatorService.checkIfPresenceConfirmationCollideBreakPeriod(breakSequence,
                                                                                             presenceSequence);
        //Assert
        assertFalse(actual, "Method should return false");
    }

    @Test
    void checkIfPresenceConfirmationCollideBreakPeriod_ReturnTrue_WhenPresenceConfirmationCollideBreakPeriod() {
        //Arrange
        BreakValidatorService breakValidatorService = new BreakValidatorService();
        BreakSequence breakSequence = new BreakSequence();
        breakSequence.createExampleDataForNewBreakSequence();
        PresenceConfirmationSequence presenceSequence = new PresenceConfirmationSequence();
        presenceSequence.createExampleData();
        //Act
        boolean actual = breakValidatorService.checkIfPresenceConfirmationCollideBreakPeriod(breakSequence,
                                                                                             presenceSequence);
        //Assert
        assertTrue(actual, "Method should return false");
    }

}