package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class InverseReduce {

    private Random random = new Random();

    InverseReduce() {
    }

    InverseReduce(Random random) {
        this.random = random;
    }

    List<Integer> divideToSmaller(int number) {
        int span = random.nextInt(3);
        List<Integer> result = new ArrayList<>();
        while (number >= 2) {
            result.add(number - 2);
            number = number - span;
        }

        return result;
    }
}
