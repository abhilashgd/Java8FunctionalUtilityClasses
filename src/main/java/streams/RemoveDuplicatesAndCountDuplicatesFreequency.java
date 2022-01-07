package streams;

import java.util.*;
import java.util.stream.Collectors;
/*
Abhilash GD
Java Streams Program to
Remove duplicates from list and find frequency of list items
[1,2,2,3,4,4,4,5,6,6,6,6,7]
 */
public class RemoveDuplicatesAndCountDuplicatesFreequency {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1,2,2,3,4,4,4,5,6,6,6,6,7);
        Set<Integer> set = new HashSet<>();
        myList.stream().filter(n->set.add(n)).forEach(System.out::println);
        Map<Object, Long> counts =myList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
System.out.println(counts);

    }

}
