package sort;

import java.util.Arrays;

/**
 * @author csp
 * @description: 冒泡排序
 * @date 2019/7/6 15:04
 */
public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {4, 3, 8, 6, 1, 2};
        bubbleSort.changeSort(arr);
    }

    private void changeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        } else {
            for (int i = 0; i < arr.length - 1; ++i) {
                // flag判断数组是否还需要排序
                boolean flag = false;
                for (int j = 0; j < arr.length - i - 1; ++j) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        flag = true;
                    }
                }
                System.out.print("第"+(i+1)+"次排序的数组为：");
                System.out.println(Arrays.toString(arr));
                if (!flag) {
                    break;
                }
            }
        }
    }
}
