package com.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public  class commonRoutines {
    final String DATE_FORMAT = "dd-MM-yyyy hh:mm a";
    private ZonedDateTime utc;

    public void setUtc(ZonedDateTime utc) {
        this.utc = utc;
    }

    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public String getDate(String zone){
        return formatter.format(utc.withZoneSameInstant(ZoneId.of(zone)));
    }

}
