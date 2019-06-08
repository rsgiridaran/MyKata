package com.channels.kata;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class BerlinClockConverter {

    public static final int MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW = 4;
    public static final String NO_LIGHTS = "0";
    private BerlinClock berlinClock;

    public BerlinClockConverter(String digitalTime) {
        LocalTime localTime = parseInputTime(digitalTime);
        berlinClock = processTime(localTime.getHour(), localTime.getSecond());
    }

    private BerlinClock processTime(int hour, int seconds) {
        berlinClock = new BerlinClock();
        berlinClock.setSecond((seconds % 2 == 0) ? "Y" : NO_LIGHTS);
        berlinClock.setHourFirstRow(generateHourRowString(hour));
        return berlinClock;
    }

    private String generateHourRowString(int hour) {
        StringBuilder rowStringBuilder = new StringBuilder();
        int numberOfLightsOnInRow = hour / 5;
        rowStringBuilder.append(StringUtils.repeat("R",numberOfLightsOnInRow));
        rowStringBuilder.append(StringUtils.repeat(NO_LIGHTS, MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW - numberOfLightsOnInRow));
        return rowStringBuilder.toString();
    }

    public void printBerlinClock() {
        System.out.print(this.berlinClock);
    }

    private LocalTime parseInputTime(String digitalTime) {
        if (null == digitalTime) {
            return LocalTime.now();
        }
        try {
            return LocalTime.parse(digitalTime);
        } catch (DateTimeParseException parseException) {
            throw new IllegalArgumentException("Time must be in the format HH:mm:ss");
        }
    }

}
