package leetcode.array;

import java.util.Arrays;

/**
 * LeetCode 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class SearchRange {

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * 
     * @param nums   排序数组
     * @param target 目标值
     * @return 目标值的开始位置和结束位置
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // 查找左边界
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1; // 继续向左寻找
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // 检查是否找到左边界
        if (left < nums.length && nums[left] == target) {
            result[0] = left;
        } else {
            return result; // 没找到目标值，直接返回[-1, -1]
        }
        
        // 查找右边界
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 继续向右寻找
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        result[1] = right;
        
        return result;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println("输入: nums = " + Arrays.toString(nums) + ", target = " + target);
        int[] result = searchRange.searchRange(nums, target);
        System.out.println("输出: [" + result[0] + ", " + result[1] + "]");
        System.out.println("预期: [3, 4]");
        System.out.println();

        int[] nums2 = {1};
        int target2 = 0;
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        int[] result2 = searchRange.searchRange(nums2, target2);
        System.out.println("输出: [" + result2[0] + ", " + result2[1] + "]");
        System.out.println("预期: [-1, -1]");
        System.out.println();

        int[] nums3 = {2, 2};
        int target3 = 2;
        System.out.println("输入: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        int[] result3 = searchRange.searchRange(nums3, target3);
        System.out.println("输出: [" + result3[0] + ", " + result3[1] + "]");
        System.out.println("预期: [0, 1]");
        System.out.println();

        int[] nums4 = {5, 7, 7, 8, 8, 10};
        int target4 = 6;
        System.out.println("输入: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        int[] result4 = searchRange.searchRange(nums4, target4);
        System.out.println("输出: [" + result4[0] + ", " + result4[1] + "]");
        System.out.println("预期: [-1, -1]");
        System.out.println();

        int[] nums5 = {};
        int target5 = 0;
        System.out.println("输入: nums = " + Arrays.toString(nums5) + ", target = " + target5);
        int[] result5 = searchRange.searchRange(nums5, target5);
        System.out.println("输出: [" + result5[0] + ", " + result5[1] + "]");
        System.out.println("预期: [-1, -1]");
        System.out.println();
    }
}
