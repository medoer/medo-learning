package medo.datastructure.binarysearchtree;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉搜索树。
 * 
 * @author: bryce
 * @date: 2020-08-05
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {

    private int size;
    private Node<T> root = null;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T elem) {
        if (contains(elem)) {
            return false;
        }
        root = add(root, elem);
        size++;
        return true;
    }

    @Override
    public boolean remove(T elem) {
        if (contains(elem)) {
            root = remove(root, elem);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T elem) {
        return contains(root, elem);
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public Iterator<T> traverse(TreeTraversalOrder order) {
        switch (order) {
        case PRE_ORDER:
            return preOrderTraversal();
        case IN_ORDER:
            return inOrderTraversal();
        case POST_ORDER:
            return postOrderTraversal();
        case LEVEL_ORDER:
            return levelOrderTraversal();
        default:
            return null;
        }
    }

    // 在二叉搜索树中递归添加一个值
    private Node<T> add(Node<T> node, T elem) {
        if (node == null) {
            node = new Node<T>(null, null, elem);
        } else {
            int cmp = elem.compareTo(node.data);
            if (cmp < 0) {
                node.left = add(node.left, elem);
            } else if (cmp > 0) {
                node.right = add(node.right, elem);
            }
            // 相等不处理
        }
        return node;
    }

    private boolean contains(Node<T> node, T elem) {
        if (node == null) {
            return false;
        }
        int cmp = elem.compareTo(node.data);
        if (cmp < 0) {
            return contains(node.left, elem);
        } else if (cmp > 0) {
            return contains(node.right, elem);
        }
        return true;
    }

    private Node<T> remove(Node<T> node, T elem) {
        if (node == null) {
            return null;
        }
        int cmp = elem.compareTo(node.data);
        if (cmp < 0) {
            node.left = remove(node.left, elem);
        } else if (cmp > 0) {
            node.right = remove(node.right, elem);
        } else {
            if (node.left == null) {
                Node<T> rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;
            } else if (node.right == null) {
                Node<T> leftChild = node.left;
                node.data = null;
                node = null;
                return leftChild;
            } else {
                // 左子树最大节点做为后继节点
                Node<T> temp = findMax(node.left);
                node.data = temp.data;
                node.left = remove(node.left, temp.data);
            }
        }
        return node;
    }

    private Node<T> findMin(Node<T> node) {
        Node<T> temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    private Node<T> findMax(Node<T> node) {
        Node<T> temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private Iterator<T> preOrderTraversal() {
        // 不可修改，并发检查
        final int expectedNodeCount = size;
        final Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != size) {
                    throw new ConcurrentModificationException();
                }
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != size) {
                    throw new ConcurrentModificationException();
                }
                Node<T> node = stack.pop();
                // stack 先进后出，前序遍历先 push 右子树
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                return node.data;
            }
        };
    }

    private Iterator<T> inOrderTraversal() {
        // 不可修改，并发检查
        final int expectedNodeCount = size;
        final Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        return new Iterator<T>() {

            Node<T> trav = root;

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != size) {
                    throw new ConcurrentModificationException();
                }
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != size) {
                    throw new ConcurrentModificationException();
                }
                while (trav != null && trav.left != null) {
                    stack.push(trav.left);
                    trav = trav.left;
                }
                Node<T> node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                    trav = node.right;
                }
                return node.data;
            }
        };
    }

    private Iterator<T> postOrderTraversal() {
        // 不可修改，并发检查
        final int expectedNodeCount = size;
        final Stack<Node<T>> stack1 = new Stack<>();
        stack1.push(root);
        // 维护最终遍历顺序
        final Stack<Node<T>> stack2 = new Stack<>();

        while (!stack1.isEmpty()) {
            Node<T> node = stack1.pop();
            if (node != null) {
                stack2.push(node);
                if (node.left != null) {
                    stack1.push(node.left);
                }
                if (node.right != null) {
                    stack1.push(node.right);
                }
            }
        }
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != size) {
                    throw new ConcurrentModificationException();
                }
                return root != null && !stack2.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != size) {
                    throw new ConcurrentModificationException();
                }
                return stack2.pop().data;
            }
        };
    }

    private Iterator<T> levelOrderTraversal() {
        final int expectedNodeCount = size;
        final Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (expectedNodeCount != size) {
                    throw new ConcurrentModificationException();
                }
                return root != null && !queue.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != size) {
                    throw new ConcurrentModificationException();
                }
                Node<T> node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                return node.data;
            }
        };
    }
}
