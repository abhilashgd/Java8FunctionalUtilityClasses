package streams;
/*
Abhilash GD
Java Streams Program to sort a list
 */
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class SortingAList {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(7, 5, 4, 1, 3, 2, 8);

        myList.stream()
                .sorted()
                .forEach(System.out::println);
    }
}