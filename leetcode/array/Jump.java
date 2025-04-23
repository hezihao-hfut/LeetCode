package leetcode.array;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个下标。
 */
public class Jump {
    
    /**
     * 计算到达最后一个下标所需的最小跳跃次数
     * 
     * @param nums 整数数组
     * @return 到达最后一个下标所需的最小跳跃次数
     */
    public int jump(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println("输入: nums = " + Arrays.toString(nums));
        System.out.println("输出: " + jump.jump(nums));
        System.out.println("预期: 2");
        System.out.println();

        int[] nums2 = { 2, 3, 0, 1, 4 };
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + jump.jump(nums2));
        System.out.println("预期: 2");
        System.out.println();
    }
}
