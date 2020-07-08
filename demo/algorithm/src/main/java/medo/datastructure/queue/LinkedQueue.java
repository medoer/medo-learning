package medo.datastructure.queue;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 基于双线链表的队列。
 * 
 * @author bryce
 *
 * @param <E>
 */
public class LinkedQueue<E> implements Queue<E> {

    private LinkedList<E> list = new LinkedList<>();

    public LinkedQueue() {
    }
    
    public LinkedQueue(E elem) {
        offer(elem);
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
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.peekFirst();
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.removeFirst();
    }

    @Override
    public void offer(E elem) {
        list.addLast(elem);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
