package medo.demo.java.observable;

@FunctionalInterface
public interface Operator<R, T> {
    Observer<T> call(Observer<R> r);
}
