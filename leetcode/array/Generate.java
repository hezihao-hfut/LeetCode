package leetcode.array;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 118: Pascal's Triangle
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它上方的两个数的和。
 */
public class Generate {

    /**
     * 生成杨辉三角
     * 
     * @param numRows 行数
     * @return 杨辉三角的前 numRows 行
     */
    public int[][] generate(int numRows) {
        int[][] triangle = new int[numRows][];
        for (int i = 0; i < numRows; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                    continue;
                }
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        return triangle;
    }

    public int[] getRow(int rowIndex) {
        int[] row = new int[rowIndex + 1];
        row[0] = 1;
        
        for (int i = 1; i <= rowIndex; i++) {
            // 从后往前计算，避免覆盖之前的值
            for (int j = i; j > 0; j--) {
                row[j] = row[j] + row[j - 1];
            }
        }
        return row;
    }

    public List<Integer> getRowList(int rowIndex) {
        int[] row = getRow(rowIndex);
        List<Integer> result = new ArrayList<>();
        for (int num : row) {
            result.add(num);
        }
        return result;
    }

    /**
     * 测试 Generate Pascal's Triangle 问题
     * 
     */
    public static void main(String[] args) {
        Generate generate = new Generate();
        int[][] result = generate.generate(5);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }

        List<Integer> rowList = generate.getRowList(3);  // 返回第3行 [1,3,3,1]
        System.out.println(rowList);
    }
}
