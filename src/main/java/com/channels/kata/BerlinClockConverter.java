package com.channels.kata;

import com.channels.kata.model.BerlinClock;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class BerlinClockConverter {

    public static final int MAXIMUM_NUMBER_OF_LIGHTS_IN_ROW = 4;
    public static final String NO_LIGHTS = "0";
    public static final int CONSTANT_FIVE = 5;
    public static final String YELLOW_LIGHT = "Y";
    public static final String RED_LIGHT = "R";
    public static final int MAXIMUM_NUMBER_OF_LIGHTS_IN_MINUTE_FIRST_ROW = 11;
    public static final int CONSTANT_TWO = 2;
    public static final String TIME_MUST_BE_IN_THE_FORMAT_HH_MM_SS = "Time must be in the format HH:mm:ss";
    private BerlinClock berlinClock;

    public BerlinClockConverter(String digitalTime) {
        LocalTime localTime = parseInputTime(digitalTime);
        berlinClock = processTime(localTime.getHour(), localTime.getMinute(), localTime.getSecond());
    }

    private BerlinClock processTime(int hour, int minute, int seconds) {
        berlinClock = new BerlinClock();
        berlinClock.setSecond((seconds % CONSTANT_TWO == 0) ? YELLOW_LIGHT : NO_LIGHTS);
        berlinClock.setHourFirstRow(generateRowString((hour / CONSTANT_FIVE), RED_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_ROW));
        berlinClock.setHourSecondRow(generateRowString((hour % CONSTANT_FIVE), RED_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_ROW));
        berlinClock.setMinuteFirstRow(generateRowString((minute / CONSTANT_FIVE), YELLOW_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_MINUTE_FIRST_ROW).replace("YYY", "YYR"));
        berlinClock.setMinuteSecondRow(generateRowString((minute % CONSTANT_FIVE), YELLOW_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_ROW));
        return berlinClock;
    }

    private String generateRowString(int numberOfLightsOnInRow, String lightColor, int maximumNumberOfLightsInRow) {
        StringBuilder rowStringBuilder = new StringBuilder();
        rowStringBuilder.append(StringUtils.repeat(lightColor, numberOfLightsOnInRow));
        rowStringBuilder.append(StringUtils.repeat(NO_LIGHTS, (maximumNumberOfLightsInRow - numberOfLightsOnInRow)));
        return rowStringBuilder.toString();
    }

    public BerlinClock getBerlinClock() {
       return this.berlinClock;
    }

    private LocalTime parseInputTime(String digitalTime) {
        if (null == digitalTime) {
            throw new IllegalArgumentException(TIME_MUST_BE_IN_THE_FORMAT_HH_MM_SS);
        }
        try {
            return LocalTime.parse(digitalTime);
        } catch (DateTimeParseException parseException) {
            throw new IllegalArgumentException(TIME_MUST_BE_IN_THE_FORMAT_HH_MM_SS);
        }
    }

}
