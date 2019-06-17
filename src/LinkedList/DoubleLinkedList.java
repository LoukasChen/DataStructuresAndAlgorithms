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
        doubleLinkedList.insertAfterNode("算法", "计算组成原理");
        doubleLinkedList.deleteAfterNode("计算组成原理");
        doubleLinkedList.printAllNode(head);
    }

    /**
     * 尾插法
     *
     * @param data
     */
    private void insertAllNode(String data) {
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

    /**
     * 将数据插入到指定位置之后
     *
     * @param selectData 要插入的位置
     * @param data       要插入的数据
     */
    private void insertAfterNode(String selectData, String data) {
        if (data != null && selectData != null) {
            Node tempNode = head;
            while (!selectData.equals(tempNode.data)) {
                tempNode = tempNode.next;
            }
            Node newNode = new Node(data);
            newNode.next = tempNode.next;
            newNode.prev = tempNode;
            tempNode.next.prev = newNode;
            tempNode.next = newNode;
        }
    }

    /**
     * 删除指定节点(双向链表可自我删除)
     *
     * @param selectData 要删除的位置
     */
    private void deleteAfterNode(String selectData) {
        if (selectData != null) {
            Node tempNode = head;
            while (!selectData.equals(tempNode.data)) {
                tempNode = tempNode.next;
            }
            tempNode.prev.next = tempNode.next;
            tempNode.next.prev = tempNode.prev;
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
