package medo.algorithm.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import medo.algorithm.ValidParentheses;

public class ValidParenthesesStackMap implements ValidParentheses {

    private static Map<Character, Character> parenthesesMap = new HashMap<Character, Character>() {
        private static final long serialVersionUID = 1L;
    {
        put('(', ')');
        put('[', ']');
        put('{', '}');
    }};

    @Override
    public boolean run(String s) {
        validParams(s);
        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
            if (parenthesesMap.containsKey(character)) {
                stack.push(parenthesesMap.get(character));
            } else {
                // 其他字符跳过
                if (!parenthesesMap.containsValue(character)) {
                    continue;
                }
                if (stack.isEmpty()) {
                    return false;
                }
                if (!character.equals(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
