package medo.algorithm;

/**
 * 50. Pow(x, n).
 * 
 * @author bryce
 *
 */
public interface Pow {

    int run(int x, int n);

    default void validParams(int x, int n) {
    }
}
