package streams;

import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
public class CubeOFNumbersInAList{
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        myList.stream()
                .map(num -> num * num * num)
                .forEach(System.out::println);
        List<Integer> cubeOfNumbers=  myList.stream()
                .map(num -> num * num * num).collect(Collectors.toList());
        System.out.println(cubeOfNumbers);
    }
}