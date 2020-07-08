package medo.datastructure.queue;

public interface Queue<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    E peek();

    E poll();

    void offer(E elem);

}
