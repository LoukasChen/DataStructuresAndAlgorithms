package sort;

import java.util.Arrays;

import static sort.SortUtils.swap;

/**
 * @author csp
 * @description: 选择排序
 * @date 2019/7/7 20:03
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 8, 3, 5};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 内层遍历找出最小的元素下标，与目标值交换
     * 第一遍：
     * 4 6 1 8 3 5
     * 1 6 4 8 3 5
     * 第二遍：
     * 6 4 8 3 5
     * 3 4 8 6 5
     * 第三遍：
     * 4 8 6 5
     * 4 8 6 5
     * 第四遍：
     * 8 6 5
     * 5 6 8
     * 第五遍：
     * 6 8
     * 6 8
     */
    private static void selectSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            // 假设当前索引为最小值的索引
            int minIndex = i;
            // 在未排序部分寻找最小值
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 如果找到的最小值不是当前元素，则交换它们
            if (i != minIndex) {
                swap(arr, i, minIndex);
            }
        }
    }

}
