package medo.demo.java.observable;

/**
 * 负责把业务结果传递到 observer 中
 * @param <T>
 */
@FunctionalInterface
public interface OnSubscribe<T> {
    void call(Observer<T> observer);
}
