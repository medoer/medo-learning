package medo.algorithm.stack;

import java.util.Stack;

import medo.algorithm.ValidParentheses;

/**
 * 在 stack 中缓存右括号.
 * @author bryce
 *
 */
public class ValidParenthesesStackRightParentheses implements ValidParentheses {

    @Override
    public boolean run(String s) {
        validParams(s);
        Stack<Character> stack = new Stack<>();
        for (char character : s.toCharArray()) {
            if (character == '(') {
                stack.push(')');
            } else if (character == '[') {
                stack.push(']');
            } else if (character == '{') {
                stack.push('}');
            } else if (!stack.isEmpty() && character == stack.peek()) {
                stack.pop();
            } else if (character == '}' || character == ']' || character == ')') {
                return false;
            }
            // else 其他字符不处理
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

}
