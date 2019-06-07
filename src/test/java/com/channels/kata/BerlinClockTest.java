package com.channels.kata;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    public void testBerlinClockForSeconds() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        BerlinClock clock = new BerlinClock("21:56:23");
        clock.printBerlinClock();

        Assert.assertEquals("0", outputStream.toString());

    }

}
