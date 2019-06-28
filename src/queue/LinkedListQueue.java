package queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenpeng_chen
 * @desc 链表实现队列
 * @date 2019/6/28
 */
public class LinkedListQueue {

    /**
     * 定义队头指针
     */
    private static Node head = null;
    /**
     * 定义队尾指针
     */
    private Node tail = null;

    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        List<String> strList = new ArrayList<>();
        strList.add("数组");
        strList.add("链表");
        strList.add("栈");
        strList.add("队列");
        strList.add("树");
        strList.forEach(v -> linkedListQueue.enQueue(v));
        strList.forEach(v -> System.out.println(linkedListQueue.deQueue()));
//        linkedListQueue.print(head);
    }

    /**
     * 入队列
     *
     * @param data
     */
    private void enQueue(String data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    /**
     * 出队列
     *
     * @return
     */
    private String deQueue() {
        if (head == null) {
            return null;
        } else {
            String node = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return node;
        }
    }

    private void print(Node node) {
        if (node == null) {
            System.out.println("队列为空");
            return;
        } else {
            while (node != null) {
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }
    }
}
