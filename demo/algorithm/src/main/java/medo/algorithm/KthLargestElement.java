package medo.algorithm;

/**
 * 703. Kth Largest Element in a Stream.
 * 
 * @author bryce
 *
 */
public interface KthLargestElement {

    int run(int val);

    default void validParams(int val) {
    }
}
