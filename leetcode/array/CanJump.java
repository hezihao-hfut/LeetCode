package leetcode.array;

import java.util.Arrays;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class CanJump {

    /**
     * 判断是否能够跳跃到最后一个下标
     * 
     * @param nums 整数数组
     * @return 如果可以跳跃到最后一个下标，返回 true；否则返回 false
     */
    public boolean canJump(int[] nums) {
        int max_step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max_step) {
                max_step = Math.max(max_step, i + nums[i]);
                if (max_step >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println("输入: nums = " + Arrays.toString(nums));
        System.out.println("输出: " + canJump.canJump(nums));
        System.out.println("预期: true");
        System.out.println();

        int[] nums2 = { 3, 2, 1, 0, 4 };
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + canJump.canJump(nums2));
        System.out.println("预期: false");
        System.out.println();

        int[] nums3 = { 0 };
        System.out.println("输入: nums = " + Arrays.toString(nums3));
        System.out.println("输出: " + canJump.canJump(nums3));
        System.out.println("预期: true");
        System.out.println();
    }
}
