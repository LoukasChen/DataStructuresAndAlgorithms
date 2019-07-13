package tree;

/**
 * @author csp
 * @description: 二叉树的前中后序遍历
 * @date 2019/7/13 17:38
 */
public class BinaryTree {

    public static void main(String[] args) {
        BinaryTreeDemo binaryTree = new BinaryTreeDemo();
        Node root = new Node("1");
        root.left = new Node("2");
        root.right = new Node("3");
        root.left.left = new Node("4");
        root.left.right = new Node("5");
        root.right.right = new Node("6");
        binaryTree.root = root;
        System.out.println("前序遍历：");
        binaryTree.preOrder();
        System.out.println("中序遍历：");
        binaryTree.inOrder();
        System.out.println("后序遍历：");
        binaryTree.postOrder();
        System.out.println("------------");
        System.out.println(binaryTree.preOrderSearch("3"));
        System.out.println(binaryTree.inOrderSearch("3"));
        System.out.println(binaryTree.postOrderSearch("4"));
    }
}

class BinaryTreeDemo {

    public Node root;

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void inOrder() {
        if (this.root != null) {
            this.root.inOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public Node preOrderSearch(String data) {
        if (this.root != null) {
            return this.root.preOrderSearch(data);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    public Node inOrderSearch(String data) {
        if (this.root != null) {
            return this.root.inOrderSearch(data);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    public Node postOrderSearch(String data) {
        if (this.root != null) {
            return this.root.postOrderSearch(data);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }
}

class Node {
    public String data;
    public Node left;
    public Node right;

    public Node(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if (this.left != null) {
            this.left.inOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找值为data的节点
     *
     * @param data
     * @return
     */
    public Node preOrderSearch(String data) {
        System.out.println("进入前序遍历");
        if (data.equals(this.data)) {
            return this;
        }
        Node node = null;
        if (this.left != null) {
            node = this.left.preOrderSearch(data);
        }
        if (node != null) {
            return node;
        }
        if (this.right != null) {
            node = this.right.preOrderSearch(data);
        }
        return node;
    }

    /**
     * 中序遍历查找值为data的节点
     *
     * @param data
     * @return
     */
    public Node inOrderSearch(String data) {
        Node node = null;
        if (this.left != null) {
            node = this.left.inOrderSearch(data);
        }
        if (node != null) {
            return node;
        }
        System.out.println("进入中序遍历");
        if (data.equals(this.data)) {
            return this;
        }
        if (this.right != null) {
            node = this.right.inOrderSearch(data);
        }
        return node;
    }

    /**
     * 后序遍历查找值为data的节点
     *
     * @param data
     * @return
     */
    public Node postOrderSearch(String data) {
        Node node = null;
        if (this.left != null) {
            node = this.left.postOrderSearch(data);
        }
        if (node != null) {
            return node;
        }
        if (this.right != null) {
            node = this.right.postOrderSearch(data);
        }
        if (node != null) {
            return node;
        }
        System.out.println("进入后序遍历");
        if (data.equals(this.data)) {
            return this;
        }
        return node;
    }
}
