package com.thoughtworks.collection;

import java.util.List;
import java.util.stream.IntStream;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        throw new NotImplementedException();
    }

    int getSumOfProcessedOdds(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    double getMedianOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    double getAverageOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        throw new NotImplementedException();
    }

    List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
    }
}
