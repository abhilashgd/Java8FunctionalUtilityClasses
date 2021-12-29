package streams;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;


public class _Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Alisa", FEMALE),
                new Person("Maria", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
               ,new Person("bob", PREFER_NOT_SAY)
        );

       Set<Gender> genders = people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet());
        System.out.println(genders);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> PREFER_NOT_SAY.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
                .noneMatch(personPredicate);
        System.out.println(containsOnlyFemales);

    }
    static class Person {

        private final String name;
        private final _Stream.Gender gender;

        public Person(String name, _Stream.Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender{
        MALE,FEMALE,PREFER_NOT_SAY
    }
}
