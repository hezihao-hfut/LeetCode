package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
public class ContainsDuplicate {

    /**
     * 判断数组中是否存在重复元素
     * 
     * @param nums 整数数组
     * @return 如果数组中存在重复元素，返回 true；否则返回 false    
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = { 1, 2, 3, 1 };
        System.out.println("输入: nums = " + Arrays.toString(nums));
        System.out.println("输出: " + containsDuplicate.containsDuplicate(nums));
        System.out.println("预期: true");
        System.out.println();

        int[] nums2 = { 1, 2, 3, 4 };
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + containsDuplicate.containsDuplicate(nums2));
        System.out.println("预期: false");
        System.out.println();

        int[] nums3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println("输入: nums = " + Arrays.toString(nums3));
        System.out.println("输出: " + containsDuplicate.containsDuplicate(nums3));
        System.out.println("预期: true");
        System.out.println();
    }
}
