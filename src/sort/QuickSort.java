package sort;

import java.util.Arrays;

/**
 * @author shenpeng_chen
 * @desc 快速排序
 * @date 2019/8/21
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 8, 6, 1, 2};
        QuickSort.quickSortInternally(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序递归函数
     *
     * @param arr 数组
     * @param p   数组下标
     * @param r   数组下标
     */
    private static void quickSortInternally(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        // 获取分区点
        int q = partition(arr, p, r);
        quickSortInternally(arr, p, q - 1);
        quickSortInternally(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        // pivot为基准值
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (arr[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
        System.out.println("i=" + i);
        return i;
    }
}
