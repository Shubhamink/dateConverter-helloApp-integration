package com.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class commonRoutines {
    final String DATE_FORMAT = "dd-MM-yyyy hh:mm a";
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public ZonedDateTime getDate(String zone, ZonedDateTime utc){
        return utc.withZoneSameInstant(ZoneId.of(zone));
    }
    public String ret_view(ZonedDateTime date)
    {
        return formatter.format(date);
    }
}
