package com.channels.kata;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BerlinClockApplicationTest {

    @Test(expected = IllegalArgumentException.class)
    public void testBerlinClockApplicationForNullInput() {
        BerlinClockApplication.main(new String[]{null});

    }

    @Test
    public void testBerlinClockApplicationForGivenInput() {
        ByteArrayOutputStream consoleOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutputStream));

        BerlinClockApplication.main(new String[]{"02:45:54"});

        Assert.assertEquals("Y0000RR00YYRYYRYYR000000",consoleOutputStream.toString());
    }

}