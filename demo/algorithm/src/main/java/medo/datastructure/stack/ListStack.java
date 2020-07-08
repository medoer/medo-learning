package medo.datastructure.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class ListStack<E> implements Stack<E> {

    private LinkedList<E> list = new LinkedList<>();

    public ListStack() {
    };

    public ListStack(E elem) {
        push(elem);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); 
        }
        return list.removeLast();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } 
        return list.peekLast();
    }

    @Override
    public void push(E elem) {
        list.addLast(elem);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

}
