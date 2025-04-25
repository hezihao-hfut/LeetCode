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
        System.out.println(kmp.kmp("aaaaa", "bba"));
        System.out.println(kmp.kmp("abc", "c"));
    }
}
