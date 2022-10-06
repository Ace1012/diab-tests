package JavaUtilities;

import classes.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functional_Interface_Tests {

    static List<Person> people = Arrays.asList(
            new Person( 60, "Charles"),
            new Person( 42, "Lewis"),
            new Person( 51, "Thomas"),
            new Person( 45, "Charlotte"),
            new Person( 39, "Matthew")
    );

    static  List<List<Person>> lists = new ArrayList<>();

    public static void main(String[] args) {
        //Sort List by last name
        people.sort(Comparator.comparing(Person::getName));

        //Create method that prints all elements in the list
        executeConditionally(p -> true, p -> System.out.println("This is " + p.getName()));

        //Create a list that prints all people whose last names begin with "C"
        executeConditionally(p -> p.getName().substring(0,1).equalsIgnoreCase("C"), System.out::println);
    }

    private static void executeConditionally(Predicate<Person> personFilter, Consumer<Person> consumer) {
        people.forEach( p -> {
            if(personFilter.test(p)) consumer.accept(p);
        });
    }

}
