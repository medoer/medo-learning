package medo.datastructure.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

import medo.datastructure.queue.LinkedQueue;
import medo.datastructure.queue.Queue;

/**
 * 双端队列实现栈。
 * 
 * @author bryce
 *
 * @param <E>
 */
public class StackWithQueue<E> implements Stack<E> {

    Queue<E> queueIn = new LinkedQueue<>();
    Queue<E> queueOut = new LinkedQueue<>();

    public StackWithQueue() {
    };

    public StackWithQueue(E elem) {
        push(elem);
    }

    @Override
    public int size() {
        return queueIn.size();
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
        while (queueIn.size() > 1) {
            queueOut.offer(queueIn.poll());
        }
        E top = queueIn.poll();
        Queue<E> temp = queueIn;
        queueIn = queueOut;
        queueOut = temp;
        return top;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        while (queueIn.size() > 1) {
            queueOut.offer(queueIn.poll());
        }
        E top = queueIn.poll();
        queueOut.offer(top);
        Queue<E> temp = queueIn;
        queueIn = queueOut;
        queueOut = temp;
        return top;
    }

    @Override
    public void push(E elem) {
        queueIn.offer(elem);
    }

    @Override
    public Iterator<E> iterator() {
        return queueIn.iterator();
    }

}
