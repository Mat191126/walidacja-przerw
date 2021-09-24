package com.jobSolutions.model;

import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

class BreakTest {

    @Test
    void constructor_ReturnBreakWithFilledFromField_WhenFromSetterNotUsed() {
        //Arrange
        Break expected = new Break();
        expected.setPaidBreakTime(0, 15)
                .setRequiredWorkingTime(7, 0)
                .setFrom(DateTime.now().minusYears(2000))
                .setUntil(2020, 5, 12);
        //Act
        Break actual = new Break();
        actual.setPaidBreakTime(0, 15)
                .setRequiredWorkingTime(7, 0)
                .setUntil(2020, 5, 12);
        //Assert
        assertAll(
                () -> assertEquals(expected.getPaidBreakTime(), actual.getPaidBreakTime()
                                    , "Break object fields are different"),
                () -> assertEquals(expected.getRequiredWorkingTime(), actual.getRequiredWorkingTime()
                                    , "Break object fields are different"),
                () -> assertEquals(expected.getUntil(), actual.getUntil(), "Break object fields are different"),
                () -> assertNotEquals(null, actual.getFrom(), "From field can't be null"),
                () -> assertNotEquals(null, actual.getUntil(), "Until field can't be null")
        );
    }

    @Test
    void constructor_ReturnBreakWithFilledUntilField_WhenUntilSetterNotUsed() {
        //Arrange
        Break expected = new Break();
        expected.setPaidBreakTime(0, 15)
                .setRequiredWorkingTime(7, 0)
                .setFrom(2020, 11, 5)
                .setUntil(DateTime.now().plusYears(2000));
        //Act
        Break actual = new Break();
        actual.setPaidBreakTime(0, 15)
                .setRequiredWorkingTime(7, 0)
                .setFrom(2020, 11, 5);
        //Assert
        assertAll(
                () -> assertEquals(expected.getPaidBreakTime(), actual.getPaidBreakTime()
                                    , "Break object fields are different"),
                () -> assertEquals(expected.getRequiredWorkingTime(), actual.getRequiredWorkingTime()
                                    , "Break object fields are different"),
                () -> assertEquals(expected.getFrom(), actual.getFrom(), "Break object fields are different"),
                () -> assertNotEquals(null, actual.getFrom(), "From field can't be null"),
                () -> assertNotEquals(null, actual.getUntil(), "Until field can't be null")
        );
    }
}