package leetcode.string;

import java.util.Map;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符： I， V， X， L， C， D 和 M。
 * 
 * 该方法将罗马数字转换为整数。
 */
public class RomanToInt {
    
    /**
     * 将罗马数字转换为整数
     * 
     * @param s 罗马数字字符串
     * @return 转换后的整数值
     */
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> romanMap = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );
        for (int i = 0; i < s.length(); i++) {
            int current = romanMap.get(s.charAt(i));
            if (i + 1 < s.length() && current < romanMap.get(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        String roman1 = "III";
        System.out.println("输入: " + roman1);
        System.out.println("输出：" + romanToInt.romanToInt(roman1));
        System.out.println("预期: " + 3);
        System.out.println("");

        String roman2 = "IV";
        System.out.println("输入: " + roman2);
        System.out.println("输出：" + romanToInt.romanToInt(roman2)); // 4
        System.out.println("预期: " + 4);
        System.out.println("");

        String roman3 = "IX";
        System.out.println("输入: " + roman3);
        System.out.println("输出：" + romanToInt.romanToInt(roman3)); // 9
        System.out.println("预期: " + 9);
        System.out.println("");

        String roman4 = "LVIII";
        System.out.println("输入: " + roman4);
        System.out.println("输出：" + romanToInt.romanToInt(roman4)); // 58
        System.out.println("预期: " + 58);
        System.out.println("");

        String roman5 = "MCMXCIV";
        System.out.println("输入: " + roman5);
        System.out.println("输出：" + romanToInt.romanToInt(roman5)); // 1994
        System.out.println("预期: " + 1994);
        System.out.println("");
    }
}
