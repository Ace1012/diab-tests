package JavaUtilities;

import classes.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static JavaUtilities.Functional_Interface_Tests.lists;

public class StreamsTest {

    static List<Person> people = Arrays.asList(
            new Person( 60, "Charles"),
            new Person( 42, "Lewis"),
            new Person( 51, "Thomas"),
            new Person( 45, "Charlotte"),
            new Person( 39, "Matthew")
    );
    static  List<List<Person>> lists = new ArrayList<>();

    public static void main(String[] args) {
        Stream<Person> personStream = people.stream();
        List<List<char[]>> chars = new ArrayList<>();
        personStream.filter( p -> p.getName().startsWith("C")).forEach(p -> chars.add(Arrays.asList(p.getName().toCharArray())));
        chars.forEach(System.out::println);
        chars.get(0).forEach(Object::toString);


        lists.add(people);
        lists.add(people);
        lists.add(people);
        System.out.println("#####################");
        lists.forEach(l -> l.stream().filter(p -> p.getName().substring(0,1).equalsIgnoreCase("c")).forEach(System.out::println));
        System.out.println("#####################");
    }

}
