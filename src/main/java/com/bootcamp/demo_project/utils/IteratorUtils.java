package com.bootcamp.demo_project.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IteratorUtils {

    public static <P> List<P> toList(Iterable<P> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

}
