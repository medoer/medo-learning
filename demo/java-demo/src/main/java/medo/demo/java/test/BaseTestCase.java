package medo.demo.java.test;

import java.util.concurrent.Callable;

public abstract class BaseTestCase<T> implements Callable<T> {

    public abstract BaseResponse execution();

}
