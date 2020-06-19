package com.mycompany.app;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Range {
    int[] endPoints;
    List<Integer> values;

    public Range(String expression) {
        String regex = "(\\[|\\()(-\\d*|\\d*),(-\\d*|\\d*)(\\]|\\))";

        if (expression.matches(regex)) {
            String rangeNumbers = expression.substring(1, expression.length() - 1);
            String[] valuesString = rangeNumbers.split(",");
            endPoints = new int[2];
            endPoints[0] = Integer.parseInt(valuesString[0]);
            endPoints[1] = Integer.parseInt(valuesString[1]);
            if (expression.startsWith("(")) {
                endPoints[0]++;
            }
            if (expression.endsWith(")")) {
                endPoints[1]--;
            }
            if (endPoints[0] < endPoints[1]) {
                values = IntStream.rangeClosed(endPoints[0], endPoints[1]).boxed().collect(Collectors.toList());
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(int... vals) {
        for (int val : vals) {
            if (!values.contains(val)) {
                return false;
            }
        }
        return true;
    }

    public boolean doesNotContains(int... vals) {
        return !contains(vals);
    }

    public Integer[] allPoints() {
        Integer[] points = new Integer[values.size()];
        values.toArray(points);
        return points;
    }

    public boolean containsRange(Range otherRange) {
        if (contains(otherRange.endPoints[0], endPoints[1])) {
            return true;
        }
        return false;
    }

    public boolean doesNotContainsRange(Range otherRange) {
        return !containsRange(otherRange);
    }

    public int[] endPoints() {
        return endPoints;
    }

    public boolean overlapsRange(Range otherRange) {
        if (contains(otherRange.endPoints[0]) || contains(otherRange.endPoints[1])) {
            return true;
        }
        return false;
    }

    public boolean Equals(Range otherRange) {
        if (endPoints[0] == otherRange.endPoints()[0] && endPoints[1] == otherRange.endPoints()[1]) {
            return true;
        }
        return false;
    }

    public boolean notEquals(Range otherRange) {
        return !Equals(otherRange);
    }

}