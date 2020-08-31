package medo.datastructure.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 列实现栈。
 * 
 * @author bryce
 *
 * @param <E>
 */
public class StackWithSingleQueue<E> implements Stack<E> {

    private Queue<E> queue;

    public StackWithSingleQueue() {
        this.queue = new LinkedList<>();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public E next() {
                return queue.poll();
            }
        };
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException();
        }
        return queue.poll();
    }

    @Override
    public E peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException();
        }
        return queue.peek();
    }

    @Override
    public void push(E elem) {
        int index = 0;
        queue.offer(elem);
        while (index < queue.size() - 1) {
            queue.offer(queue.poll());
            index++;
        }
    }

}
