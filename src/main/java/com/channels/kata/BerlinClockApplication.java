package com.channels.kata;

public class BerlinClockApplication {
    public static void main(String arg[]) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(arg[0]);
        System.out.print(berlinClockConverter.getBerlinClock());;
    }
}
