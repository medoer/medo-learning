package medo.algorithm;

import org.junit.Assert;
import org.junit.Test;

import medo.algorithm.stack.ValidParenthesesStack;
import medo.algorithm.stack.ValidParenthesesStackMap;
import medo.algorithm.stack.ValidParenthesesStackRightParentheses;

public class ValidParenthesesTest {

    @Test
    public void validParams() {
        ValidParentheses validParenthesesStack = new ValidParenthesesStack();
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            validParenthesesStack.run(null);
        });
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            validParenthesesStack.run("");
        });
    }

    @Test
    public void testStack() {
        ValidParentheses validParenthesesStack = new ValidParenthesesStack();
        test(validParenthesesStack);
    }

    @Test
    public void testStackRight() {
        ValidParentheses validParenthesesStack = new ValidParenthesesStackRightParentheses();
        test(validParenthesesStack);
    }

    @Test
    public void testStackMap() {
        ValidParentheses validParenthesesStack = new ValidParenthesesStackMap();
        test(validParenthesesStack);
    }

    private void test(ValidParentheses validParenthesesStack) {
        String s = " (";
        boolean res1 = validParenthesesStack.run(s);
        Assert.assertFalse(res1);
        s = " ]";
        boolean res2 = validParenthesesStack.run(s);
        Assert.assertFalse(res2);
        s = "(])";
        boolean res4 = validParenthesesStack.run(s);
        Assert.assertFalse(res4);
        s = " (([{xx}xx]))";
        boolean res3 = validParenthesesStack.run(s);
        Assert.assertTrue(res3);
    }

}
