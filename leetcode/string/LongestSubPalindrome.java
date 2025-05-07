package leetcode.string;
/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestSubPalindrome {
    
    /**
     * 中心扩展法
     * 
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int maxLen = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = expandAroundCenter(s, i, i);
            String s2 = expandAroundCenter(s, i, i + 1);
            if (s1.length() > maxLen) {
                maxLen = s1.length();
                result = s1;
            }
            if (s2.length() > maxLen) {
                maxLen = s2.length();
                result = s2;
            }
        }
        return result;
    }

    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    /**
     * 动态规划
     * 
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                /*
                 * 如果s[i] == s[j]，并且i-j <= 2，或者dp[j+1][i-1]为true，则dp[j][i]为true
                 * 
                 * 1. 如果 i == j，子串长度为 1 (例如 "a")。单个字符总是回文。
                 * 2. 如果 i - j = 1，子串长度为 2 (例如 "aa")。两个字符的子串，且两个字符相等，总是回文。
                 * 3. 如果 i - j = 2，子串长度为 3 (例如 "aba")。三个字符的子串，且首尾字符相等，总是回文。
                 * 4. 如果 i - j > 2，字串长度大于 3，则需要检查 dp[j+1][i-1] 是否为 true。
                 */
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        result = s.substring(j, i + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubPalindrome lsp = new LongestSubPalindrome();
        String s = "babad";
        System.out.println("输入: s = " + s);
        System.out.println("输出：" + lsp.longestPalindrome(s)); // "bab" or "aba"
        System.out.println("预期: " + "bab or aba");
        System.out.println();

        s = "cbbd";
        System.out.println("输入: s = " + s);
        System.out.println("输出：" + lsp.longestPalindrome(s)); // "bb"
        System.out.println("预期: " + "bb");
        System.out.println();

        s = "a";
        System.out.println("输入: s = " + s);
        System.out.println("输出：" + lsp.longestPalindrome2(s)); // "a"
        System.out.println("预期: " + "a");
        System.out.println();
    }
}
