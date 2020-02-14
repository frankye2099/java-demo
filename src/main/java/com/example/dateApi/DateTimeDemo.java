package com.example.dateApi;

import java.time.*;
import java.time.format.DateTimeFormatter;


public class DateTimeDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.getEra());
        System.out.println(today.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(today.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));

        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);

        LocalDate d2 = LocalDate.of(2015, 02, 20);
        System.out.println(d2);
        LocalDate d3 = LocalDate.parse("2015-02-20");
        System.out.println(d3);
        System.out.println(d2 == d3);
        System.out.println(d2.equals(d3));
        System.out.println(d2.isEqual(d3));
        System.out.println("--------------");


        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        System.out.println(time.atZone(ZoneId.systemDefault()));
        System.out.println(time.atZone(ZoneId.of("Europe/Paris")));
        System.out.println(time.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(time.format(DateTimeFormatter.ISO_TIME));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("--------------");

        Instant now = Instant.now();
        System.out.println(now);
        ZonedDateTime ztime = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println(ztime);
        System.out.println(ZonedDateTime.now());
        System.out.println(ZonedDateTime.now(ZoneId.systemDefault()));

        System.out.println(ztime.withZoneSameLocal(ZoneId.of("Europe/Paris")));
        System.out.println(ztime.withZoneSameInstant(ZoneId.of("Europe/Paris")));
        System.out.println(ZonedDateTime.ofInstant(now, ZoneId.of("Europe/Paris")));

        System.out.println(ztime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(ztime.format(DateTimeFormatter.ISO_INSTANT));
        System.out.println(ztime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        System.out.println(ztime.format(DateTimeFormatter.ISO_LOCAL_TIME));

        System.out.println(ZoneId.getAvailableZoneIds());
    }
}
