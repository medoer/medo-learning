package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.basic.ValidAnagramSorted;
import medo.algorithm.hash.ValidAnagramHash;

public class ValidAnagramTest {

    @Test(expected = IllegalArgumentException.class)
    public void testValidParam() {
        String str1 = null;
        ValidAnagram validAnagram = new ValidAnagramSorted();
        validAnagram.validParams(str1, "x");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidParam2() {
        String str1 = "x";
        String str2 = null;
        ValidAnagram validAnagram = new ValidAnagramSorted();
        validAnagram.validParams(str1, str2);
    }
    
    @Test
    public void testSorted() {
        ValidAnagram validAnagram = new ValidAnagramSorted();
        test(validAnagram);
    }

    @Test
    public void testMap() {
        ValidAnagram validAnagram = new ValidAnagramHash();
        test(validAnagram);
    }

    private void test(ValidAnagram validAnagram) {
        String str1 = "anagrma";
        String str2 = "anagram";
        boolean run = validAnagram.run(str1, str2);
        Assert.assertTrue(run);
        str1 = "anagrams";
        boolean run2 = validAnagram.run(str1, str2);
        Assert.assertFalse(run2);
    }

}
