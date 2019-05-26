package com.date.controller;
import com.utils.commonRoutines;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.time.*;
@Controller
@RequestMapping("/")
public class homeController {
    commonRoutines rout = new commonRoutines();
    @RequestMapping(value="", method = RequestMethod.GET)
    public String showHomePage(){
        return "home";
    }
    @RequestMapping( value="", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam(value = "name", defaultValue = "World", required = false)  String var,  @RequestParam(value = "utc_date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime utc_local){

        model.addAttribute("name", var);
        ZonedDateTime utc = utc_local.atZone(ZoneId.of("UTC"));
        rout.setUtc(utc);
        model.addAttribute("utc_date", rout.getDate("UTC"));
        model.addAttribute("london_date", rout.getDate("Europe/London"));
        model.addAttribute("ist_date", rout.getDate("Asia/Kolkata"));
        model.addAttribute("ny_date", rout.getDate("America/New_York"));
        return "welcome";
    }

}

