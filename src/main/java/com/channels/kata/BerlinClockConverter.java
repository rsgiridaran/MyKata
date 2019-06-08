package com.channels.kata;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class BerlinClockConverter {

    private BerlinClock berlinClock;

    public BerlinClockConverter(String digitalTime) {
        LocalTime localTime = parseInputTime(digitalTime);
        berlinClock = processTime(localTime.getHour(), localTime.getSecond());
    }

    private BerlinClock processTime(int hour, int seconds) {
        berlinClock = new BerlinClock();
        berlinClock.setSecond((seconds % 2 == 0) ? "Y" : "0");
        berlinClock.setHourFirstRow(StringUtils.repeat("R",hour/5));
        return berlinClock;
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
