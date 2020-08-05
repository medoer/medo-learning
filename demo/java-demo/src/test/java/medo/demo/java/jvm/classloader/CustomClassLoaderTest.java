package medo.demo.java.jvm.classloader;

import java.io.File;

import org.junit.Test;

public class CustomClassLoaderTest {

    @Test
    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String c = System.getProperty("user.dir");
        ClassLoader classLoader = new CustomClassLoader(c + File.separator + "src/test/java/medo/demo/java/jvm/classloader"+ File.separator + "A.class");
        String fullName = "A";
        Class<?> clazz = Class.forName(fullName, true, classLoader);
        Object newInstance = clazz.newInstance();
        System.out.println(newInstance.getClass().getName());
    }

}
