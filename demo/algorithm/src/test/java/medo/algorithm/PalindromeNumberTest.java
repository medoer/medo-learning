package medo.algorithm;

import medo.algorithm.basic.PalindromeNumberImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: Bryce
 * @Date: 2020/11/11 13:19
 */
public class PalindromeNumberTest {

    @Test
    public void test() {
        PalindromeNumberImpl palindromeNumber = new PalindromeNumberImpl();
        Assert.assertTrue(palindromeNumber.isPalindrome(1221));
        Assert.assertFalse(palindromeNumber.isPalindrome(124521));
        Assert.assertFalse(palindromeNumber.isPalindrome(-121));
    }

}
