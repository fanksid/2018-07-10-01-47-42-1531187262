package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Add {
    int getSumOfEvens(int leftBorder, int rightBorder) {
        int min = getMin(leftBorder, rightBorder);
        int max = getMax(leftBorder, rightBorder);
        return IntStream.rangeClosed(min, max)
                .filter(this::isEvenNumber)
                .sum();
    }

    private int getMin(int leftBorder, int rightBorder) {
        if (leftBorder < rightBorder) {
            return leftBorder;
        }

        return rightBorder;
    }

    private int getMax(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            return leftBorder;
        }

        return rightBorder;
    }

    private boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    int getSumOfOdds(int leftBorder, int rightBorder) {
        int min = getMin(leftBorder, rightBorder);
        int max = getMax(leftBorder, rightBorder);
        return IntStream.rangeClosed(min, max)
                .filter(this::isOddNumber)
                .sum();
    }

    private boolean isOddNumber(int number) {
        return number % 2 != 0;
    }

    int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(integer -> integer * 3 + 2).sum();
    }

    List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(this::mapTripleOfOddAndAddTwo).collect(Collectors.toList());
    }

    private int mapTripleOfOddAndAddTwo(Integer number) {
        if (isOddNumber(number)) {
            return number * 3 + 2;
        }

        return number;
    }

    int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(this::isOddNumber).mapToInt(integer -> integer * 3 + 5).sum();
    }

    double getMedianOfEven(List<Integer> arrayList) {
        int size = arrayList.size();

        if (isOddNumber(size)) {
            return arrayList.get(size / 2);
        }
        return (arrayList.get(size / 2) + arrayList.get(size / 2 + 1)) / 2.0;
    }

    double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(this::isEvenNumber).mapToInt(integer -> integer).average().getAsDouble();
    }

    boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElement) {
        if (isOddNumber(specialElement)) {
            return false;
        }
        return arrayList.contains(specialElement);
    }

    List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(this::isEvenNumber).distinct().collect(Collectors.toList());
    }

    List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        Map<Boolean, List<Integer>> evenOddList = arrayList.stream()
                .sorted().collect(Collectors.groupingBy(this::isEvenNumber));

        List<Integer> result = new ArrayList<>();

        result.addAll(evenOddList.get(true));
        result.addAll(evenOddList.get(false).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        return result;
    }

    List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            results.add(3 * (arrayList.get(i) + arrayList.get(i + 1)));
        }
        return results;
    }
}
