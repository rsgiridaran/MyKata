package com.channels.kata;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BerlinClock {

    public BerlinClock(String digitalTime) {
        if (!isValidTimeFormat(digitalTime)) {
            throw new IllegalArgumentException("Time must be in the format HH:mm:ss");
        }

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
