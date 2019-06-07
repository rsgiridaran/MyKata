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

}
