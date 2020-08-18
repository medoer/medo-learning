package medo.algorithm;

/**
 * 
 * @author bryce
 *
 */
public interface SavePrincess {

    String run(String command);

    default void validParams(int n) {
    }
}
