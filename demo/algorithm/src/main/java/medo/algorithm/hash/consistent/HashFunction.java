package medo.algorithm.hash.consistent;
/**
 * Hash String to long value.
 */
public interface HashFunction {
    long hash(String key);
}