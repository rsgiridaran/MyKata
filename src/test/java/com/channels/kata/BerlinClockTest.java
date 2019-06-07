package com.channels.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BerlinClockTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testBerlinClockForNullInput() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Please enter valid input");

        new BerlinClock(null);
    }

    @Test
    public void testBerlinClockForInvalidInput() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Time must be in the format HH:mm:ss");

        new BerlinClock("24:67:56");
    }

}
