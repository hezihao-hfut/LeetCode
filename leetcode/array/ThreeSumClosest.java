package leetcode.array;

import java.util.Arrays;

/**
 * LeetCode 16: 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在恰好一个解。
 */
public class ThreeSumClosest {

    /**
     * 三数之和最接近目标值
     * 
     * @param nums   整数数组
     * @param target 目标值
     * @return 最接近的三数之和
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // 排序数组
        int minDis = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int dis = sum - target;
                if (dis > 0) {
                    right--;
                } else if (dis < 0) {
                    left++;
                } else {
                    return target;
                }
                if (Math.abs(dis) < minDis) {
                    minSum = sum;
                    minDis = Math.abs(dis);
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;
        int result = threeSumClosest.threeSumClosest(nums, target);
        System.out.println("输入: " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("输出: " + result); // Output: 2
        System.out.println("预期: 2");
        System.out.println();

        int[] nums2 = { 0, 0, 0 };
        int target2 = 1;
        int result2 = threeSumClosest.threeSumClosest(nums2, target2);
        System.out.println("输入: " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("输出: " + result2);
        System.out.println("预期: 0");
        System.out.println();

        int[] nums3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        int target3 = 1;
        int result3 = threeSumClosest.threeSumClosest(nums3, target3);
        System.out.println("输入: " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("输出: " + result3);
        System.out.println("预期: 60");
        System.out.println();
    }
}
