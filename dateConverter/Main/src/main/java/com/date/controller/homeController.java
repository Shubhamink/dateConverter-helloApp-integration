package com.date.controller;
import com.utils.commonRoutines;
import com.utils.model.userModel;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.time.*;
import java.time.format.DateTimeFormatter;
@Controller
@RequestMapping("/")
public class homeController {
    userModel user = new userModel();
    commonRoutines rout = new commonRoutines();
    @RequestMapping(value="", method = RequestMethod.GET)
    public String showHomePage(){
        return "home";
    }
    @RequestMapping( value="", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam(value = "name", defaultValue = "World", required = false)  String var,  @RequestParam(value = "utcdate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime utc_local){

        model.addAttribute("name", var);
        final String DATE_FORMAT = "dd-MM-yyyy hh:mm a";
        ZonedDateTime utc = utc_local.atZone(ZoneId.of("UTC"));
        //ZonedDateTime london = utc.withZoneSameInstant(ZoneId.of("Europe/London"));

        ZonedDateTime london = rout.getDate("Europe/London", utc);
        //ZonedDateTime ny = utc.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime ny = rout.getDate("America/New_York", utc);
        //ZonedDateTime ist = utc.withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime ist = rout.getDate("Asia/Kolkata", utc);

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        model.addAttribute("utc_date", rout.ret_view(utc));
        model.addAttribute("london_date", rout.ret_view(london));
        model.addAttribute("ist_date", rout.ret_view(ist));
        model.addAttribute("ny_date", rout.ret_view(ny));
        return "welcome";
    }

}

