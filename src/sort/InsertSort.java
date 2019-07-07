package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author csp
 * @description: 插入排序
 * @date 2019/7/7 16:45
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {4, 6, 1, 8, 3, 5};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = new Random().nextInt(80000);
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String start = dateFormat.format(date);
        System.out.println("开始时间:"+start);
        insertSort(arr);
        Date date1 = new Date();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
        String end = dateFormat1.format(date1);
        System.out.println("结束时间:"+end);
    }

    private static void insertSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        } else {
            for (int i = 1; i < arr.length; ++i) {
                int value = arr[i];
                int j = i - 1;
                for (; j >= 0; --j) {
                    if (arr[j] > value) {
                        arr[j + 1] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + 1] = value;
//                System.out.print("第" + i + "次排序的数组为：");
//                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
