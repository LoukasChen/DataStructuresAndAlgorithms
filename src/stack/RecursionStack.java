package stack;

/**
 * @author csp
 * @description: 栈的应用-递归
 * @date 2019/6/19 21:46
 */
public class RecursionStack {
    public static void main(String[] args) {
        for (int i = 1; i < 10; ++i) {
            System.out.println(RecursionStack.printTotal(i));
        }
        int[] arr = {1, 5, 7, 8, 23};
        System.out.println(RecursionStack.add(arr, 0));
    }

    /**
     * 利用递归实现斐波那契数列
     *
     * @param month 月份
     * @return
     */
    private static int printTotal(int month) {
        if (month <= 2) {
            return 1;
        } else {
            return printTotal(month - 2) + printTotal(month - 1);
        }
    }

    /**
     * 递归求数组各元素之和
     *
     * @param arr
     * @param index
     * @return
     */
    private static int add(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        } else {
            return arr[index] + add(arr, index + 1);
        }
    }

}


