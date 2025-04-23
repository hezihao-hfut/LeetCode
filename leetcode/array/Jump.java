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
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int jumps = 0; // 跳跃次数
        int currentEnd = 0; // 当前跳跃的结束位置
        int farthest = 0; // 当前跳跃能到达的最远位置
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新当前跳跃能到达的最远位置
            farthest = Math.max(farthest, i + nums[i]);
            // 如果到达当前跳跃的结束位置，则需要增加跳跃次数
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest; // 更新当前跳跃的结束位置
            }
        }
        return jumps;
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

        int[] nums3 = { 5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5 };
        System.out.println("输入: nums = " + Arrays.toString(nums3));
        System.out.println("输出: " + jump.jump(nums3));
        System.out.println("预期: 5");
        System.out.println();
    }
}
