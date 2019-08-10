package search;

/**
 * @author csp
 * @description: 二分查找
 * @date 2019/8/10 11:13
 */
public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {1, 3, 5, 6, 9, 9, 9, 67, 87, 123, 156};
//        int index = bs.binarySearch(arr, 87);
//        int index = bs.binarySearchRecurse(arr, 9, 0, arr.length - 1);
//        int index = bs.binarySearchFirst(arr, 9);
//        int index = bs.binarySearchLast(arr, 9);
//        int index = bs.binarySearchFirstThan(arr, 7);
        int index = bs.binarySearchLastThan(arr, 9);
        System.out.println("查找为第" + index + "位置");
    }

    /**
     * 循环方式实现二分查找
     *
     * @param arr   目标数组
     * @param value 目标查找值
     * @return
     */
    private int binarySearch(int[] arr, int value) {
        if (arr.length <= 0) {
            return -1;
        } else {
            int min = 0;
            int max = arr.length - 1;
            while (min <= max) {
                int mid = (min + max) / 2;
                if (value == arr[mid]) {
                    return mid;
                } else if (value > arr[mid]) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
            return -1;
        }
    }

    /**
     * 递归方式实现二分查找
     *
     * @param arr   目标数组
     * @param value 目标查找值
     * @param min   最小索引
     * @param max   最大索引
     * @return
     */
    private int binarySearchRecurse(int[] arr, int value, int min, int max) {
        if (arr.length <= 0 || min > max) {
            return -1;
        } else {
            int mid = (min + max) / 2;
            if (value == arr[mid]) {
                return mid;
            } else if (value > arr[mid]) {
                return binarySearchRecurse(arr, value, mid + 1, max);
            } else {
                return binarySearchRecurse(arr, value, min, mid - 1);
            }
        }
    }

    /**
     * 查找第一个值等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    private int binarySearchFirst(int[] arr, int value) {
        if (arr.length <= 0) {
            return -1;
        } else {
            int min = 0;
            int max = arr.length - 1;
            while (min <= max) {
                int mid = (min + max) / 2;
                if (value > arr[mid]) {
                    min = mid + 1;
                } else if (value < arr[mid]) {
                    max = mid - 1;
                } else {
                    if ((mid == 0) || (arr[mid - 1] != value)) {
                        return mid;
                    } else {
                        max = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    private int binarySearchLast(int[] arr, int value) {
        if (arr.length <= 0) {
            return -1;
        } else {
            int min = 0;
            int max = arr.length - 1;
            while (min <= max) {
                int mid = (min + max) / 2;
                if (value > arr[mid]) {
                    min = mid + 1;
                } else if (value < arr[mid]) {
                    max = mid - 1;
                } else {
                    if ((mid == 0) || (arr[mid + 1] != value)) {
                        return mid;
                    } else {
                        min = mid + 1;
                    }
                }
            }
            return -1;
        }
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    private int binarySearchFirstThan(int[] arr, int value) {
        if (arr.length <= 0) {
            return -1;
        } else {
            int min = 0;
            int max = arr.length - 1;
            while (min <= max) {
                int mid = min + ((max - min) >> 1);
                if (value <= arr[mid]) {
                    if ((mid == 0) || (arr[mid - 1] < value)) {
                        return mid;
                    } else {
                        max = mid - 1;
                    }
                } else {
                    min = mid + 1;
                }
            }
            return -1;
        }
    }

    /**
     * 查找最一个小于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    private int binarySearchLastThan(int[] arr, int value) {
        if (arr.length <= 0) {
            return -1;
        } else {
            int min = 0;
            int max = arr.length - 1;
            while (min <= max) {
                int mid = min + ((max - min) >> 1);
                if (value >= arr[mid]) {
                    if ((mid == 0) || (arr[mid + 1] > value)) {
                        return mid;
                    } else {
                        min = mid + 1;
                    }
                } else {
                    max = mid - 1;
                }
            }
            return -1;
        }
    }
}
