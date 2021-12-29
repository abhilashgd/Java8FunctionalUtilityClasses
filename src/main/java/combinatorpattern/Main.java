package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@email.com",
                "+089898989878",
                LocalDate.of(2000,1,1)
        );
       // System.out.println(
         //       new CustomerValidatorService().isValid(customer));

        //if valid, we can store customer in db

        //Using Combinator Pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);
        if(result !=ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
