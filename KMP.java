public class KMP {
    public int kmp(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    private void getNext(int[] next, String needle) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < needle.length(); i++) {
            /*
             * 这是处理不匹配情况的核心。
             * 如果当前字符 needle[i] 与模式串中前缀部分的下一个字符 needle[j] 不匹配，
             * 说明我们无法在当前 j 的基础上延长公共前后缀。
             * 我们需要回溯，查找次长的公共前后缀。
             * 怎么找呢？利用已经计算好的 next 数组：j = next[j - 1]。
             * 这会将 j 更新为前一个子串 needle[0...j-1] 的最长公共前后缀长度，
             * 然后继续比较 needle[i] 和新的 needle[j]。
             * 这个过程一直进行，直到 j 变为 0 (表示没有公共前后缀) 或者找到匹配。
             */
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.kmp("hello", "ll"));
        System.out.println(kmp.kmp("ababbabababb", "abababb"));
        System.out.println(kmp.kmp("abc", "c"));
    }
}
