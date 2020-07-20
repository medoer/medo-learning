package medo.algorithm.basic;

import java.util.Arrays;

import medo.algorithm.ValidAnagram;

public class ValidAnagramSorted implements ValidAnagram{

    @Override
    public boolean run(String str1, String str2) {
        validParams(str1, str2);
        char[] charArray = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray2);
        return String.valueOf(charArray).equals(String.valueOf(charArray2));
    }

}
