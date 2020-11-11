package medo.algorithm;

/**
 * @Author: yangcj
 * @Date: 2020/11/11 13:15
 */
public interface PalindromeNumber {

    default boolean isPalindrome(int x) {
        if (x < 0) return false;
        long reverse = 0;
        int temp = x;
        while (temp != 0) {
            reverse = reverse * 10 + temp % 10;
            temp = temp / 10;
        }
        return (int) reverse == x;
    }

}
