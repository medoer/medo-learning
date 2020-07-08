package medo.datastructure.array;

import java.util.Iterator;

/**
 * 动态数组。
 * 
 * @author bryce
 *
 * @param <T>
 */
public class DynamicArray<T> implements Array<T> {

    private T[] innerArray;
    // 使用长度
    private int length;
    // 数组总长度，实际大小
    private int capacity;

    private static final int INIT_CAPACITY = 16;

    public DynamicArray() {
        this(INIT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        innerArray = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        return innerArray[index];
    }

    @Override
    public void set(int index, T elem) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        innerArray[index] = elem;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            innerArray[i] = null;
        }
        length = 0;
    }

    @Override
    public void add(T elem) {
        if (length + 1 >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < length; i++) {
                newArray[i] = innerArray[i];
            }
            innerArray = newArray;
        }
        innerArray[length] = elem;
        length++;
    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        T data = innerArray[index];
        for (int i = index + 1; i < length; i++) {
            innerArray[i - 1] = innerArray[i];
        }
        innerArray[length - 1] = null;
        length--;
        return data;
    }

    @Override
    public boolean remove(T obj) {
        int index = indexOf(obj);
        if (-1 == index) {
            return false;
        }
        removeAt(index);
        return true;
    }

    @Override
    public int indexOf(T elem) {
        for (int i = 0; i < length; i++) {
            if (elem == null) {
                if (innerArray[i] == null) {
                    return i;
                }
            } else if (elem.equals(innerArray[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T elem) {
        return indexOf(elem) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return innerArray[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (length == 0 ) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(length).append("[");
        for (int i = 0; i < length - 1; i++) {
            sb.append(innerArray[i]).append(",");
        }
        sb.append(innerArray[length - 1]).append("]");
        return sb.toString();
    }
}
