package medo.pattern.oo.decrotor;

public class TestDecorator2 implements Decorator{

    @Override
    public void accept(Param t, DecoratorChain u) {
        // do something before
        System.out.println("before domain 2");
        u.invokeNext(t);
        // do something post
        System.out.println("after domain 2");
    }

}
