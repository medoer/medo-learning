package medo.datastructure.stack;

public interface Stack<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    E pop();

    E peek();

    void push(E elem);

}
