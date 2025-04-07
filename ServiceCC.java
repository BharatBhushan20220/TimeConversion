package com.clockConversion.clockConversion.service;

import com.clockConversion.clockConversion.utils.UtilsCC;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class ServiceCC {

    public String conversionForNOW(){
        LocalTime now = LocalTime.now();
        return UtilsCC.convert(now);
    }

    public String convertUserGivenTime(String timeInput) {
        try {
            LocalTime time = LocalTime.parse(timeInput, DateTimeFormatter.ofPattern("HH:mm"));
            return UtilsCC.convert(time);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format. Please use HH:mm.");
        }
    }
}
