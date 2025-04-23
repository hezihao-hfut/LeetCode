package leetcode.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 */
public class MoveZeroes {

    /**
     * 使用双指针法，将非零元素移动到数组前面，然后剩下的位置补0。
     * 
     * @param nums 整数数组
     * @return 移动后的数组
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int slow = 0; // 指向下一个非零元素应该放置的位置
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                // 交换 nums[slow] 和 nums[fast]
                // 即使 slow == fast (即一开始就是非零元素) 交换也没关系
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++; // 移动慢指针
            }
            // 快指针始终移动
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] nums = { 0, 1, 0, 3, 12 };
        System.out.println("输入: nums = " + Arrays.toString(nums));
        solution.moveZeroes(nums);
        System.out.println("输出: " + Arrays.toString(nums));
        System.out.println("预期: [1, 3, 12, 0, 0]");
        System.out.println();

        int[] nums2 = { 0 };
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        solution.moveZeroes(nums2);
        System.out.println("输出: " + Arrays.toString(nums2));
        System.out.println("预期: [0]");
        System.out.println();

        int[] nums3 = { 1, 0, 1 };
        System.out.println("输入: nums = " + Arrays.toString(nums3));
        solution.moveZeroes(nums3);
        System.out.println("输出: " + Arrays.toString(nums3));
        System.out.println("预期: [1, 1, 0]");
    }
}
