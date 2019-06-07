package com.channels.kata;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BerlinClock {

    private String formattedTime;

    public BerlinClock(String digitalTime) {
        if (!isValidTimeFormat(digitalTime)) {
            throw new IllegalArgumentException("Time must be in the format HH:mm:ss");
        }
        String[] timeElements = digitalTime.split(":");
        formattedTime = processTime(Integer.parseInt(timeElements[2]));
    }

    private String processTime(int seconds) {
        BerlinTime berlinTime = new BerlinTime();
        berlinTime.setSeconds((seconds % 2 == 0) ? "Y" : "0");
        return berlinTime.toString();
    }

    public void printBerlinClock() {
        System.out.print(this.formattedTime);
    }

    private boolean isValidTimeFormat(String digitalTime) {
        digitalTime = digitalTime == null ? "" : digitalTime;
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            dateTimeFormatter.parse(digitalTime);
        } catch (DateTimeParseException parseException) {
            return false;
        }
        return true;
    }
}
