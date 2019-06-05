package Array;

import java.util.Arrays;

/**
 * @author csp
 * @description: 实现数组的增删改查
 * @date 2019/6/5 20:54
 */
public class ArrayDemo {
    public static void main(String[] args) {
        ArrayDemo array = new ArrayDemo();
        int[] num = {4, 5, 2, 76, 45, 9, 23};
        int[] nums = Arrays.copyOf(num, num.length + 1);
        boolean flag = array.insertArrayByIndex(nums, 3, 15);
        if (flag) {
            for (int i : nums) {
                System.out.print(i + ",");
            }
        }
        flag = array.deleteArrayByIndex(nums, 2);
        if (flag) {
            System.out.println();
            for (int i : nums) {
                System.out.print(i + ",");
            }
        }
    }

    /**
     * 将数值插入到数组的某个位置
     *
     * @param num   传入的数组
     * @param index 插入的位置
     * @param args  插入的值
     * @return
     */
    private boolean insertArrayByIndex(int[] num, int index, int args) {
        if (num != null) {
            if (index < 0 || index >= num.length) {
                return false;
            } else {
                for (int count = num.length - 1; count > index - 1; --count) {
                    num[count] = num[count - 1];
                }
                num[index - 1] = args;
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * 删除数组指定位置的数据
     *
     * @param num   传入的数组
     * @param index 删除的位置
     * @return
     */
    private boolean deleteArrayByIndex(int[] num, int index) {
        if (num != null) {
            if (index < 0 || index >= num.length) {
                return false;
            } else {
                for (int count = index; count < num.length; ++count) {
                    num[count - 1] = num[count];
                }
                // 将最后一位置为0
                num[num.length - 1] = 0;
                return true;
            }
        } else {
            return false;
        }
    }
}
