package leetcode.array;

import java.util.Arrays;

/**
 * LeetCode 88: Merge Sorted Array
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 注意：不需要返回任何内容，直接修改 nums1 即可。
 */
public class Merge {

    /**
     * 合并两个有序数组
     * 
     * @param nums1 第一个有序数组
     * @param m     第一个数组的有效元素个数
     * @param nums2 第二个有序数组
     * @param n     第二个数组的有效元素个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int s1 = 0, s2 = 0, s = 0;
        while (s < nums.length) {
            if (s1 == m) {
                nums[s++] = nums2[s2++];
            } else if (s2 == n) {
                nums[s++] = nums1[s1++];
            } else
                nums[s++] = (nums1[s1] <= nums2[s2]) ? nums1[s1++] : nums2[s2++];
        }
        if (m + n >= 0) System.arraycopy(nums, 0, nums1, 0, m + n);
    }

    // 优化版本：从后往前合并
    // 该方法不需要额外的空间，直接在 nums1 中进行合并
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // 指向 nums1 的最后一个有效元素
        int p2 = n - 1; // 指向 nums2 的最后一个元素
        int p = m + n - 1; // 指向 nums1 的最后一个位置
    
        while (p2 >= 0 && p1 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
    
        // 如果 nums2 还有剩余元素，复制到 nums1 前部
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
        // nums1 的剩余元素已经就位，无需处理
    }

    /**
     * 测试 Merge Sorted Array 问题
     */
    public static void main(String[] args) {
        System.out.println("测试 Merge Sorted Array 问题：");
        Merge solution = new Merge();

        // 测试用例 1
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;
        System.out.println("输入: nums1 = " + Arrays.toString(nums1) + ", m = " + m + ", nums2 = "
                + Arrays.toString(nums2) + ", n = " + n);
        solution.merge2(nums1, m, nums2, n);
        System.out.println("输出: " + Arrays.toString(nums1));
        System.out.println("预期: [1, 2, 2, 3, 5, 6]");
        System.out.println();

        // 测试用例 2
        int[] nums3 = { 1 };
        int m2 = 1;
        int[] nums4 = {};
        int n2 = 0;
        System.out.println("输入: nums1 = " + Arrays.toString(nums3) + ", m = " + m2 + ", nums2 = "
                + Arrays.toString(nums4) + ", n = " + n2);
        solution.merge2(nums3, m2, nums4, n2);
        System.out.println("输出: " + Arrays.toString(nums3));
        System.out.println("预期: [1]");
        System.out.println();

        // 测试用例 3
        int[] nums5 = { 0 };
        int m3 = 0;
        int[] nums6 = { 1 };
        int n3 = 1;
        System.out.println("输入: nums1 = " + Arrays.toString(nums5) + ", m = " + m3 + ", nums2 = "
                + Arrays.toString(nums6) + ", n = " + n3);
        solution.merge2(nums5, m3, nums6, n3);
        System.out.println("输出: " + Arrays.toString(nums5));
        System.out.println("预期: [1]");
        System.out.println();
    }
}
