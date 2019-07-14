package tree;

/**
 * @author csp
 * @description: 二叉搜索树
 * @date 2019/7/13 21:23
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(12);
        System.out.println(binarySearchTree.find(root, 5));
        binarySearchTree.insert(root, 2);
        System.out.println("---------------");
        binarySearchTree.inOrder(root);
        System.out.println();
    }

    public Node find(Node node, int data) {
        while (node != null) {
            if (data == node.data) {
                return node;
            } else if (data < node.data) {
                node = node.left;
            } else if (data > node.data) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public void insert(Node node, int data) {
        Node newNode = new Node(data);
        if (node == null) {
            return;
        }
        while (node != null) {
            if (data > node.data) {
                if (node.right == null) {
                    node.right = newNode;
                    return;
                } else {
                    node = node.right;
                }
            } else {
                if (node.left == null) {
                    node.left = newNode;
                    return;
                } else {
                    node = node.left;
                }
            }
        }
    }

    public void delete(Node node, int data) {
        if (node == null) {
            return;
        } else {
            while (node != null) {
                if ((node.left.data == data)) {
                    node.left = null;
                } else if (node.right.data == data) {
                    node.right = null;
                } else {
                    return;
                }
            }
        }
    }

    public void inOrder(Node node) {
        node.inOrder(node);
    }

    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        /**
         * 中序遍历打印二叉排序树
         *
         * @param node
         */
        public void inOrder(Node node) {
            if (node.left != null) {
                inOrder(node.left);
            }
            System.out.println(node);
            if (node.right != null) {
                inOrder(node.right);
            }
        }
    }

}

