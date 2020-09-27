package medo.demo.java.observable;

public class Observable<T> {

    private OnSubscribe<T> onSubscribe;

    private Observable(OnSubscribe<T> onSubscribe) {
        this.onSubscribe = onSubscribe;
    }

    public static <T> Observable<T> create(OnSubscribe<T> onSubscribe) {
        return new Observable<>(onSubscribe);
    }

    public <R> Observable<R> translate(Operator<R, T> operator) {
        return create(TranslateOnSubscribe.create(onSubscribe, operator));
    }

    public void subscribe(final Observer<T> observer) {
        onSubscribe.call(observer);
    }
}
