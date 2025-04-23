package leetcode.array;

import java.util.Arrays;

/*
 * LeetCode 31: 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 */
public class NextPermutation {

    /**
     * 从后往前找第一个比后面大的数，然后交换，然后反转后面的数
     * 
     * @param nums 整数数组
     * @return 下一个排列
     */
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        reverse(nums, i + 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = { 1, 3, 2 };
        System.out.println("输入: " + Arrays.toString(nums));
        nextPermutation.nextPermutation(nums);
        System.out.println("输出: " + Arrays.toString(nums));
        System.out.println("预期: [2, 1, 3]");
        System.out.println();

        int[] nums2 = { 3, 2, 1 };
        System.out.println("输入: " + Arrays.toString(nums2));
        nextPermutation.nextPermutation(nums2);
        System.out.println("输出: " + Arrays.toString(nums2));
        System.out.println("预期: [1, 2, 3]");
        System.out.println();

        int[] nums3 = { 1, 1, 5 };
        System.out.println("输入: " + Arrays.toString(nums3));
        nextPermutation.nextPermutation(nums3);
        System.out.println("输出: " + Arrays.toString(nums3));
        System.out.println("预期: [1, 5, 1]");
        System.out.println();

        int[] nums4 = { 4, 2, 0, 2, 3, 2, 0 };
        System.out.println("输入: " + Arrays.toString(nums4));
        nextPermutation.nextPermutation(nums4);
        System.out.println("输出: " + Arrays.toString(nums4));
        System.out.println("预期: [4, 2, 0, 3, 0, 2, 2]");
        System.out.println();
    }
}
