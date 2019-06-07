package com.channels.kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BerlinClockTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testBerlinClockForNullInput() {
        assertIllegalArgumentException();

        new BerlinClock(null);
    }

    private void assertIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Time must be in the format HH:mm:ss");
    }

    @Test
    public void testBerlinClockForInvalidInput() {
        assertIllegalArgumentException();

        new BerlinClock("24:67:56");
    }

}
