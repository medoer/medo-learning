package medo.algorithm.basic;

import medo.algorithm.Dial;

public class DialBase implements Dial {

    @Override
    public int run(String[] keys) {
        int total = 0;

        for (int i = 1; i < keys.length; i++) {
            int preIndex = getIndex(keys[i - 1]);
            int[] preNumber = COORD[preIndex];

            int currentIndex = getIndex(keys[i]);
            int[] currentNumber = COORD[currentIndex];

            int distance = Math.abs(preNumber[0] - currentNumber[0]) + Math.abs(preNumber[1] - currentNumber[1]);
            total += distance;
        }
        return total;
    }

    private int getIndex(String button) {
        if ("*".equals(button)) {
            return 9;
        }
        if ("0".equals(button)) {
            return 10;
        }
        if ("#".equals(button)) {
            return 11;
        }
        return Integer.valueOf(button) - 1;
    }

}
