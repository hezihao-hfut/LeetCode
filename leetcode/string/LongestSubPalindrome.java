package leetcode.string;
/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestSubPalindrome {
    
    /**
     * 查找字符串中的最长回文子串
     * 
     * @param s 字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        return "";
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
        System.out.println("输出：" + lsp.longestPalindrome(s)); // "a"
        System.out.println("预期: " + "a");
        System.out.println();
    }
}
