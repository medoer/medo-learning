package medo.demo.java.observable;

public class TranslateOnSubscribe<R, T> implements OnSubscribe<R>{

    Operator<R, T> operator;
    OnSubscribe<T> parent;

    public TranslateOnSubscribe(OnSubscribe<T> parent, Operator<R, T> operator) {
        this.operator = operator;
        this.parent = parent;
    }

    public static <R, T> TranslateOnSubscribe<R, T> create(OnSubscribe<T> parent, Operator<R, T> operator) {
        return new TranslateOnSubscribe<>( parent, operator);
    }

    @Override
    public void call(Observer<R> observer) {
        Observer<T> tObserver = operator.call(observer);
        parent.call(tObserver);
    }
}
