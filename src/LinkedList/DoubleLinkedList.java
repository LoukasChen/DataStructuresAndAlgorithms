package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @description: 双向链表的基本操作
 * @date 2019/6/10 19:46
 */
public class DoubleLinkedList {

    private static Node head = null;

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        List<String> list = new ArrayList<>();
        list.add("数据结构");
        list.add("算法");
        list.add("计算机网络");
        list.add("操作系统");
        list.add("操作系统");
        list.forEach(value -> doubleLinkedList.insertAllNode(value));
        doubleLinkedList.printAllNode(head);
    }

    private void insertAllNode( String data) {
        if (data != null) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node tempNode = head;
                while (tempNode.next != null) {
                    tempNode = tempNode.next;
                }
                tempNode.next = newNode;
                newNode.prev = tempNode;
            }
        }
    }

    private void printAllNode(Node node) {
        if (node == null) {
            System.out.println("链表为空");
        } else {
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    class Node {
        /**
         * 数据域
         */
        private String data;
        /**
         * 前驱指针
         */
        private Node prev;
        /**
         * 后继指针
         */
        private Node next;

        public Node(String data) {
            this.data = data;
        }
    }
}
