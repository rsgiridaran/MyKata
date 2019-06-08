package com.channels.kata;

public class BerlinClock {
    private String second;
    private String hourFirstRow;
    private String hourSecondRow;
    private String minutesFirstRow;

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

    public String getHourSecondRow() {
        return hourSecondRow;
    }

    public void setHourSecondRow(String hourSecondRow) {
        this.hourSecondRow = hourSecondRow;
    }

    public String getMinutesFirstRow() {
        return minutesFirstRow;
    }

    public void setMinutesFirstRow(String minutesFirstRow) {
        this.minutesFirstRow = minutesFirstRow;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getSecond());
        builder.append(this.getHourFirstRow());
        builder.append(this.getHourSecondRow());
        builder.append(this.getMinutesFirstRow());
        return builder.toString();
    }
}
