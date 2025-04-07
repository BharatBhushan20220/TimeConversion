package com.clockConversion.clockConversion.utils;

import java.time.LocalTime;

public class UtilsCC {
    private static final String[] HOURS = {"twelve", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve"};
    private static final String[] MINUTES = {"", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};

    public static String convert(LocalTime time) {
        int hour = time.getHour();
        int minute = time.getMinute();

        if (hour == 0 && minute == 0) return "It's Midnight";
        if (hour == 12 && minute == 0) return "It's Midday";

        String hourWord = HOURS[hour % 12];
        String minuteWord;

        if (minute == 0) {
            minuteWord = "o'clock";
        } else if (minute <= 20) {
            minuteWord = MINUTES[minute];
        } else {
            int tens = minute / 10;
            int ones = minute % 10;
            String[] tensNames = {"", "", "twenty", "thirty", "forty", "fifty"};
            minuteWord = tensNames[tens];
            if (ones > 0) {
                minuteWord += " " + MINUTES[ones];
            }
        }

        return "It's " + hourWord + (minute == 0 ? " " : " ") + minuteWord;
    }
}
