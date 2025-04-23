package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
 * 并且不存在属于某个范围但不属于 nums 的数字 x 。
 */
public class SummaryRanges {

    /**
     * 使用双指针法，一个指针用于遍历数组，一个指针用于记录当前区间的起始位置。
     * 如果当前元素与前一个元素连续，则继续遍历；
     * 否则，将当前区间加入结果列表，并更新起始位置。
     * 
     * @param nums 无重复元素的有序整数数组
     * @return 最小有序区间范围列表
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int n = nums.length;
        int i = 0;
        while (i < n) {
            int low = i; // 区间的起始位置
            // 找到连续区间的结束位置
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            // 区间是从 nums[low] 到 nums[i - 1]
            int high = i - 1;

            StringBuilder sb = new StringBuilder();
            sb.append(nums[low]);
            if (low < high) { // 检查区间是否包含多个元素
                sb.append("->").append(nums[high]);
            }
            result.add(sb.toString());
            // 'i' 已经为下一次迭代准备好
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges solution = new SummaryRanges();
        int[] nums = { 0, 1, 2, 4, 5, 7 };
        System.out.println("输入: nums = " + Arrays.toString(nums));
        System.out.println("输出: " + solution.summaryRanges(nums));
        System.out.println("预期: [0->2, 4->5, 7]");
        System.out.println();

        int[] nums2 = { 0, 2, 3, 4, 6, 8, 9 };
        System.out.println("输入: nums = " + Arrays.toString(nums2));
        System.out.println("输出: " + solution.summaryRanges(nums2));
        System.out.println("预期: [0, 2->4, 6, 8->9]");
        System.out.println();

        int[] nums3 = {};
        System.out.println("输入: nums = " + Arrays.toString(nums3));
        System.out.println("输出: " + solution.summaryRanges(nums3));
        System.out.println("预期: []");
        System.out.println();
    }
}
