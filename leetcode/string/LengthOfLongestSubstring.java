package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/*
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int max_len = 1;
        int last_index = -1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            last_index = Math.max(map.getOrDefault(s.charAt(i), last_index), last_index);
            map.put(s.charAt(i), i);
            max_len = Math.max(max_len, i - last_index);
        }
        return max_len;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println("输入: s = " + s);
        System.out.println("输出: " + result);
        System.out.println("预期: " + 3);
        System.out.println();

        s = "abba";
        result = solution.lengthOfLongestSubstring(s);
        System.out.println("输入: s = " + s);
        System.out.println("输出: " + result);
        System.out.println("预期: " + 2);
        System.out.println();

        s = "pwwkew";
        result = solution.lengthOfLongestSubstring(s);
        System.out.println("输入: s = " + s);
        System.out.println("输出: " + result);
        System.out.println("预期: " + 3);
        System.out.println();
    }
}
