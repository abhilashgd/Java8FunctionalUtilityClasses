package streams;
/*
Abhilash GD
Java Streams Program to find even numbers
 */
import java.util.*;
import java.util.stream.*;
public class FindEvenNumbersInaList {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(100,201,305,404,667);
        myList.stream()
                .filter(n -> n%2 == 0)
                .forEach(System.out::println);
    }
}
