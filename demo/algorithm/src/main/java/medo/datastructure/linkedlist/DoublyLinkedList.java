package medo.datastructure.linkedlist;

import java.util.Iterator;

/**
 * 双向链表。
 * 
 * @author bryce
 *
 * @param <E>
 */
public class DoublyLinkedList<E> implements LinkedList<E> {

    private static class Node<E> {
        private E data;
        private Node<E> prev, next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private int size;
    private Node<E> head = null;
    private Node<E> tail = null;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        Node<E> trav = head;
        while (trav != null) {
            Node<E> next = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public void add(E elem) {
        addLast(elem);
    }

    @Override
    public void addLast(E elem) {
        if (isEmpty()) {
            head = tail = new Node<>(elem, null, null);
        } else {
            tail.next = new Node<>(elem, tail, null);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public void addFirst(E elem) {
        if (isEmpty()) {
            head = tail = new Node<>(elem, null, null);
        } else {
            head.prev = new Node<>(elem, null, head);
            head = head.prev;
        }
        size++;
    }

    @Override
    public void addAt(int index, E elem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(elem);
            return;
        }
        if (index == size) {
            addLast(elem);
            return;
        }
        Node<E> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<E> newNode = new Node<>(elem, temp, temp.next);
        temp.next.prev = newNode;
        temp.next = newNode;
        size++;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        return head.data;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        return tail.data;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        E data = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }
        return data;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty List");
        }
        E data = tail.data;
        tail = tail.prev;
        size--;
        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }
        return data;
    }

    @Override
    public boolean remove(E elem) {
        Node<E> trav = head;
        if (elem == null) {
            for (; trav != null; trav = trav.next) {
                if (trav.data == null) {
                    remove(trav);
                    return true;
                }
            }
        } else {
            for (; trav != null; trav = trav.next) {
                if (elem.equals(trav.data)) {
                    remove(trav);
                    return true;
                }
            }
        }
      
        return false;
    }

    @Override
    public E removeAt(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int j;
        Node<E> trav = null;
        if (index < size / 2) {
            for (j = 0, trav = head; j != index; j++) {
                trav = trav.next;
            }
        } else {
            for (j = size - 1, trav = tail; j != index; j--) {
                trav = trav.prev;
            }
        }
        return remove(trav);
    }

    @Override
    public int indexOf(E elem) {
        int index = 0;
        Node<E> trav = head;
        if (elem == null) {
            for (; trav != null; trav = trav.next, index++) {
                if (trav.data == null) {
                    return index;
                }
            }
        } else {
            for (; trav != null; trav = trav.next, index++) {
                if (elem.equals(trav.data)) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E elem) {
        return indexOf(elem) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public E next() {
                E data = trav.data;
                trav = trav.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<E> trav = head;
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    private E remove(Node<E> node) {
        if (node.prev == null) {
            return removeFirst();
        }
        if (node.next == null) {
            return removeLast();
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        E data = node.data;
        node.next = node.prev = null;
        size--;
        return data;
    }
}
