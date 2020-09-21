package medo.algorithm.recursion;

import java.util.Arrays;

import medo.algorithm.BinarySearch;

/**
 * 1. 排序
 * 2. 计算中间位置，比较计算下一段查询索引
 * 3. 设置递归出口
 * 
 * @author: bryce
 * @date: 2020-09-21
 */
public class BinarySearchRecursion implements BinarySearch{

    @Override
    public int run(int[] datas, int search) {
        if (datas == null || datas.length < 1) {
            return -1;
        }
        Arrays.sort(datas);
        return search(datas, 0, datas.length - 1, search);
    }
    
    private Integer search(int[] datas, int begin, int end, int search) {
        if (begin > end) {
            return -1;
        }
        int mid = (end + begin) / 2;
        if (datas[mid] == search) {
            return mid;
        } else if (datas[mid] < search) {
            return search(datas, mid + 1, end, search);
        } else {
            return search(datas, begin, mid - 1, search);
        }
    }

}
