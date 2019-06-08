package com.channels.kata;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BerlinClockConverterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();


    private void assertIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Time must be in the format HH:mm:ss");
    }

    @Test
    public void testBerlinClockForInvalidInput() {
        assertIllegalArgumentException();

        new BerlinClockConverter("24:67:56");
    }

    @Test
    public void testBerlinClockForEmptyInput() {
        assertIllegalArgumentException();

        new BerlinClockConverter("");
    }

    @Test
    public void testBerlinClockForSecondsAndFiveHoursRow() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        BerlinClockConverter clock = new BerlinClockConverter("21:56:23");
        clock.printBerlinClock();

        Assert.assertEquals("0RRRR", outputStream.toString());

    }

}
