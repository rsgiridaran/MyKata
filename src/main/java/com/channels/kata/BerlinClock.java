package com.channels.kata;

public class BerlinClock {

    public BerlinClock(String digitalTime) {
        if (null == digitalTime) {
            throw new IllegalArgumentException("Please enter valid input");
        }
    }

}
