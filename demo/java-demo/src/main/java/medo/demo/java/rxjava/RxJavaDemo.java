package medo.demo.java.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class RxJavaDemo {

    public String test() {
        return Observable.create((p) -> {

            System.out.println(p);
            p.onNext("1");
        }).onErrorReturn((e) -> e.getMessage()).subscribe().toString();
    }

    public static void main(String[] args) {
        String a = new RxJavaDemo().test();
        System.out.println(a);
    }
}
