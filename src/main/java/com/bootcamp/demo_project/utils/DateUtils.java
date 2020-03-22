package com.bootcamp.demo_project.utils;

import java.time.Instant;
import java.util.Date;

public class DateUtils {

    public static Date now() {
        return Date.from(Instant.now());
    }
}
