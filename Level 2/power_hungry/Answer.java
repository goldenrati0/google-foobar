package power_hungry;

/**
 * Created by tahmid on 2/23/17.
 */
import java.math.BigInteger;
import java.util.Arrays;

public class Answer {

    public static String answer(int[] xs) {

        if(xs.length == 1)
            return Integer.toString(xs[0]);

        int cloneArray[] = xs.clone();

        Arrays.sort(cloneArray);

        int numberOfNegativeNumbers = 0;
        for (int i = 0; i < cloneArray.length; i++) {
            if (cloneArray[i] >= 0) {
                numberOfNegativeNumbers = i;
                break;
            }
        }

        int numberOfZeros = 0;
        for(int i=numberOfNegativeNumbers; i<cloneArray.length; i++) {
            if(cloneArray[i] == 0)
                numberOfZeros++;
        }

        if( (numberOfNegativeNumbers + numberOfZeros) == cloneArray.length)
            return Integer.toString(cloneArray[numberOfNegativeNumbers]);

        BigInteger maxPower = BigInteger.ONE;

        if (numberOfNegativeNumbers == 0) {
            for (int i = 1; i < cloneArray.length; i++) {
                if (cloneArray[i] != 0) {
                    maxPower = maxPower.multiply(new BigInteger(cloneArray[i] + ""));
                }
            }
        } else if (numberOfNegativeNumbers % 2 == 0) {
            for (int i = 0; i < numberOfNegativeNumbers; i++) {
                maxPower = maxPower.multiply(new BigInteger(cloneArray[i] + ""));
            }

            for (int i = numberOfNegativeNumbers; i < cloneArray.length; i++) {
                if (cloneArray[i] != 0) {
                    maxPower = maxPower.multiply(new BigInteger(cloneArray[i] + ""));
                }
            }
        } else if (numberOfNegativeNumbers % 2 != 0) {

            for (int i = 0; i < numberOfNegativeNumbers - 1; i++) {
                maxPower = maxPower.multiply(new BigInteger(cloneArray[i] + ""));
            }

            for (int i = numberOfNegativeNumbers; i < cloneArray.length; i++) {
                if (cloneArray[i] != 0) {
                    maxPower = maxPower.multiply(new BigInteger(cloneArray[i] + ""));
                }
            }
        }

        return maxPower.toString();
    }
}

