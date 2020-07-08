package medo.algorithm;

/**
 * 20. Valid Parentheses.
 * 
 * @author bryce
 *
 */
public interface ValidParentheses {

    boolean run(String s);

    default void validParams(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
