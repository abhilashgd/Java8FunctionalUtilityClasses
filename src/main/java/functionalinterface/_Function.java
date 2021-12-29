package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        //Function takes 1 argument and produces one result
        System.out.println("without a function: increment 1 by 1");

        int increment = incrementByOne(1);
        System.out.println(increment);
        System.out.println("with a function: increment 1 by 1");

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multilpy = multiplyBy10Function.apply(increment2);
        System.out.println(multilpy);
        Function<Integer,Integer> addBy1AndThenMultiplyBy10=
                incrementByOneFunction.andThen(multiplyBy10Function);

       System.out.println(addBy1AndThenMultiplyBy10.apply(4));

       System.out.println(incrementByOneAndMultipy(4,100));
        System.out.println(incrementByOneAndMultipyBiFunction.apply(4, 100));

    }
    static Function<Integer,Integer> incrementByOneFunction= number->number+1;
    /*
    above function is equivalent to

    static int incerementByOne(int number){
    return number+1;
    }
     */
    static Function<Integer,Integer> multiplyBy10Function= number->number*10;
    static int incrementByOne(int number){
        return number+1;
    }

    static BiFunction<Integer,Integer,Integer>
            incrementByOneAndMultipyBiFunction =
            (numberToIncrementByOne,numberToMultiplyBy)
                    ->(numberToIncrementByOne+1) * numberToMultiplyBy;

    static int incrementByOneAndMultipy(int number, int numToMultiply){
        return (number+1) *numToMultiply;
    }
}
