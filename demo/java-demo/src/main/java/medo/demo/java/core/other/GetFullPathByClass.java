package medo.demo.java.core.other;

/**
 * 根据 Class 对象获取类的全路径
 */
public class GetFullPathByClass {

    public static String getReference(Class clz) {
        return clz.getName();
    }

    public static void main(String[] args) {
        String name = getReference(GetFullPathByClass.class);
        System.out.println(name);
    }

}
