package com.channels.kata;

import com.channels.kata.model.BerlinClock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BerlinClockConverterTest {

    private BerlinClock berlinClock;

    static Stream<String> invalidInputStream() {
        return Stream.of("", "   ", null);
    }

    @ParameterizedTest
    @MethodSource("invalidInputStream")
    public void testBerlinClockForInvalidInput(String digitalTime) {

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new BerlinClockConverter(digitalTime));
        assertEquals("Time must be in the format HH:mm:ss", exception.getMessage());

    }

    @ParameterizedTest
    @CsvSource({"11:11:11,0","12:12:12,Y"})
    public void testBerlinClockForSeconds(String digitalTime, String expectedSecondsValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals(expectedSecondsValue, berlinClock.getSecond());
    }

    @ParameterizedTest
    @CsvSource({"00:43:33,0000","05:11:11,R000","11:12:12,RR00","16:12:04,RRR0","23:32:04,RRRR"})
    public void testBerlinClockForFirstHourRow(String digitalTime, String expectedFirstRowValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals(expectedFirstRowValue, berlinClock.getHourFirstRow());
    }

    @ParameterizedTest
    @CsvSource({"00:43:33,0000","11:12:12,R000","17:12:04,RR00","19:32:04,RRRR"})
    public void testBerlinClockForSecondHourRow(String digitalTime, String expectedSecondHourRowValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals(expectedSecondHourRowValue, berlinClock.getHourSecondRow());
    }


    @Test
    public void testBerlinClockRepresentationForGivenTime() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("12:56:23");
        final BerlinClock berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals("0RR00RR00YYRYYRYYRYYY000", berlinClock.toString());

    }

    @Test
    public void testBerlinClockRepresentationWithEvenSeconds() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("12:56:16");
        final BerlinClock berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals("YRR00RR00YYRYYRYYRYYY000", berlinClock.toString());

    }

    @Test
    public void testBerlinClockRepresentationWithNoRedLightsInMinuteFirstRow() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("12:04:16");
        final BerlinClock berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals("YRR00RR0000000000000YYYY", berlinClock.toString());

    }

}
