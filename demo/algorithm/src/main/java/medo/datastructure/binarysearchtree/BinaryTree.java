package medo.datastructure.binarysearchtree;

public interface BinaryTree<T extends Comparable<T>> {

    // 内部节点定义，包含数据和引用
    class Node<T> {
        T data;
        Node<T> left, right;

        public Node(Node<T> left, Node<T> right, T elem) {
            this.data = elem;
            this.left = left;
            this.right = right;
        }
    }

    // 检查二叉搜索树是否为空
    boolean isEmpty();

    // 获取二叉搜索树中节点的数量
    int size();

    // 向二叉搜索树中添加一个元素，如果成功执行添加就返回true
    boolean add(T elem);

    // 从二叉搜索树中移除一个元素，如果存在的话，复杂度：O(n)
    boolean remove(T elem);

    // 如果元素存在于树中，就返回true，否则返回false
    boolean contains(T elem);

    // 计算树的高度，O(n)
    int height();

    // 返回特定遍历顺序的的迭代器，
    // 支持先序(preorder)，中序(inorder)，后序(postorder)和按层次遍历(levelorder)
    java.util.Iterator<T> traverse(TreeTraversalOrder order);
}
