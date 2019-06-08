package com.channels.kata;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class BerlinClockConverter {

    public static final int MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW = 4;
    public static final String NO_LIGHTS = "0";
    public static final int CONSTANT_FIVE = 5;
    public static final String YELLOW_LIGHT = "Y";
    public static final String RED_LIGHT = "R";
    public static final int MAXIMUM_NUMBER_OF_LIGHTS_IN_MINUTE_FIRST_ROW = 11;
    public static final int CONSTANT_TWO = 2;
    private BerlinClock berlinClock;

    public BerlinClockConverter(String digitalTime) {
        LocalTime localTime = parseInputTime(digitalTime);
        berlinClock = processTime(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
    }

    private BerlinClock processTime(int hour, int minute, int seconds) {
        berlinClock = new BerlinClock();
        berlinClock.setSecond((seconds % CONSTANT_TWO == 0) ? YELLOW_LIGHT : NO_LIGHTS);
        berlinClock.setHourFirstRow(generateHourRowString(hour / CONSTANT_FIVE, RED_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW));
        berlinClock.setHourSecondRow(generateHourRowString(hour % CONSTANT_FIVE, RED_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW));
        berlinClock.setMinutesFirstRow(generateHourRowString(minute / CONSTANT_FIVE, YELLOW_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_MINUTE_FIRST_ROW).replace("YYY", "YYR"));
        berlinClock.setMinutesSecondRow(generateHourRowString(minute % CONSTANT_FIVE, YELLOW_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW));
        return berlinClock;
    }

    private String generateHourRowString(int numberOfLightsOnInRow, String lightColor, int manimumNumberOfLightsInRow) {
        StringBuilder rowStringBuilder = new StringBuilder();
        rowStringBuilder.append(StringUtils.repeat(lightColor, numberOfLightsOnInRow));
        rowStringBuilder.append(StringUtils.repeat(NO_LIGHTS, manimumNumberOfLightsInRow - numberOfLightsOnInRow));
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
