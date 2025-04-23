package leetcode.array;

import java.util.Arrays;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 示例 1:
 * 输入: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 解释: 雨水可以在索引 2、3 和 8 处接住，共 6 个单位的雨水。
 */
public class Trap {

    /**
     * 计算接雨水的总量
     * 
     * @param height 整数数组，表示柱子的高度
     * @return 接雨水的总量
     */
    public int trap(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int min_high = 0;
        while (left < right) {
            while (left < right && height[left] <= min_high) {
                left++;
            }
            while (left < right && height[right] <= min_high) {
                right--;
            }
            min_high = Math.min(height[left], height[right]);
            for (int i = left + 1; i < right; i++) {
                if (height[i] < min_high) {
                    water += min_high - height[i];
                    height[i] = min_high;
                }
            }
        }
        return water;
    }

    public int trap2(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int min_high = 0;
        while (left < right) {
            min_high = Math.min(height[left], height[right]);
            if (height[left] < height[right]) {
                left++;
                while (left < right && height[left] <= min_high) {
                    water += min_high - height[left];
                    left++;
                }
            } else {
                right--;
                while (left < right && height[right] <= min_high) {
                    water += min_high - height[right];
                    right--;
                }
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("输入: height = " + Arrays.toString(height));
        System.out.println("输出: " + trap.trap2(height));
        System.out.println("预期: 6");
        System.out.println();

        int[] height2 = { 4, 2, 0, 3, 2, 5 };
        System.out.println("输入: height = " + Arrays.toString(height2));
        System.out.println("输出: " + trap.trap2(height2));
        System.out.println("预期: 9");
        System.out.println();

        int[] height3 = { 2, 0, 2 };
        System.out.println("输入: height = " + Arrays.toString(height3));
        System.out.println("输出: " + trap.trap2(height3));
        System.out.println("预期: 2");
        System.out.println();
    }
}
