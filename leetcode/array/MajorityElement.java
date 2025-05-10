package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode 169. 多数元素   
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数大于 ⌊n / 2⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {

    /**
     * 哈希表
     * 
     * @param nums 数组
     * @return 多数元素
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2) {
                return key;
            }
        }
        return 0;
    }

    /**
     * 摩尔投票法
     * 
     * @param nums 数组
     * @return 多数元素
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }



    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = { 3, 2, 3 };
        System.out.println("输入: nums = " + Arrays.toString(nums));
        System.out.println("输出: " + majorityElement.majorityElement(nums));
        System.out.println("预期: 3");
        System.out.println();

        int[] nums2 = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + majorityElement.majorityElement(nums2));
        System.out.println("预期: 2");
        System.out.println();
    }
}
