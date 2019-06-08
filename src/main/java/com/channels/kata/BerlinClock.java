package com.channels.kata;

public class BerlinClock {
    private String second;
    private String hourFirstRow;

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getHourFirstRow() {
        return hourFirstRow;
    }

    public void setHourFirstRow(String hourFirstRow) {
        this.hourFirstRow = hourFirstRow;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(getSecond());
        builder.append(this.getHourFirstRow());
        return builder.toString();
    }
}
