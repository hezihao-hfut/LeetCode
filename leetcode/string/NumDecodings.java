package leetcode.string;

/*
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 */
public class NumDecodings {
    
    /**
     * 解码方法
     * @param s 编码后的字符串
     * @return 解码方法的数量
     */
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i] = s.charAt(i) - '0';
        }
        dp[0] = 1; // Base case: s[0] is not '0', so one way to decode s[0]
        
        for (int i = 1; i < num.length; i++) {
            int current_ways = 0;

            // Case 1: Decode num[i] (current digit) as a single character.
            // Valid if num[i] is 1-9 (i.e., not 0).
            if (num[i] != 0) {
                current_ways += dp[i-1];
            }

            // Case 2: Decode num[i-1]num[i] (previous and current digit) as a two-digit character.
            // Valid if the two-digit number is between 10 and 26.
            int prev_digit = num[i-1];
            int curr_digit = num[i];

            if (prev_digit == 1) { // Forms "10" through "19"
                if (i - 2 >= 0) {
                    current_ways += dp[i-2];
                } else { // This means i=1, num[i-1]num[i] is the first pair (e.g., "1X")
                    current_ways += 1;
                }
            } else if (prev_digit == 2 && curr_digit >= 0 && curr_digit <= 6) { // Forms "20" through "26"
                if (i - 2 >= 0) {
                    current_ways += dp[i-2];
                } else { // This means i=1, num[i-1]num[i] is the first pair (e.g., "2X")
                    current_ways += 1;
                }
            }
            dp[i] = current_ways;
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        System.out.println(numDecodings.numDecodings("12")); // 2
        System.out.println(numDecodings.numDecodings("226")); // 3
        System.out.println(numDecodings.numDecodings("10")); // 1
        System.out.println(numDecodings.numDecodings("06")); // 0
        System.out.println(numDecodings.numDecodings("2101")); // 1
    }
}
