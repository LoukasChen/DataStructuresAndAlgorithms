package sort;

import java.util.Arrays;

import static sort.SortUtils.swap;

/**
 * @author csp
 * @description: 插入排序
 * @date 2019/7/7 16:45
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 8, 3, 5};
        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 原始数组拆分成已排序和未排序数组
     * 未排序数组中找到比已排序数组小的元素插入到已排序数组
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

}
