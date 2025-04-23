package leetcode.array;

import java.util.Arrays;

/**
 * LeetCode 35: Search Insert Position
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class SearchInsert {

    /**
     * 在排序数组中查找目标值的插入位置
     * 
     * @param nums   排序数组
     * @param target 目标值
     * @return 目标值的插入位置
     */
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target); // 返回插入位置
    }

    public int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) {
            return low;
        }
        int mid = (low + high) / 2;
        if (arr[mid] > target) {
            return binarySearch(arr, low, mid - 1, target);
        } else if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, high, target);
        } else {
            return mid;
        }
    }

    /**
     * 测试 Search Insert Position 问题
     */
    public static void main(String[] args) {
        System.out.println("测试 Search Insert Position 问题：");
        SearchInsert solution = new SearchInsert();

        // 测试用例 1
        int[] nums1 = { 1, 3, 5, 6 };
        int target1 = 5;
        System.out.println("输入: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        int result1 = solution.searchInsert(nums1, target1);
        System.out.println("输出: " + result1);
        System.out.println("预期: 2");
        System.out.println();

        // 测试用例 2
        int[] nums2 = { 1, 3, 5, 6 };
        int target2 = 2;
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        int result2 = solution.searchInsert(nums2, target2);
        System.out.println("输出: " + result2);
        System.out.println("预期: 1");
        System.out.println();

        // 测试用例 3
        int[] nums3 = { 1, 3, 5, 6 };
        int target3 = 7;
        System.out.println("输入: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        int result3 = solution.searchInsert(nums3, target3);
        System.out.println("输出: " + result3);
        System.out.println("预期: 4");
        System.out.println();
    }
}
