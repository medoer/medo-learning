package medo.demo.java.test;

import java.util.List;
import java.util.concurrent.Future;

public abstract class BaseTestReport {

    public abstract void calResult(List<Future<BaseResponse>> results);

}
