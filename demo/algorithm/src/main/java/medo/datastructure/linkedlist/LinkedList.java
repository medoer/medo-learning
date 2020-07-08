package medo.datastructure.linkedlist;

public interface LinkedList<E> extends Iterable<E>{

    public int size();
    
    public boolean isEmpty();
    
    public void clear();
    
    public void add(E elem);
    
    public void addLast(E elem);
    
    public void addFirst(E elem);
    
    public void addAt(int index, E elem);
    
    public E peekFirst();
    
    public E peekLast();
    
    public E removeFirst();
    
    public E removeLast();
    
    public boolean remove(E elem);
    
    public E removeAt(int index);
    
    public int indexOf(E elem);
    
    public boolean contains(E elem);
}
