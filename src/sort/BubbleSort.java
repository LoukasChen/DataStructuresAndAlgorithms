package sort;

import java.util.Arrays;

import static sort.SortUtils.swap;

/**
 * @author csp
 * @description: 冒泡排序
 * @date 2019/7/6 15:04
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 8, 6, 1, 2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            boolean stopSortFlag = true;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    stopSortFlag = false;
                }
            }
            if (stopSortFlag) {
                break;
            }
        }
    }
}
