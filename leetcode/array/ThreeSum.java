package leetcode.array;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 15: 三数之和
 * 给你一个包含 n 个整数的数组 nums ，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 。找到所有满足条件且不重复的三元组。
 */
public class ThreeSum {

    /**
     * 三数之和
     * 
     * @param nums 整数数组
     * @return 所有不重复的三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 排序数组
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[0] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                    while (nums[right] == nums[right + 1] && left < right) {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = { -1, 0, 1, 2, -1, -2 };
        List<List<Integer>> result = threeSum.threeSum(nums);
        System.out.println("输入: " + Arrays.toString(nums));
        System.out.println("输出: " + result); // Output: [[-1,-1,2],[-1,0,1],[-2,0,2]]
        System.out.println("预期: [[-1, -1, 2],[-1, 0, 1],[-2, 0, 2]]");
        System.out.println();

        int[] nums2 = { 0, 1, 1 };
        List<List<Integer>> result2 = threeSum.threeSum(nums2);
        System.out.println("输入: " + Arrays.toString(nums2));
        System.out.println("输出: " + result2); // Output: []
        System.out.println("预期: []");
        System.out.println();

        int[] nums3 = { 0, 0, 0 };
        List<List<Integer>> result3 = threeSum.threeSum(nums3);
        System.out.println("输入: " + Arrays.toString(nums3));
        System.out.println("输出: " + result3); // Output: [[0,0,0]]
        System.out.println("预期: [[0, 0, 0]]");
        System.out.println();
    }
}
