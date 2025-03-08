package sort;

/**
 * @desc:
 * @author: csp
 * @date: 2025/3/8
 */
public interface SortUtils {

    static void swap(int[] arr, int a, int b) {
        // 引入第三个变量来交换两数
//        int temp = arr[b];
//        arr[b] = arr[a];
//        arr[a] = temp;
        // 不使用第三个变量，使用异或来交换两数
        // 0和任何数异或为本身，两个数异或为0，异或满足交换律和结合律
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

}
