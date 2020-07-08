package medo.datastructure.array;

/**
 * 数组。
 * 
 * @author bryce
 *
 * @param <T>
 */
public interface Array<T> extends Iterable<T> {

    public int size();

    public boolean isEmpty();

    public T get(int index);

    public void set(int index, T elem);

    public void clear();

    public void add(T elem);

    public T removeAt(int index);

    public boolean remove(T obj);

    public int indexOf(T elem);

    public boolean contains(T elem);

}
