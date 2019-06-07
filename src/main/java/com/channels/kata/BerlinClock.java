package com.channels.kata;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BerlinClock {

    public BerlinClock(String digitalTime) {
        if (null == digitalTime) {
            throw new IllegalArgumentException("Please enter valid input");
        }
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            dateTimeFormatter.parse(digitalTime);
        } catch (DateTimeParseException parseException) {
            throw new IllegalArgumentException("Time must be in the format HH:mm:ss");
        }
    }

}
