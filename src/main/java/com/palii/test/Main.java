package com.palii.test;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream.of(args).map(Integer::valueOf)
                .map(NumberFormatter::format)
                .forEach(System.out::print);
    }
}
