package JavaUtilities;

import classes.Person;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ComparatorTests {
    public static void main(String[] args) {
//        Person tony = new classes.Person(20, "Tony");
//        Person ajey = new classes.Person(30, "Ajey");
//        Person balo = new classes.Person(17, "Balo");
//        Person raftel = new classes.Person(2, "Raftel");

        List<Person> theBoysList = List.of(
                new Person(20, "Tony"),
                new Person(30, "Ajey"),
                new Person(17, "Balo"),
                new Person(2, "Raftel")
        );
        ArrayList<Person> theBoysArrayList = new ArrayList<>(theBoysList);

        Comparator<Person> com = (p1,p2) -> {
            if(p1.getAge() > p2.getAge()) return 1;
            else return -1;
        };

//        theBoysArrayList.sort(Comparator.comparing(Person::getAge));
        theBoysArrayList.sort(com);

        theBoysArrayList.forEach( b -> System.out.println(b.getName() + " - " + b.getAge()));

//        PriorityQueue<Person> ageAscending = new PriorityQueue<>();
//        ageAscending.addAll(theBoysArrayList);
//        System.out.println(ageAscending.poll().getName());
    }
}
