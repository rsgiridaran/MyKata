package com.channels.kata;

import org.junit.Test;

public class BerlinClockTest {


    @Test(expected = IllegalArgumentException.class)
    public void testBerlinClockForNullInput() {
        new BerlinClock(null);
    }

}
