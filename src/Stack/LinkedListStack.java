package Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @description: 栈的链式存储
 * @date 2019/6/17 20:47
 */
public class LinkedListStack {

    private Node head = null;

    public static void main(String[] args) {
        LinkedListStack listStack = new LinkedListStack();
        List<String> strList = new ArrayList<>();
        strList.add("数组");
        strList.add("链表");
        strList.add("栈");
        strList.add("队列");
        strList.add("树");
        strList.forEach(str -> listStack.push(str));
        for (int i = 0; i< 5 ;++i){
            System.out.println(listStack.pop());
        }
        System.out.println();
    }

    /**
     * 入栈操作
     * @param data
     * @return
     */
    private void push(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 出栈操作
     * @return
     */
    private String pop() {
        if (head == null) {
            return null;
        } else {
            String str;
            while (head != null) {
                str = head.data;
                head = head.next;
                return str;
            }
            return null;
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
