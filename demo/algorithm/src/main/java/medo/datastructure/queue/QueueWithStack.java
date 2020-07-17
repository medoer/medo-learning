package medo.datastructure.queue;

import java.util.Iterator;

import medo.datastructure.stack.ListStack;
import medo.datastructure.stack.Stack;

/**
 * 基于栈的队列。
 * 
 * @author bryce
 *
 * @param <E>
 */
public class QueueWithStack<E> implements Queue<E> {

    private Stack<E> stackIn = new ListStack<>();

    private Stack<E> stackOut = new ListStack<>();

    public QueueWithStack() {
    }

    public QueueWithStack(E elem) {
        offer(elem);
    }

    @Override
    public int size() {
        return stackIn.size() + stackOut.size();
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
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.peek();
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.pop();
    }

    @Override
    public void offer(E elem) {
        stackIn.push(elem);
    }

    @Override
    public Iterator<E> iterator() {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        return stackOut.iterator();
    }
}
