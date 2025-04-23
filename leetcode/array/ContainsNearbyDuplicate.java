package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 使得 nums[i] == nums[j] ，并且 abs(i - j) <= k 。
 */
public class ContainsNearbyDuplicate {

    /**
     * 使用HashSet来存储数组中的元素，并使用一个窗口来滑动。
     * 
     * @param nums 整数数组
     * @param k    整数
     * @return 如果存在，返回 true；否则返回 false
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用HashMap来存储数组中的元素和它们的索引。
     * 
     * @param nums 整数数组
     * @param k    整数
     * @return 如果存在，返回 true；否则返回 false
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate solution = new ContainsNearbyDuplicate();

        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        System.out.println("输入: nums = " + Arrays.toString(nums) + ", k = " + k);
        System.out.println("输出: " + solution.containsNearbyDuplicate(nums, k));
        System.out.println("预期: true");
        System.out.println();

        int[] nums2 = { 1, 0, 1, 1 };
        int k2 = 1;
        System.out.println("输入: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("输出: " + solution.containsNearbyDuplicate(nums2, k2));
        System.out.println("预期: true");
        System.out.println();

        int[] nums3 = { 1, 2, 3, 1, 2, 3 };
        int k3 = 2;
        System.out.println("输入: nums = " + Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("输出: " + solution.containsNearbyDuplicate(nums3, k3));
        System.out.println("预期: false");
        System.out.println();
    }
}
