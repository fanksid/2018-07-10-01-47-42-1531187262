package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CollectionOperator {
    List<Integer> getListByInterval(int left, int right) {

        return IntStream.rangeClosed(getMin(left, right), getMax(left, right))
                .boxed()
                .sorted(getComparator(left, right))
                .collect(Collectors.toList());
    }

    private Comparator<Integer> getComparator(int left, int right) {
        if (left < right) {
            return Comparator.comparingInt(i -> i);
        }
        return Comparator.reverseOrder();
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

    List<Integer> getEvenListByIntervals(int left, int right) {
        return getListByInterval(left, right).stream().filter(this::isEvenNumber).collect(Collectors.toList());
    }

    private boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    List<Integer> popEvenElements(int[] array) {
        return Arrays.stream(array).filter(this::isEvenNumber).boxed().collect(Collectors.toList());
    }

    int popLastElement(int[] array) {
        if (Objects.nonNull(array) && array.length != 0) {
            return array[array.length - 1];
        }
        throw new NoSuchElementException();
    }

    List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> first = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        List<Integer> second = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        first.retainAll(second);
        return first;
    }

    List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> first = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> second = Arrays.asList(secondArray);

        first.addAll(second);

        return first.stream().distinct().collect(Collectors.toList());
    }
}
