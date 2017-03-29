package i_already_did_that;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tahmid on 3/29/17.
 */
public class Answer {
    public static int answer(String n, int b) {

        List<String> allDescendingNumbers = new ArrayList<>();

        while (true) {

            String subtraction = baseSubtractor(new String[]{ascendingString(n), descendingString(n)}, b);
            System.out.println("Subtraction: " + subtraction);
            n = descendingString(subtraction);
            System.out.println("n: " + n);

            if (allDescendingNumbers.contains(n)) {
                break;
            }

            allDescendingNumbers.add(n);
        }

        return allDescendingNumbers.size() - allDescendingNumbers.indexOf(n);
    }

    private static String baseSubtractor(String strings[], int base) {

        BigInteger b1 = new BigInteger(strings[1], base);
        BigInteger b2 = new BigInteger(strings[0], base);

        return b1.subtract(b2).toString(base);
    }

    private static String ascendingString(String str) {

        char x[] = str.toCharArray();
        Arrays.sort(x);

        return new String(x);
    }

    private static String descendingString(String str) {

        char x[] = str.toCharArray();
        Arrays.sort(x);

        return new StringBuilder(new String(x)).reverse().toString();
    }
}
