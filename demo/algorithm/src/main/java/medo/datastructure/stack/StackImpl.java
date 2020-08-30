package medo.datastructure.stack;

import java.util.Iterator;

public class StackImpl<T> implements Stack<T> {

    private static class Node<T> {
        private T data;
        private Node<T> pre;
        private Node<T> next;

        public Node(T data, Node<T> pre, Node<T> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }

    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> trav = tail;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.pre;
                return data;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        T data = tail.data;
        tail = tail.pre;
        size--;
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return tail.data;
    }

    @Override
    public void push(T elem) {
        if (isEmpty()) {
            Node<T> newNode = new Node<>(elem, null, null);
            head = tail = newNode;
        } else {
            Node<T> newNode = new Node<>(elem, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

}
