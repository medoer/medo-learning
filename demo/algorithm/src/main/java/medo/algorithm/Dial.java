package medo.algorithm;

public interface Dial {
    
    public static int[][] COORD = new int[][] {
        {0, 3}, {1, 3}, {2, 3}, {0, 2}, {1, 2}, {2, 2}, {0, 1}, {1, 1}, {2, 1}, {0, 0},
        {1, 0}, {2, 0}
    };

    int run(String[] keys);

}