package medo.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

import medo.algorithm.ValidAnagram;

public class ValidAnagramHash implements ValidAnagram{

    @Override
    public boolean run(String str1, String str2) {
        validParams(str1, str2);
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] charArray = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            char c1 = charArray[i];
            if (map1.containsKey(c1)) {
                int count = map1.get(c1);
                map1.put(c1, ++count);
            } else {
                map1.put(c1, 1);
            }
            char c2 = charArray2[i];
            if (map2.containsKey(c2)) {
                int count = map2.get(c2);
                map2.put(c2, ++count);
            } else {
                map2.put(c2, 1);
            }
        }
        return map1.equals(map2);
    }

}
