package queue;


import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @description: 数组实现循环队列
 * @date 2019/6/30 19:59
 */
public class CircularQueue {

    /**
     * 数组
     */
    private String[] items;
    /**
     * 数组大小
     */
    private int size = 0;
    /**
     * 队头下标
     */
    private int head = 0;
    /**
     * 队尾下标
     */
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.size = capacity;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        List<String> strList = new ArrayList<>();
        strList.add("数组");
        strList.add("链表");
        strList.add("栈");
        strList.add("队列");
        strList.add("树");
        strList.forEach(v -> circularQueue.enQueue(v));
        circularQueue.printAll();
    }

    /**
     * 入队列
     *
     * @param item
     * @return
     */
    private boolean enQueue(String item) {
        if ((tail + 1) % size == head) {
            return false;
        } else {
            items[tail] = item;
            tail = (tail + 1) % size;
            return true;
        }
    }

    /**
     * 出队列
     *
     * @return
     */
    private String deQueue() {
        if (head == tail) {
            return null;
        } else {
            String res = items[head];
            head = (head + 1) % size;
            return res;
        }
    }

    private void printAll() {
        if (head == tail) {
            return;
        } else {
            for (int i = head; i % size != tail; ++i) {
                System.out.println(items[i]);
            }
        }
    }
}
