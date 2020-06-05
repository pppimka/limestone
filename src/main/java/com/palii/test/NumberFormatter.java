package com.palii.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberFormatter {

    public static String format(Integer number) {

        List<Integer> result = parseNumber(number).stream()
                .distinct().sorted().collect(Collectors.toList());

        return createGroups(result).stream().map(Group::toString).collect(Collectors.joining(","));
    }

    private static List<Group> createGroups(List<Integer> numbers) {

        List<Group> result = new ArrayList<>();
        Group group = new Group(numbers.get(0), numbers.get(0));

        for (int i = 0; i < numbers.size() - 1; i++) {
            int prev = numbers.get(i);
            int next = numbers.get(i + 1);
            if (prev + 1 != next) {
                group.end = prev;
                result.add(group);
                group = new Group(next, next);
            }
            group.end = next;
        }

        result.add(group);
        return result;
    }

    private static ArrayList<Integer> parseNumber(Integer number) {
        
        ArrayList<Integer> result = new ArrayList<>();
        while (number > 0) {
            int i = number % 10;
            if (i > 7 || i < 1) {
                throw new NumberFormatException("Wrong number format, should contain only digits 1-7");
            }
            result.add(i);
            number /= 10;
        }
        return result;
    }

    private static class Group {

        private int start;
        private int end;

        public Group(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start == end ? String.valueOf(start) : start + "-" + end;
        }
    }
}
