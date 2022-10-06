package Problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GFG {

    private static final String REGEX = "\\bgeek\\b";
    private static final String INPUT
            = "geek geek geek geekie geeks";

    public static void main(String[] args) {
        Pattern pat = Pattern.compile(REGEX);

        //  here get a matcher object
        Matcher mat = pat.matcher(INPUT);

        // initialize a count variable to count
        int count = 0;

        // try to match the entire input sequence against
        // the pattern using the loop
        while (mat.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + mat.start());
            System.out.println("end(): " + mat.end());
        }
    }
}
