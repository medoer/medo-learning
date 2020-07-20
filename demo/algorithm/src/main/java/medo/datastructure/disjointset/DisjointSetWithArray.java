package medo.datastructure.disjointset;

/**
 * 基于数组的并查集。
 * 
 * @author bryce
 *
 */
public class DisjointSetWithArray implements DisjointSet {

    // 元素个数
    private int size;
    // 每个组的长度
    private int[] groupSize;
    // 数组值，即父节点下标
    private int[] id;
    // 组个数
    private int groups;

    public DisjointSetWithArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        this.groups = size;
        groupSize = new int[size];
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            groupSize[i] = 1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    // 查找下标 p 属于哪个组，平摊常量复杂度
    @Override
    public int find(int p) {
        int root = p;
        // 查找 p 的根
        while (root != id[root]) {
            root = id[root];
        }
        // 路径压缩
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int groupSize(int p) {
        int root = find(p);
        return groupSize[root];
    }

    @Override
    public int groups() {
        return groups;
    }

    @Override
    public void unify(int p, int q) {
        if (connected(p, q)) {
            return;
        }
        int root1 = find(p);
        int root2 = find(q);
        if (groupSize[root1] < groupSize[root2]) {
            groupSize[root2] += groupSize[root1];
            id[root1] = root2;
        } else {
            groupSize[root1] += groupSize[root2];
            id[root2] = root1;
        }
        groups--;
    }

}
