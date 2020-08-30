package medo.algorithm.dynamic;

import java.util.List;

import medo.algorithm.Triangle;

public class TriangleDP implements Triangle {

    @Override
    public int run(List<List<Integer>> triangle) {
        List<Integer> miniCache = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int mini = triangle.get(i).get(j) + Math.min(miniCache.get(j), miniCache.get(j + 1));
                miniCache.set(j, mini);
            }
        }
        return miniCache.get(0);
    }

}
