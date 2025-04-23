package leetcode.array;

import java.util.Arrays;

/**
 * LeetCode 66: Plus One
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class PlusOne {

    /**
     * 在给定的整数数组上加一
     * 
     * @param digits 整数数组
     * @return 加一后的整数数组
     */
    public int[] plusOne(int[] digits) {
        int end = digits.length - 1;
        int carry = 0;
        if (digits[end] == 9)
            carry = 1;

        for (int i = end; i >= 0; i--) {
            if (carry == 1) {
                if (digits[i] == 9) {
                    carry = 1;
                    digits[i] = 0;
                } else {
                    carry = 0;
                    digits[i]++;
                    break;
                }
            } else {
                digits[i]++;
                break;
            }
        }
        if (carry == 1) {
            int[] new_digits = new int[digits.length + 1];
            new_digits[0] = 1;
            digits = new_digits;
        }
        return digits;
    }

    /**
     * 测试 Plus One 问题
     */
    public static void main(String[] args) {
        System.out.println("测试 Plus One 问题：");
        PlusOne solution = new PlusOne();

        // 测试用例 1
        int[] digits1 = { 1, 2, 3 };
        System.out.println("输入: digits = " + Arrays.toString(digits1));
        int[] result1 = solution.plusOne(digits1);
        System.out.println("输出: " + Arrays.toString(result1));
        System.out.println("预期: [1, 2, 4]");
        System.out.println();

        // 测试用例 2
        int[] digits2 = { 4, 3, 2, 9 };
        System.out.println("输入: digits = " + Arrays.toString(digits2));
        int[] result2 = solution.plusOne(digits2);
        System.out.println("输出: " + Arrays.toString(result2));
        System.out.println("预期: [4, 3, 3, 0]");
        System.out.println();

        // 测试用例 3
        int[] digits3 = { 9, 9, 9 };
        System.out.println("输入: digits = " + Arrays.toString(digits3));
        int[] result3 = solution.plusOne(digits3);
        System.out.println("输出: " + Arrays.toString(result3));
        System.out.println("预期: [1, 0, 0, 0]");
        System.out.println();

    }
}
