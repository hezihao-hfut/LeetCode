package leetcode.array;

import java.util.Arrays;

/**
 * LeetCode 27: Remove Element
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 */
public class RemoveElement {

    /**
     * 删除数组中的指定元素
     * 
     * @param nums 整数数组
     * @param val  要删除的值
     * @return 新的长度
     */
    public int removeElement(int[] nums, int val) {
        int s = 0;
        for (int f = 0; f < nums.length; f++) {
            if (nums[f] != val) {
                nums[s] = nums[f];
                s++;
            }
        }
        return s; // 返回新的长度
    }

    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[--right];
            } else {
                left++;
            }
        }
        return left; // 返回新的长度
    }

    /**
     * 测试 Remove Element 问题
     */
    public static void main(String[] args) {
        System.out.println("测试 Remove Element 问题：");
        RemoveElement solution = new RemoveElement();

        // 测试用例 1
        int[] nums1 = { 3, 2, 2, 3 };
        int val1 = 3;
        System.out.println("输入: nums = " + Arrays.toString(nums1) + ", val = " + val1);
        int newLength1 = solution.removeElement2(nums1, val1);
        System.out.println("输出: " + newLength1);
        System.out.println("预期: 2");
        System.out.println("修改后的数组: " + Arrays.toString(Arrays.copyOf(nums1, newLength1)));
        System.out.println();

        // 测试用例 2
        int[] nums2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val2 = 2;
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", val = " + val2);
        int newLength2 = solution.removeElement2(nums2, val2);
        System.out.println("输出: " + newLength2);
        System.out.println("预期: 5");
        System.out.println("修改后的数组: " + Arrays.toString(Arrays.copyOf(nums2, newLength2)));
    }
}
