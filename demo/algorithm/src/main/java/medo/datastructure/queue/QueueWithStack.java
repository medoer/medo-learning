package medo.datastructure.queue;

import java.util.Iterator;

import medo.datastructure.stack.Stack;
import medo.datastructure.stack.StackImpl;

public class QueueWithStack<T> implements Queue<T> {

    private Stack<T> inStack;
    private Stack<T> outStack;

    public QueueWithStack() {
        this.inStack = new StackImpl<>();
        this.outStack = new StackImpl<>();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return inStack.size() > 0 || outStack.size() > 0;
            }

            @Override
            public T next() {
                if (!outStack.isEmpty()) {
                    return outStack.pop();
                } else if (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                    return outStack.pop();
                }
                throw new RuntimeException();
            }

        };
    }

    @Override
    public int size() {
        return outStack.size() + inStack.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T peek() {
        if (!outStack.isEmpty()) {
            return outStack.peek();
        }
        if (!inStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }
        throw new RuntimeException();
    }

    @Override
    public T poll() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        if (!inStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
        throw new RuntimeException();
    }

    @Override
    public void offer(T elem) {
        inStack.push(elem);
    }

}
