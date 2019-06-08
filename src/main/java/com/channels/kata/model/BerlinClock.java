package com.channels.kata.model;

public class BerlinClock {
    private String second;
    private String hourFirstRow;
    private String hourSecondRow;
    private String minuteFirstRow;
    private String minuteSecondRow;

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

    public String getMinuteFirstRow() {
        return minuteFirstRow;
    }

    public void setMinuteFirstRow(String minuteFirstRow) {
        this.minuteFirstRow = minuteFirstRow;
    }

    public String getMinuteSecondRow() {
        return minuteSecondRow;
    }

    public void setMinuteSecondRow(String minuteSecondRow) {
        this.minuteSecondRow = minuteSecondRow;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getSecond());
        builder.append(this.getHourFirstRow());
        builder.append(this.getHourSecondRow());
        builder.append(this.getMinuteFirstRow());
        builder.append(this.getMinuteSecondRow());
        return builder.toString();
    }
}
