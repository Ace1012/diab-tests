package Problems;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerRank {
    public static String compressWordDelete(String word, int k) {
        String preRegex = "([a-z])\\1";
        String add = "";
        add = add.concat("{" + --k + "}");

        String regex = preRegex + add;
        System.out.println("Delete regex is: " + regex + "\n");

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(word);
        StringBuilder stringBuilder = new StringBuilder(word);
        int start = 0;
        int end = 0;

        while(matcher.find()){
            start = matcher.start();
            end = matcher.end();
            stringBuilder = stringBuilder.delete(start,end);
            matcher = pattern.matcher(stringBuilder);
        }

        return stringBuilder.toString();
    }
    public static String compressWordReplace(String word) {
        String regex = "([a-z])\\1+";

        System.out.println("Replace regex is: " + regex + "\n");

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(word);
        StringBuilder stringBuilder = new StringBuilder(word);
        int start = 0;
        int end = 0;

        while(matcher.find()){

//            System.out.println("Before: " + stringBuilder);
            start = matcher.start();
            end = matcher.end();
//            System.out.println(stringBuilder.substring(start,end));
            stringBuilder = stringBuilder.replace(start, end, String.valueOf(stringBuilder.charAt(start)) + (end-start));
//            System.out.println("After: " + stringBuilder + "\n");
            matcher = pattern.matcher(stringBuilder);
        }

//        System.out.println(stringBuilder);

        return stringBuilder.toString();
    }


    public static void main(String[] args) {

        String word = "aaabaaaaccaaaaba";
        //baac
        //aaabaaaaccaaaaba
        int k = 2;

        System.out.println("\n" + word + "\n" + k + "\n");
        System.out.println("Delete answer is: " + compressWordDelete(word, k));
        System.out.println("Replace answer is: " + compressWordReplace(word));
    }

}

