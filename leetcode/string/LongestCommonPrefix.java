package leetcode.string;


/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {
    
    /**
     * 查找字符串数组中的最长公共前缀
     * 
     * @param strs 字符串数组
     * @return 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("输入: strs = " + String.join(", ", strs1));
        System.out.println("输出：" + lcp.longestCommonPrefix(strs1)); // "fl"
        System.out.println("预期: " + "fl");
        System.out.println("");

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("输入: strs = " + String.join(", ", strs2));
        System.out.println("输出：" + lcp.longestCommonPrefix(strs2)); // ""
        System.out.println("预期: " + "");
        System.out.println("");
    }
}
