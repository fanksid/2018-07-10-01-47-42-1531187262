package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(i -> 3 * i).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(i -> String.valueOf(mapIntToChar(i))).collect(Collectors.toList());
    }

    private char mapIntToChar(Integer i) {
        return (char) (i + 'a' - 1);
    }

    private String mapIntToCharTable(Integer i) {
        if (i <= 26) {
            return String.valueOf(mapIntToChar(i));
        }

        return String.valueOf(mapIntToChar(getTableCount(i))) + mapIntToChar(getTableLeft(i));
    }

    private int getTableLeft(Integer i) {
        if (i % 26 == 0) {
            return 26;
        }
        return i % 26;
    }

    private int getTableCount(Integer i) {
        if (i % 26 == 0) {
            return i / 26 - 1;
        }
        return i / 26;
    }

    public List<String> mapLetters() {
        return array.stream().map(this::mapIntToCharTable).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
