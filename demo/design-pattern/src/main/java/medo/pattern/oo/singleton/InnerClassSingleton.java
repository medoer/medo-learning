package medo.pattern.oo.singleton;

public class InnerClassSingleton {

    private static class SingletonHelper {
        public static InnerClassSingleton singleton = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHelper.singleton;
    }

}
