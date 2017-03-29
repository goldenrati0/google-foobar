package the_cake_is_not_a_lie;

/**
 * Created by tahmid on 3/21/17.
 */
public class Answer {
    public static int answer(String str) {

        String clone = "";
        int substringIndex = 1;

        while (true) {

            clone = str;
            String substr = clone.substring(0, substringIndex);

            clone = clone.replaceAll(substr, "");

            if (clone.length() == 0)
                return str.length() / substr.length();

            substringIndex++;
        }
    }
}
