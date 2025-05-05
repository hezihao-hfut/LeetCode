package leetcode.string;

/*
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    
    public int lengthOfLongestSubstring(String s) {
        
        return 0;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("输入: s = " + s);
        System.out.println("输出: " + result);
        System.out.println("预期: " + 3);
        System.out.println("");

        s = "bbbbb";
        result = solution.lengthOfLongestSubstring(s);
        System.out.println("输入: s = " + s);
        System.out.println("输出: " + result);
        System.out.println("预期: " + 1);
        System.out.println("");

        s = "pwwkew";
        result = solution.lengthOfLongestSubstring(s);
        System.out.println("输入: s = " + s);
        System.out.println("输出: " + result);
        System.out.println("预期: " + 3);
        System.out.println("");
    }
}
