package com.channels.kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BerlinClockConverterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ByteArrayOutputStream consoleOutputStream = new ByteArrayOutputStream();

    @Before
    public void initialize() {
        System.setOut(new PrintStream(consoleOutputStream));
    }

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
    public void testBerlinClockForNullInput() {
        assertIllegalArgumentException();

        new BerlinClockConverter(null);
    }

    @Test
    public void testBerlinClockRepresentationForGivenTime() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("12:56:23");
        berlinClockConverter.printBerlinClock();

        Assert.assertEquals("0RR00RR00YYRYYRYYRYYY000", consoleOutputStream.toString());

    }

    @Test
    public void testBerlinClockRepresentationWithEvenSeconds() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("12:56:16");
        berlinClockConverter.printBerlinClock();

        Assert.assertEquals("YRR00RR00YYRYYRYYRYYY000", consoleOutputStream.toString());

    }

    @Test
    public void testBerlinClockRepresentationWithNoRedLightsInMinuteFirstRow() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("12:04:16");
        berlinClockConverter.printBerlinClock();

        Assert.assertEquals("YRR00RR0000000000000YYYY", consoleOutputStream.toString());

    }

}
