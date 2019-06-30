package queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @description: 数组实现队列
 * @date 2019/6/27 20:19
 */
public class ArrayQueue {

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

    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.size = capacity;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        List<String> strList = new ArrayList<>();
        strList.add("数组");
        strList.add("链表");
        strList.add("栈");
        strList.add("队列");
        strList.add("树");
        strList.forEach(v -> arrayQueue.enQueue(v));
        arrayQueue.deQueue();
        arrayQueue.deQueue();
        arrayQueue.enQueue("图");
    }

    /**
     * 入队列
     *
     * @param item
     * @return
     */
    private boolean enQueue(String item) {
        // 队列已满
        if (tail == size) {
            // head=0表示队列没有空闲的空间
            if (head == 0) {
                return false;
            } else {
                // 数据搬移
                for (int i = head; i < tail; ++i) {
                    items[i - head] = items[i];
                }
                // 更新tail和head的位置
                tail -= head;
                head = 0;
            }
        }
        items[tail++] = item;
        return true;
    }

    /**
     * 出队列
     *
     * @return
     */
    private String deQueue() {
        // 队列为空
        if (tail == head) {
            return null;
        } else {
            String res = items[head++];
            return res;
        }
    }

    private void printQueue() {
        for (String item : items) {
            System.out.println(item);
        }
    }
}
