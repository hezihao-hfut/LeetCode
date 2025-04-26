package leetcode.string;

/**
 * 给你一个整数 columnNumber ，返回它对应的列标题。
 */
public class ConvertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            result.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }

    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        System.out.println(convertToTitle.convertToTitle(1));
        System.out.println(convertToTitle.convertToTitle(28));
        System.out.println(convertToTitle.convertToTitle(701));

        System.out.println(convertToTitle.titleToNumber("A"));
        System.out.println(convertToTitle.titleToNumber("AB"));
        System.out.println(convertToTitle.titleToNumber("ZY"));

    }


}
