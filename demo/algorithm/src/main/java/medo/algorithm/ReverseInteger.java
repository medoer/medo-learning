package medo.algorithm;

/**
 * @Author: Bryce
 * @Date: 2020/11/9 13:21
 */
public interface ReverseInteger {

    default int reverse(int x) {
        long res = 0;
        while(x != 0) {
            res = res * 10 + x % 10;
            x = x/10;
        }
        return (int)res == res ? (int)res : 0;
    }

}
