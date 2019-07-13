package tree;

/**
 * @author csp
 * @description: 二叉搜索树
 * @date 2019/7/13 21:23
 */
public class BinarySearchTree {

    private Node node;

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(12);
        System.out.println(binarySearchTree.find(root, 5));
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
    }

}

