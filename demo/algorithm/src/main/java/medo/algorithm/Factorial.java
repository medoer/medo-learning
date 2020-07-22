package medo.algorithm;

/**
 * 
 * @author bryce
 *
 */
public interface Factorial {

    int run(int n);

    default void validParams(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
