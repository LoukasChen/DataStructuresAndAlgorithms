package Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @description: 栈的数组存储
 * @date 2019/6/16 19:43
 */
public class ArrayStack {
    /**
     * 数组
     */
    private String[] items;
    /**
     * 栈中元素的个数
     */
    private int count;
    /**
     * 栈空间
     */
    private int size;

    public ArrayStack(int size) {
        this.items = new String[size];
        this.count = 0;
        this.size = size;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        List<String> strList = new ArrayList<>();
        strList.add("数组");
        strList.add("链表");
        strList.add("栈");
        strList.add("队列");
        strList.add("树");
        strList.forEach(str -> arrayStack.push(str));
        for (int i = 0; i< 5 ;++i){
            System.out.println(arrayStack.pop());
        }
        System.out.println();
    }

    /**
     * 入栈操作
     *
     * @param item
     * @return
     */
    private boolean push(String item) {
        // 数组空间不足则入栈失败
        if (count >= size) {
            return false;
        } else {
            items[count++] = item;
            return true;
        }
    }

    /**
     * 出栈操作
     *
     * @return temp 返回下标减1的元素
     */
    private String pop() {
        if (count == 0) {
            return null;
        } else {
            String temp = items[count - 1];
            --count;
            return temp;
        }
    }
}
