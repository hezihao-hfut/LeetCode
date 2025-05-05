package leetcode.string;

/*
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的最长的回文串的长度。
 */
public class LongestPalindrome {

    /**
     * 计算通过给定字符串构造的最长回文串的长度
     * @param s 字符串
     * @return 最长回文串的长度
     */
    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return 0;
        int length = 0;
        boolean odd = false;
        int[] arr = new int[128] ;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        for (int j : arr) {
            if (j % 2 == 1) odd = true;
            if (j >= 2) {
                length += (j/2)*2;
            }
        }
        if (odd) return length + 1;
        else return length;
    }
    
    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String s1 = "abccccdd";
        System.out.println("输入: s = " + s1);
        System.out.println("输出：" + lp.longestPalindrome(s1));
        System.out.println("预期: " + "7");
        System.out.println();

        String s2 = "a";
        System.out.println("输入: s = " + s2);
        System.out.println("输出：" + lp.longestPalindrome(s2));
        System.out.println("预期: " + "1");
        System.out.println();
        
        String s3 = "ccc";
        System.out.println("输入: s = " + s3);
        System.out.println("输出：" + lp.longestPalindrome(s3));
        System.out.println("预期: " + "3");
        System.out.println();
    }
}
