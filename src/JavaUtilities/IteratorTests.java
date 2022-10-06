package JavaUtilities;

import classes.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class IteratorTests {
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
        Iterator<Person> checkOutTheBoys = theBoysList.iterator();

        Predicate<Person> getRaftel = p -> p.getName().equals("raftel");
        Person boy;

        while(checkOutTheBoys.hasNext()){
            boy = checkOutTheBoys.next();
            System.out.println(boy.getName());
            if(getRaftel.test(boy)){
                System.out.println("Found him!");
                break;
            }
            if(!checkOutTheBoys.hasNext()){
                System.out.println("Not in this list!");
            }
        }

    }
}
