package medo.demo.java.observable;

@FunctionalInterface
public interface Observer<T> {
    void onNext(T t);
}
