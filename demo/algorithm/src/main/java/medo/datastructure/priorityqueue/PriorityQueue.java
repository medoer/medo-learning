package medo.datastructure.priorityqueue;

public interface PriorityQueue<E extends Comparable<E>> {

    int size();

    boolean isEmpty();

    void clear();

    E peek();

    // 移除堆顶元素
    E poll();

    boolean contains(E elem);

    void add(E elem);

    boolean remove(E elem);

    boolean isMinHeap(int k);

}
