package medo.datastructure.disjointset;

/**
 * 并查集 Union Find/Disjoint Set。 
 * 通过一个或者多个不相交的集合来跟踪元素，主要支持查找 find 和 合并 union。
 * 
 * @author bryce
 *
 */
public interface DisjointSet {

    int size();

    int find(int p);

    boolean connected(int p, int q);

    int groupSize(int p);

    int groups();

    void unify(int p, int q);
}
