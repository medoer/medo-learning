package medo.algorithm.sort;

import java.util.Arrays;

import medo.algorithm.ArraySort;

public class InsertionSort implements ArraySort {

    @Override
    public int[] run(int[] datas) {
        if (datas == null || datas.length <= 1) {
            return datas;
        }
        int[] newArr = Arrays.copyOf(datas, datas.length);
        for (int i = 1; i < newArr.length; i++) {
            int temp = newArr[i];
            int j = i;
            while (j > 0 && temp < newArr[j - 1]) {
                newArr[j] = newArr[j - 1];
                j--;
            }
            if (j != i) {
                newArr[j] = temp;
            }
        }
        return newArr;
    }

}
