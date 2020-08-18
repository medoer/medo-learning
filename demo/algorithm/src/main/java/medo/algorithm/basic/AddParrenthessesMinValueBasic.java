package medo.algorithm.basic;

import medo.algorithm.AddParrenthessesMinValue;

/**
 * 先加后减。
 * 
 * @author: bryce
 * @date: 2020-08-18
 */
public class AddParrenthessesMinValueBasic implements AddParrenthessesMinValue {

    @Override
    public int run(String expression) {
        String[] expressions = expression.split("-");
        int result = 0;
        int[] addResult = new int[expressions.length];
        for (int i = 0; i < expressions.length; i++) {
            String addExperession = expressions[i];
            String[] split = addExperession.split("\\+");
            int total = 0;
            for (int j = 0; j < split.length; j++) {
                total += Integer.valueOf(split[j]);
            }
            addResult[i] = total;
        }
        if (addResult.length > 0) {
            result = addResult[0];
        }
        for (int i = 1; i < addResult.length; i++) {
            result -= addResult[i];
        }
        return result;
    }

}
