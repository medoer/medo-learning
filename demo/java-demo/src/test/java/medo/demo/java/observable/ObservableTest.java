package medo.demo.java.observable;

import org.junit.Test;

public class ObservableTest {

    @Test
    public void testObservable() {
        Observable.create((observer) -> {
            observer.onNext("s");
        }).subscribe((str) -> {
            System.out.println(str);
        });
    }

}
