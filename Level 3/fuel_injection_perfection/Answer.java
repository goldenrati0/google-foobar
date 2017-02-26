package fuel_injection_perfection;

import java.math.BigInteger;

/**
 * Created by tahmid on 2/27/17.
 */
public class Answer {
    public static int answer(String n) {

        BigInteger num = new BigInteger(n);
        BigInteger two = new BigInteger("2");
        int counter = 0;

        if (num.compareTo(BigInteger.ONE) < 0)
            return 0;

        BigInteger three = new BigInteger("3");
        if (num.equals(three))
            return 2;

        while (!num.equals(BigInteger.ONE)) {

            if (num.equals(three)) {
                counter += 2;
                break;
            }

            if (num.mod(two).equals(BigInteger.ONE)) {

                BigInteger temp = num.add(BigInteger.ONE).divide(two).mod(two);

                if (temp.equals(BigInteger.ONE)) {
                    counter++;
                    num = num.subtract(BigInteger.ONE);
                } else {
                    counter++;
                    num = num.add(BigInteger.ONE);
                }
            }

            num = num.divide(two);
            counter++;
        }

        return counter;
    }
}