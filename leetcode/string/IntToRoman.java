package leetcode.string;

/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class IntToRoman {
    
    /**
     * 将整数转换为罗马数字
     * @param num 整数
     * @return 罗马数字表示
     */
    public String intToRoman(int num) {
        return "";
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(3));   // 输出: III
        System.out.println(intToRoman.intToRoman(58));  // 输出: LVIII
        System.out.println(intToRoman.intToRoman(1994)); // 输出: MCMXCIV
        System.out.println(intToRoman.intToRoman(3749));   // 输出: MMMDCCXLIX
    }
}
