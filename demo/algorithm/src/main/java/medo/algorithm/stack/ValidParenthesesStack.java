package medo.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

import medo.algorithm.ValidParentheses;

public class ValidParenthesesStack implements ValidParentheses {

    @Override
    public boolean run(String s) {
        validParams(s);
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        char[] leftParentheses = new char[] { '(', '[', '{' };
        char[] rightParentheses = new char[] { ')', ']', '}' };
        for (int i = 0; i < charArray.length; i++) {
            char character = charArray[i];
            if (Arrays.binarySearch(leftParentheses, character) >= 0) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    if (Arrays.binarySearch(rightParentheses, character) >= 0) {
                        return false;
                    }
                    // 其他字符。
                    continue;
                }
                char left = stack.peek();
                if (('(' == left && ')' == character) || ('[' == left && ']' == character)
                        || ('{' == left && '}' == character)) {
                    stack.pop();
                } else if (Arrays.binarySearch(rightParentheses, character) >= 0) {
                    return false;
                }
                // else 其他字符不处理。
            }
        }
        return stack.isEmpty();
    }

}
