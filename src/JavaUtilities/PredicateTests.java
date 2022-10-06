package JavaUtilities;

import classes.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class PredicateTests {

    public static void main(String[] args) {
        Predicate<Integer> greaterThan3 = i -> i > 3;
        int num = 6;
        System.out.println("Integer predicate -> greaterThan3: " + num);
        System.out.println(greaterThan3.test(num));
        System.out.println("\n");


        Predicate<String> passwordTooShort = s -> s.length() < 6;
        String s = "yo";
        System.out.println("String predicate -> passwordTooShort(6): " + s);
        System.out.println(passwordTooShort.test(s));
        System.out.println("\n");

        //Predicate chaining
        Predicate<Integer> lessThan10 = (i) -> i < 10;
        int chainInt = 11;
        System.out.println("Chaining -> greaterThan3 and lessThan10: " + chainInt);
        System.out.println(greaterThan3.and(lessThan10).test(chainInt));
        System.out.println("\n");

        //IntFunction stored in a map
        Map<String, IntFunction<Predicate<Person>>> searchMap = new HashMap<>();
        searchMap.put("allPilots", maxAge -> (p -> p.getAge() >= 23 && p.getAge() <= maxAge));
        searchMap.put("canDrinkBeer", age -> p -> p.getAge() > age);
        Predicate<Person> allPilotsAgedLessThan45 = searchMap.get("allPilots").apply(45);
        System.out.println(allPilotsAgedLessThan45.test(new Person(44)));
        System.out.println("Can I drink beer? : " + searchMap.get("canDrinkBeer").apply(18).test(new Person(17)));

        System.out.println("UngaBunga");
        PredicateTests predicateTests = new PredicateTests();
    }
}
