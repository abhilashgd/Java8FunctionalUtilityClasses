package finalsection;

import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        Function<String,String> upperCaseName = name-> {
            if(name.isBlank()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        BiFunction<String,Integer, String> upperCaseName2 = (name,age)-> {
            if(name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };
        System.out.println(upperCaseName.apply("alex"));
        System.out.println(upperCaseName2.apply("alex",20));
    }

    class Service{
        public Consumer<String> test = s->{};
    }
}
