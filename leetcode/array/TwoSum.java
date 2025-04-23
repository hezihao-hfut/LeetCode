package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode 1: Two Sum
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 */
public class TwoSum {
    
    /**
     * 寻找数组中和为目标值的两个元素的下标
     * 
     * @param nums 整数数组
     * @param target 目标和
     * @return 和为 target 的两个元素的下标
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {0, 0};
    }
    
    /**
     * 测试 Two Sum 问题
     */
    public static void main(String[] args) {
        System.out.println("测试 Two Sum 问题：");
        TwoSum solution = new TwoSum();
        
        // 测试用例 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("输入: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("输出: " + Arrays.toString(result1));
        System.out.println("预期: [0, 1]");
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("输出: " + Arrays.toString(result2));
        System.out.println("预期: [1, 2]");
        System.out.println();
        
        // 测试用例 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("输入: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("输出: " + Arrays.toString(result3));
        System.out.println("预期: [0, 1]");
    }
}
