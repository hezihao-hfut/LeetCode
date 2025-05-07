package leetcode.string;

/*
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 */
public class Convert {
    
    /**
     * 将字符串转换为 Z 字形排列
     * @param s 输入字符串
     * @param numRows 行数
     * @return 转换后的字符串
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] rowBuilders = new StringBuilder[numRows];
        for (int k = 0; k < numRows; k++) {
            rowBuilders[k] = new StringBuilder();
        }

        StringBuilder result = new StringBuilder();
        int flag = 1;
        int colIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            rowBuilders[colIndex].append(s.charAt(i));
            colIndex += flag;
            if (colIndex == numRows - 1 || colIndex == 0) {
                flag = -flag;
            }
        }
        for (StringBuilder sb : rowBuilders) {
            result.append(sb);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = convert.convert(s, numRows);
        System.out.println("输入: s = " + s + ", numRows = " + numRows);
        System.out.println("输出: " + result);
        System.out.println("预期: " + "PAHNAPLSIIGYIR");
        System.out.println();

        s = "AB";
        numRows = 1;
        result = convert.convert(s, numRows);
        System.out.println("输入: s = " + s + ", numRows = " + numRows);
        System.out.println("输出: " + result);
        System.out.println("预期: " + "AB");
        System.out.println();

        s = "PAYPALISHIRING";
        numRows = 4;
        result = convert.convert(s, numRows);
        System.out.println("输入: s = " + s + ", numRows = " + numRows);
        System.out.println("输出: " + result);
        System.out.println("预期: " + "PINALSIGYAHRPI");
        System.out.println();
    }
}
