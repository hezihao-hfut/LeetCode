package leetcode.array;

import java.util.Arrays;

/**
 * LeetCode 11: 盛水最多的容器
 * 给定 n 个非负整数 a1，a2，...，an，其中每个代表一个点 (i, ai) 。在坐标系中，
 * 画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class MaxArea {
    
    /**
     * 双指针法计算盛水最多的容器
     * @param height 整数数组，表示每个点的高度
     * @return 盛水最多的容器的容量
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int aera = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, aera);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("输入: " + Arrays.toString(height));
        int result = maxArea.maxArea(height);
        System.out.println("输出: " + result); // Output: 49
        System.out.println("预期: 49");
        System.out.println();

        int[] height2 = {1,1};
        int result2 = maxArea.maxArea(height2);
        System.out.println("输入: " + Arrays.toString(height2));
        System.out.println("输出: " + result2);
        System.out.println("预期: 1");
        System.out.println();

        int[] height3 = {4,3,2,1,4};
        int result3 = maxArea.maxArea(height3);
        System.out.println("输入: " + Arrays.toString(height3));
        System.out.println("输出: " + result3);
        System.out.println("预期: 16");
        System.out.println();

        int[] height4 = {1,2,1};
        int result4 = maxArea.maxArea(height4);
        System.out.println("输入: " + Arrays.toString(height4));
        System.out.println("输出: " + result4);
        System.out.println("预期: 2");
        System.out.println();
    }
}
