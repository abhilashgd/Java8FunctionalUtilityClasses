package streams;
/*
Abhilash GD
Java Streams Program to sort in descending order
 */
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class DescendingSort {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(1,2,3,4,5,6,7,8);

        myList.stream()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);
    }
}