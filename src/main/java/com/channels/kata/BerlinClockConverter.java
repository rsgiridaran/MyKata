package com.channels.kata;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class BerlinClockConverter {

    public static final int MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW = 4;
    public static final String NO_LIGHTS = "0";
    public static final int CONSTANTS_FIVE = 5;
    private BerlinClock berlinClock;

    public BerlinClockConverter(String digitalTime) {
        LocalTime localTime = parseInputTime(digitalTime);
        berlinClock = processTime(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
    }

    private BerlinClock processTime(int hour,int minute, int seconds) {
        berlinClock = new BerlinClock();
        berlinClock.setSecond((seconds % 2 == 0) ? "Y" : NO_LIGHTS);
        berlinClock.setHourFirstRow(generateHourRowString(hour / CONSTANTS_FIVE,"R",MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW ));
        berlinClock.setHourSecondRow(generateHourRowString(hour % CONSTANTS_FIVE, "R",MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW));
        berlinClock.setMinutesFirstRow(generateHourRowString(minute / CONSTANTS_FIVE,"Y",11).replace("YYY","YYR"));
        return berlinClock;
    }

    private String generateHourRowString(int numberOfLightsOnInRow,String lightColor,int manimumNumberOfLightsInRow) {
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
