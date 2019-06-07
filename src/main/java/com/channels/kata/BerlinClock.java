package com.channels.kata;

public class BerlinClock {
    private String second;

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return getSecond();
    }
}
