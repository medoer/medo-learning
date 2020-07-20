package medo.algorithm;

import org.apache.commons.lang3.StringUtils;

/**
 * 242. Valid Anagram.
 * 
 * @author bryce
 *
 */
public interface ValidAnagram {

    boolean run(String str1, String str2);

    default void validParams(String str1, String str2) {
        if (StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
    }
}
