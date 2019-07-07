package sort;

import java.util.Arrays;

/**
 * @author csp
 * @description: 选择排序
 * @date 2019/7/7 20:03
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 8, 3, 5};
        selectSort(arr);
    }

    private static void selectSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        } else {
            for (int i = 0; i < arr.length - 1; ++i) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; ++j) {
                    if (arr[j] < arr[minIndex]) {
                        // 找出最小值下标
                        minIndex = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                System.out.print("第" + (i + 1) + "次排序的数组为：");
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
