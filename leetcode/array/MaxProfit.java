package leetcode.array;

import java.util.Arrays;

/*
 * LeetCode 121: Best Time to Buy and Sell Stock
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class MaxProfit {

    /**
     * 使用贪心算法，记录最低价格和最大利润。
     * 
     * @param prices 股票价格数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i : prices) {
            minPrice = Math.min(minPrice, i);
            maxProfit = Math.max(i - minPrice, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println("输入: prices = " + Arrays.toString(prices));
        System.out.println("输出: " + maxProfit.maxProfit(prices));
        System.out.println("预期: 5");
        System.out.println();

        int[] prices2 = { 7, 6, 4, 3, 1 };
        System.out.println("输入: prices = " + Arrays.toString(prices2));
        System.out.println("输出: " + maxProfit.maxProfit(prices2));
        System.out.println("预期: 0");
    }
}
