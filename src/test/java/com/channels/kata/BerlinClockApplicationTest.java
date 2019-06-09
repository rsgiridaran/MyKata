package com.channels.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BerlinClockApplicationTest {

    @Test
    public void testBerlinClockApplicationForNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BerlinClockApplication.main(new String[]{null}));

        assertEquals("Time must be in the format HH:mm:ss", exception.getMessage());
    }

    @Test
    public void testBerlinClockApplicationForGivenInput() {
        ByteArrayOutputStream consoleOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutputStream));

        BerlinClockApplication.main(new String[]{"02:45:54"});

        Assertions.assertEquals("Y0000RR00YYRYYRYYR000000",consoleOutputStream.toString());
    }

}