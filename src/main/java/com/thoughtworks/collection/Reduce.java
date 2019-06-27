package com.thoughtworks.collection;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.apache.commons.collections.CollectionUtils;

class Reduce {

    List<Integer> arrayList;

    Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    int getMaximum() {
        validateArrayList();
        return arrayList.stream().mapToInt(i -> i).max().getAsInt();
    }

    private void validateArrayList() {
        if (CollectionUtils.isEmpty(arrayList)) {
            throw new NoSuchElementException();
        }
    }

    double getMinimum() {
        validateArrayList();
        return arrayList.stream().mapToInt(i -> i).min().getAsInt();
    }

    double getAverage() {
        validateArrayList();
        return arrayList.stream().mapToInt(i -> i).average().getAsDouble();
    }

    double getOrderedMedian() {
        validateArrayList();

        arrayList = arrayList.stream().sorted().collect(Collectors.toList());

        return getMedianForList(arrayList);

    }

    private double getMedianForList(List<Integer> arrayList) {
        validateArrayList();
        int size = arrayList.size();
        if (isEvenNumber(size)) {
            return (arrayList.get(size / 2) + arrayList.get(size / 2 - 1)) / 2.0;
        }
        return arrayList.get(size / 2);
    }

    int getFirstEven() {
        validateArrayList();
        return arrayList.stream().filter(this::isEvenNumber).findFirst().get();
    }

    private boolean isEvenNumber(Integer number) {
        return number % 2 == 0;
    }

    private boolean isOddNumber(Integer number) {
        return number % 2 != 0;
    }

    int getIndexOfFirstEven() {
        int firstEven = getFirstEven();

        return arrayList.indexOf(firstEven);
    }

    boolean isEqual(List<Integer> arrayList) {
        return CollectionUtils.isEqualCollection(arrayList, this.arrayList);
    }

    Double getMedianInLinkList(SingleLink singleLink) {
        validateArrayList();
        arrayList.forEach(singleLink::addTailPointer);

        int size = arrayList.size();
        if (isEvenNumber(size)) {
            return ((Integer) singleLink.getNode(size / 2) + (Integer) singleLink.getNode(size / 2 + 1)) / 2.0;
        }
        return 1.0 * (Integer) singleLink.getNode(size / 2 + 1);

    }

    int getLastOdd() {
        validateArrayList();
        return arrayList.stream().sorted((o1, o2) -> -1).filter(this::isOddNumber).findFirst().get();
    }

    int getIndexOfLastOdd() {
        int lastOdd = getLastOdd();

        return arrayList.indexOf(lastOdd);
    }
}
