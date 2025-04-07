package com.clockConversion.clockConversion.controller;

import com.clockConversion.clockConversion.service.ServiceCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/time")
public class ControllerCC {

    @Autowired
    ServiceCC serviceCC;

    @GetMapping(path = "/home")
    public String welcome(){
        return "Welcome to the Project";
    }

    @GetMapping("/now")
    public String getCurrentTimeInWords() {
        return serviceCC.conversionForNOW();
    }

    @GetMapping("/convert")
    public String convertTimeToWords(@RequestParam("input") String inputTime) {
        return serviceCC.convertUserGivenTime(inputTime);
    }
}
