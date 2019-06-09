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
    @CsvSource({"11:11:11,0", "12:12:12,Y"})
    public void testBerlinClockForSeconds(String digitalTime, String expectedSecondsValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals(expectedSecondsValue, berlinClock.getSecond());
    }

    @ParameterizedTest
    @CsvSource({"00:43:33,0000", "05:11:11,R000", "11:12:12,RR00", "16:12:04,RRR0", "23:32:04,RRRR"})
    public void testBerlinClockForFirstHourRow(String digitalTime, String expectedFirstRowValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals(expectedFirstRowValue, berlinClock.getHourFirstRow());
    }

    @ParameterizedTest
    @CsvSource({"00:43:33,0000", "11:12:12,R000", "17:12:04,RR00", "19:32:04,RRRR"})
    public void testBerlinClockForSecondHourRow(String digitalTime, String expectedSecondHourRowValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals(expectedSecondHourRowValue, berlinClock.getHourSecondRow());
    }

    @ParameterizedTest
    @CsvSource({"00:06:33,Y0000000000", "18:18:12,YYR00000000", "17:25:04,YYRYY000000", "19:38:04,YYRYYRY0000", "19:49:04,YYRYYRYYR00", "19:55:04,YYRYYRYYRYY"})
    public void testBerlinClockForMinuteFirstRow(String digitalTime, String expectedMinuteRirstRowValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals(expectedMinuteRirstRowValue, berlinClock.getMinuteFirstRow());
    }

    @ParameterizedTest
    @CsvSource({"00:40:33,0000", "11:21:12,Y000", "17:33:04,YYY0", "19:54:04,YYYY"})
    public void testBerlinClockForSecondMinuteRow(String digitalTime, String expectedSecondMinuteRowValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals(expectedSecondMinuteRowValue, berlinClock.getMinuteSecondRow());
    }

    @Test
    public void testBerlinClockRepresentationForGivenTime() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("12:56:23");
        final BerlinClock berlinClock = berlinClockConverter.getBerlinClock();

        assertEquals("0RR00RR00YYRYYRYYRYYY000", berlinClock.toString());

    }
}
