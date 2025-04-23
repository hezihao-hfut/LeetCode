package leetcode.array;

import java.util.Arrays;

/**
 * LeetCode 26: Remove Duplicates from Sorted Array
 * 给定一个排序数组，你需要在原地删除重复元素，使得每个元素只出现一次，并返回新的长度。
 */
public class RemoveDuplicates {
    
    /**
     * 删除排序数组中的重复元素
     * 
     * @param nums 排序数组
     * @return 新的长度
     */
    public int removeDuplicates(int[] nums) {
        int s = 0; // 慢指针
        for (int f = 1; f < nums.length; f++) {
            if (nums[f] != nums[s]) { // 快指针与慢指针的值不相等
                s++; // 慢指针向前移动
                nums[s] = nums[f]; // 将快指针的值赋给慢指针
            }
        }
        return s + 1; // 返回新的长度
    }
    
    /**
     * 测试 Remove Duplicates 问题
     */
    public static void main(String[] args) {
        System.out.println("测试 Remove Duplicates 问题：");
        RemoveDuplicates solution = new RemoveDuplicates();
        
        // 测试用例 1.
        
        int[] nums1 = {1, 1, 2};
        System.out.println("输入: nums = " + Arrays.toString(nums1));
        int newLength1 = solution.removeDuplicates(nums1);
        System.out.println("输出: " + newLength1);
        System.out.println("预期: 2");
        System.out.println("修改后的数组: " + Arrays.toString(Arrays.copyOf(nums1, newLength1)));
        System.out.println();

        // 测试用例 2
        int[] nums2 = {0, 0, 1, 1, 2, 2, 3, 4};
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        int newLength2 = solution.removeDuplicates(nums2);
        System.out.println("输出: " + newLength2);
        System.out.println("预期: 5");
        System.out.println("修改后的数组: " + Arrays.toString(Arrays.copyOf(nums2, newLength2)));
        System.out.println();
    }
}
