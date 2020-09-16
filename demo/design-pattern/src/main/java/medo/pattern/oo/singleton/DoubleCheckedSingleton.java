package medo.pattern.oo.singleton;

public class DoubleCheckedSingleton {

    private static DoubleCheckedSingleton singleton;

    public static DoubleCheckedSingleton getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckedSingleton();
                }
            }
        }
        return singleton;
    }
}
