package medo.algorithm;

import java.util.List;

/**
 * 120. Triangle. <br>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于
 * 上一层结点下标 + 1 的两个结点。
 * 
 * @author bryce
 *
 */
public interface Triangle {

    int run(List<List<Integer>> triangle);

}
