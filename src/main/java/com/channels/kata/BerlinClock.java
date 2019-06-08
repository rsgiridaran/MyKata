package com.channels.kata;

public class BerlinClock {
    private String second;
    private String hourFirstRow;
    private String hourSecondRow;
    private String minutesFirstRow;
    private String minutesSecondRow;

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

    public String getMinutesSecondRow() {
        return minutesSecondRow;
    }

    public void setMinutesSecondRow(String minutesSecondRow) {
        this.minutesSecondRow = minutesSecondRow;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(this.getSecond());
        builder.append(this.getHourFirstRow());
        builder.append(this.getHourSecondRow());
        builder.append(this.getMinutesFirstRow());
        builder.append(this.getMinutesSecondRow());
        return builder.toString();
    }
}
