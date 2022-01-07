package streams;
/*
Abhilash GD
Java Streams Program to find numbers starting with 1
 */


import java.util.*;
import java.util.stream.*;

public class FindNumberStartingWith1 {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(100, 203, 11,405, 911, 119);
        myList.stream()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);
    }
}