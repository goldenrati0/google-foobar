package elevator_maintenance;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by tahmid on 2/23/17.
 */

public class Answer {

    public static String[] answer(String[] l) {

        LinkedHashMap<Long, String> numberHashPair = new LinkedHashMap<>();

        for (int i = 0; i < l.length; i++) {
            numberHashPair.put(calcFromStr(l[i]), l[i]);
            System.out.println(calcFromStr(l[i]));
        }

        Object keySet[] = numberHashPair.keySet().toArray();
        Arrays.sort(keySet);

        String[] newL = new String[l.length];

        int index = 0;
        for (Object value : keySet) {
            newL[index] = numberHashPair.get((long) value);
            index++;
        }

        return newL;
    }

    public static long calcFromStr(String s) {
        int a = 0;
        int b = 0;
        int c = 0, d = s.length();

        String[] s2 = s.split("\\.");

        a = Integer.parseInt(s2[0]);
        if (s2.length > 1) {
            b = Integer.parseInt(s.split("\\.")[1]);
        }
        if (s2.length > 2) {
            c = Integer.parseInt(s.split("\\.")[2]);
        }

        return calcHash(a, b, c, d);
    }

    public static long calcHash(int a, int b, int c, int d) {
        return ((a + 1) * ((long) Math.pow(10, 10))) + ((b + 1) * ((long) Math.pow(10, 7))) + ((c + 1) * ((long) Math.pow(10, 2))) + d;
    }
}