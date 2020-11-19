package medo.algorithm.basic;

import medo.algorithm.LongestCommonPrefix;

/**
 * @Author: Bryce
 * @Date: 2020/11/19 12:57
 */
public class LongestCommonPrefixImpl implements LongestCommonPrefix {

    @Override
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String res = commonPrefix(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            String commonPrefix = commonPrefix(res, strs[i]);
            if ("".equals(commonPrefix)) {
                return "";
            }
            res = commonPrefix;
        }
        return res;
    }

    private String commonPrefix(String pre, String next) {
        StringBuffer res = new StringBuffer();
        int nextLength = next.length();
        for (int i = 0; i < pre.length() && i < nextLength; i++) {
            char preChar = pre.charAt(i);
            char nextChar = next.charAt(i);
            if (preChar != nextChar) {
                return res.toString();
            }
            res.append(preChar);
        }
        return res.toString();
    }

}
