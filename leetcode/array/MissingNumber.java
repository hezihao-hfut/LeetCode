package leetcode.array;

import java.util.Arrays;

/**
 * LeetCode 268. 丢失的数字
 * 给定一个包含 n 个整数的数组 nums，
 * 其中 nums[i] 在区间 [0, n] 内。
 * 请找出未出现在数组中的那个数。
 */
public class MissingNumber {

    /**
     * 使用数学公式计算总和，然后减去数组中所有元素的和，得到未出现的数字。
     * @param nums 数组
     * @return 未出现在数组中的那个数
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i : nums) {
            sum -= i;
        }
        return sum;
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int[] nums = { 3, 0, 1 };
        System.out.println("输入: nums = " + Arrays.toString(nums));
        System.out.println("输出: " + solution.missingNumber(nums));
        System.out.println("预期: 2");
        System.out.println();

        int[] nums2 = { 0, 1 };
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + solution.missingNumber(nums2));
        System.out.println("预期: 2");
        System.out.println();

        int[] nums3 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println("输入: nums = " + Arrays.toString(nums3));
        System.out.println("输出: " + solution.missingNumber(nums3));
        System.out.println("预期: 8");
        System.out.println();
    }
}
