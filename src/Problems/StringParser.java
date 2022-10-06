package Problems;

import java.util.*;


public class StringParser {

    public static void main(String[] args) {
//        String input = "2[a10[r]bc]4[ab]c";
//        String output = parser(input);
//        System.out.println("Result is: " + output);
    }

    public static String parser(String input) {

        char[] compressed = input.toCharArray();
        Stack<Character> misc = new Stack<>();
        Stack<String> subStrings = new Stack<>();

        for (char c : compressed) {
            switch (c) {
                case ']':
                    StringBuilder sb = new StringBuilder();
//                    sb.toString().replace()
                    while (!Character.isDigit(misc.peek())) {
                        if (misc.peek() != '[') {
                            sb.append(misc.pop());
                        } else {
                            misc.pop();
                        }
                    }
                    StringBuilder number = new StringBuilder();
                    while (!misc.isEmpty() && Character.isDigit(misc.peek())) {
                        number.append(misc.pop());
                    }
                    String temp = sb.toString().repeat(Integer.parseInt(number.reverse().toString()));
                    temp = new StringBuilder(temp).reverse().toString();
                    subStrings.push(temp);

//                    for(Character d : new StringBuilder(temp).reverse().toString().toCharArray()){
//                        misc.push(d);
//                    }
                    break;
                default:
                    misc.push(c);
                    break;
            }
        }
        StringBuilder tempResult = new StringBuilder();
        while (!misc.isEmpty()) {
            tempResult.append(misc.pop());
        }

        return tempResult.reverse().toString();
    }
}
