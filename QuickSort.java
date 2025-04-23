// QuickSort.java
public class QuickSort {

    // 辅助方法：交换数组中的两个元素
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // A utility function to print array
    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 从两端向中间遍历的分区方法
    static int partition(int[] arr, int low, int high) {
        // 选择中间元素作为枢轴
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];

        // 将枢轴移到最右边
        swap(arr, mid, high);
        int left = low;
        int right = high - 1;

        while (left <= right) {
            // 从左向右找到大于或等于枢轴的元素
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            // 从右向左找到小于或等于枢轴的元素
            while (left <= right && arr[right] > pivot) {
                right--;
            }

            // 如果左指针仍然不大于右指针，交换元素
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        // 将枢轴放到正确的位置
        swap(arr, left, high);
        return left;
    }

    // The main function that implements QuickSort
    static void quickSort(int[] arr, int low, int high) {
        System.out.println("Sorting between indices " + low + " and " + high);
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);
            printArray(arr); // Print array after partitioning

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 1, 2, 9, 1, 5 };
        System.out.println("Original array:");
        printArray(arr);

        System.out.println("Sorting process:");
        // Call the quickSort method to sort the array
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

}

/*
 * 1 4 1 2 9 1 5
 * 
 * 1 4 1 5 9 1 2
 * 1 1 1 5 9 4 2
 * 1 1 1 2 9 4 5
 * 
 * 1 1 1 2 9 5 4
 * 1 1 1 2 4 5 9
 * 
 */
