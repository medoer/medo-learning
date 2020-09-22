package medo.demo.java.basic;

/**
 * 使用二进制表示支持的状态。如：<br>
 * 1: 00001 2: 00010 4: 00100 7: 01000
 * 
 * 则：1 表示只支持第一种，3:00011 表示支持 1、2 两种
 * 
 * 定义规则，如果取余等于 1 刚表示不支付该配置。
 * 
 * @author: bryce
 * @date: 2020-09-22
 */
public class StateWithBinary {

    public static void main(String[] args) {
        System.out.println(1 & 2);
    }

}
