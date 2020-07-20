package medo.datastructure.priorityqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 基于 ArrayList 实现二叉堆，使用 HashMap 优化移除 Removal 操作。
 * 
 * @author bryce
 *
 * @param <E>
 */
public class BinaryHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    private List<E> heapList = null;
    private Map<E, TreeSet<Integer>> map = new HashMap<>();

    public BinaryHeap() {
        this(1);
    }

    public BinaryHeap(int size) {
        this.heapList = new ArrayList<>(size);
    }

    public BinaryHeap(E[] elems) {
        this(elems.length);
        int heapSize = elems.length;
        for (int i = 0; i < heapSize; i++) {
            mapAdd(elems[i], i);
            heapList.add(elems[i]);
        }
        // 折半查找
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
            sink(i);
        }
    }

    public BinaryHeap(Collection<E> elems) {
        this(elems.size());
        for (E e : elems) {
            add(e);
        }
    }

    @Override
    public int size() {
        return heapList.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        heapList.clear();
        map.clear();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return heapList.get(0);
    }

    @Override
    public E poll() {
        return removeAt(0);
    }

    @Override
    public boolean contains(E elem) {
        if (elem == null) {
            return false;
        }
        return map.containsKey(elem);
    }

    @Override
    public void add(E elem) {
        if (elem == null) {
            throw new IllegalArgumentException();
        }
        heapList.add(elem);
        int indexOfLastElem = size() - 1;
        mapAdd(elem, indexOfLastElem);
        swim(indexOfLastElem);
    }

    @Override
    public boolean remove(E elem) {
        if (elem == null) {
            return false;
        }
        Integer index = mapGet(elem);
        if (index != null) {
            removeAt(index);
        }
        return index != null;
    }

    @Override
    public boolean isMinHeap(int k) {
        int heapSize = size();
        if (k >= heapSize) {
            return true;
        }
        int leftChild = 2 * k + 1;
        int rightChild = 2 * k + 2;
        if (leftChild < heapSize && !less(k, leftChild)) {
            return false;
        }
        if (rightChild < heapSize && !less(k, rightChild)) {
            return false;
        }
        return isMinHeap(leftChild) && isMinHeap(rightChild);
    }

    private boolean less(int i, int j) {
        E elemI = heapList.get(i);
        E elemJ = heapList.get(j);
        return elemI.compareTo(elemJ) <= 0;
    }

    // 将节点值和它的索引添加到 map 中
    private void mapAdd(E elem, int index) {
        TreeSet<Integer> treeSet = map.get(elem);
        if (treeSet == null) {
            treeSet = new TreeSet<>();
            treeSet.add(index);
            map.put(elem, treeSet);
        } else {
            treeSet.add(index);
        }
    }

    private void mapRemove(E elem, int index) {
        TreeSet<Integer> treeSet = map.get(elem);
        if (treeSet == null) {
            throw new NullPointerException();
        }
        treeSet.remove(index);
        if (treeSet.isEmpty()) {
            map.remove(elem);
        }
    }

    private Integer mapGet(E elem) {
        TreeSet<Integer> treeSet = map.get(elem);
        if (treeSet == null) {
            return null;
        }
        return treeSet.last();
    }

    private void mapSwap(E elem1, E elem2, int index1, int index2) {
        TreeSet<Integer> treeSet1 = map.get(elem1);
        TreeSet<Integer> treeSet2 = map.get(elem2);
        treeSet1.remove(index1);
        treeSet2.remove(index2);
        treeSet1.add(index2);
        treeSet2.add(index1);
    }

    @Override
    public String toString() {
        return heapList.toString();
    }
    
    private void swap(int i, int j) {
        E eI = heapList.get(i);
        E eJ = heapList.get(j);
        heapList.set(j, eI);
        heapList.set(i, eJ);
        mapSwap(eI, eJ, i, j);
    }

    private void swim(int k) {
        int parent = (k - 1) / 2;
        while (k > 0 && less(k, parent)) {
            swap(k, parent);
            k = parent;
            parent = (k - 1) / 2;
        }
    }
    
    private void sink(int k) {
        int heapSize = size();
        while (true) {
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;
            if (right < heapSize && less(right, left)) {
                smallest = right;
            }
            if (left >= heapSize || less(k, smallest)) {
                break;
            }
            swap(smallest, k);
            k = smallest;
        }
    }
    
    private E removeAt(int i) {
        if (isEmpty()) {
//            throw new IndexOutOfBoundsException();
            return null;
        }
        int indexOfLastElem = size() - 1;
        E e = heapList.get(i);
        swap(i, indexOfLastElem);
        heapList.remove(indexOfLastElem);
        mapRemove(e, indexOfLastElem);
        if (i == indexOfLastElem) {
            return e;
        }
        E e2 = heapList.get(i);
        sink(i);
        if (heapList.get(i).equals(e2)) {
            swim(i);
        }
        return e;
    }
}
