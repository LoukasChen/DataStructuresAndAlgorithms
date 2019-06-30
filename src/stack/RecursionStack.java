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
}


