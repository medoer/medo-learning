package medo.algorithm.basic;

import medo.algorithm.RomanToInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangcj
 * @Date: 2020/11/14 13:26
 */
public class RomanToIntegerImpl implements RomanToInteger {

    private static final Map<Character, Integer> DICT = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    @Override
    public int romanToInteger(String roman) {
        int res = 0;
        int preChar = DICT.get(roman.charAt(0));
        for (int i = 1; i < roman.length(); i++) {
            int romanChar = DICT.get(roman.charAt(i));
            if (preChar < romanChar) {
                res -= preChar;
            } else {
                res += preChar;
            }
            preChar = romanChar;
        }
        res += preChar;
        return res;
    }
}
