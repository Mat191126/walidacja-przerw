package com.jobSolutions;

import com.jobSolutions.model.BreakSequence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreakValidatorServiceTest {

    @Test
    void checkIfBreakPeriodsOverlaps_ReturnTrue_WhenPeriodsOverlap() {
        //Arrange
        BreakValidatorService breakValidatorService = new BreakValidatorService();
        BreakSequence breakSequence = new BreakSequence();
        breakSequence.createExampleOverlapingDataForNewBreakSequence();
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

}