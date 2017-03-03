package queue_to_do;

/**
 * Created by tahmid on 3/4/17.
 */
public class Answer {
    public static int answer(int start, int length) {

        int checksum = 0;

        int index = 0;

        while (index <= length - 1) {
            checksum ^= xored(start, (start + (length-index)));
            start += length;
            index++;
        }

        return checksum;
    }

    public static int xored(int start, int end) {
        int xor = 0;

        for (int i = start; i < end; i++)
            xor ^= i;

        return xor;
    }
}