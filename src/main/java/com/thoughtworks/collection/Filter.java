package com.thoughtworks.collection;

import java.util.stream.Collectors;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;

class Filter {

    List<Integer>  array;

    Filter(List<Integer> array) {
     this.array = array;
    }

    List<Integer> filterEven() {
        return array.stream().filter(this::isEvenNumber).collect(Collectors.toList());
    }

    private boolean isEvenNumber(Integer number) {
        return number % 2 == 0;
    }

    List<Integer> filterMultipleOfThree() {
        return array.stream().filter(this::isMultipleOfThree).collect(Collectors.toList());
    }

    private boolean isMultipleOfThree(Integer number) {
        return number % 3 == 0;
    }

    List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        return firstList.stream().filter(secondList::contains).collect(Collectors.toList());
    }

    List<Integer> getDifferentElements() {
        return array.stream().distinct().collect(Collectors.toList());
    }
}