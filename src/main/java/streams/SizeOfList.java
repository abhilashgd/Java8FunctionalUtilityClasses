package streams;
/*
Abhilash GD
Java Streams Program to find the size of a list
 */
import java.util.*;
import java.util.stream.*;
public class SizeOfList {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(1,1,1,1,1,1,1,1,1);
        long count =  myList.stream()
                .count();
        System.out.println(count);
    }
}
