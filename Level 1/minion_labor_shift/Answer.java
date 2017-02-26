package minion_labor_shift;

import java.util.ArrayList;

/**
 * Created by tahmid on 2/23/17.
 */
public class Answer {
    public static int[] answer(int[] data, int n) {

        if (n == 0)
            return new int[0];

        int[] allIntegers = new int[500];
        ArrayList<Integer> allNumberSequence = new ArrayList<>();
        ArrayList<Integer> toRemoveList = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {

            int temp = data[i];
            allNumberSequence.add(temp);
            allIntegers[temp] += 1;

            if (allIntegers[temp] > n) {

                if (!toRemoveList.contains(temp))
                    toRemoveList.add(temp);
            }
        }

        for (Integer removeInteger : toRemoveList) {

            while (allNumberSequence.contains(removeInteger))
                allNumberSequence.remove(removeInteger);
        }

        int[] newData = new int[allNumberSequence.size()];

        int index = 0;
        for (Integer v : allNumberSequence) {
            newData[index] = v;
            index++;
        }

        return newData;
    }
}
