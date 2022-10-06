package Problems;

import java.util.*;

public class MinWindow {
    public static void main(String[] args) {
//        String input = "2[a10[r]bc]4[ab]c";
//        String output = parser(input);
//        System.out.println("Result is: " + output);
        System.out.println(minWindowHash("acbzba", "ab"));
    }

    public static String minWindow(String s, String t) {
        // System.out.println("S.length is: " + s.length());
        String result = "";

        //if t is longer return empty string
        if(s.length() < t.length()) return "";

        ArrayList<String> tList = new ArrayList<>(Arrays.asList(t.split("")));
        ArrayList<String> tListCopy = new ArrayList<>(Arrays.asList(t.split("")));
        // System.out.println("tList is: " + tList + "\n");

        int left = 0;
        int right = t.length();
        String sub = "";
        ArrayList<String> s1;

        while(right <= s.length()){
            // System.out.println("Right is: #" + right);
            sub = s.substring(left, right);
            s1 = new ArrayList<>(Arrays.asList(sub.split("")));
            int localRight = right;

            while(localRight <= s.length()){
                sub = s.substring(left, localRight);
                s1 = new ArrayList<>(Arrays.asList(sub.split("")));
                // System.out.println("Sub is: " + sub);
                // System.out.println("Before removal tList is: " + tListCopy);

                for(String a : sub.split("")){
                    tListCopy.remove(a);
                }

                // System.out.println("After removal tList is: " + tListCopy);

                if(tListCopy.size() == 0){
                    return sub;
                }

                left++;
                localRight++;

                tListCopy = new ArrayList<>(Arrays.asList(t.split("")));;
                // System.out.println("Refreshed tList is: " + tListCopy);
                // System.out.println("LocalRight is: #" + localRight);

            }
            left = 0;
            right++;
        }
        return result;
    }

    public static String minWindowHash(String s, String t){
        String result = "";

        //if t is longer return empty string
        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();

        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c,0) + 1);
        }
        System.out.println(tMap);

        int totalMatched = 0;
        int start = 0;

        for(int right = 0; right < s.length(); right++){
            char current = s.charAt(right);

            if(tMap.containsKey(current)){
                tMap.put(current, tMap.get(current) - 1);
                if(tMap.get(current) == 0){
                    totalMatched++;
                }
            }

            while(tMap.size() == totalMatched){
                result = result == "" || result.length() > s.substring(start, right + 1).length() ? s.substring(start, right + 1) : result;
                char deleted = s.charAt(start++);
                if(tMap.containsKey(deleted)){
                    if(tMap.get(deleted) == 0) totalMatched--;
                    tMap.put(deleted, tMap.get(deleted) + 1);
                }
            }
        }
        return result;
    }
}
