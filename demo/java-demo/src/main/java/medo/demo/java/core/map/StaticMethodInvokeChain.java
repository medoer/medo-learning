package medo.demo.java.core.map;

/**
 * 静态方法实现调用链。<br>
 * 没有抛出空指针异常的原因：静态方法调用在线程栈中根据类对象指针获取方法，不需要调用类实例对象。
 */
public class StaticMethodInvokeChain {

    public static StaticMethodInvokeChain fun1() {
        return null;
    }

    public static StaticMethodInvokeChain fun2() {
        return null;
    }

    public static void main(String[] args) {
        fun1().fun2();
    }

}
