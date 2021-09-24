package com.jobSolutions.model;

import static org.junit.jupiter.api.Assertions.*;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

class BreakTest {

    @Test
    void constructor_ReturnBreakWithFilledFromAndUntilFields_WhenSettersNotUsed() {
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
                () -> assertEquals(expected.getPaidBreakTime(), actual.getPaidBreakTime()),
                () -> assertEquals(expected.getRequiredWorkingTime(), actual.getRequiredWorkingTime()),
                () -> assertEquals(expected.getFrom(), actual.getFrom()),
                () -> assertEquals(expected.getUntil(), actual.getUntil())
        );
    }
}