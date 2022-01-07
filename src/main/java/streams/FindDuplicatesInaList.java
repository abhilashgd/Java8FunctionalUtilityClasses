package streams;
/*
Abhilash GD
Java Streams Program to find duplicates
 */
import java.util.*;
import java.util.stream.*;
public class FindDuplicatesInaList {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(1,1,2,2,3,4,5,6,7,7);
        Set<Integer> set = new HashSet();
        myList.stream()
                .filter(n -> !set.add(n))
                .forEach(System.out::println);
    }
}