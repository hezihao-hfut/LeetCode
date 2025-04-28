package leetcode.string;

import java.util.HashMap;

public class WordPattern {
    
    /**
     * 290. 单词规律
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     * 这里的规律指的是，pattern 中的每个字符都可以表示同一个字母，而不可以表示不同的字母。
     * 每个字母也可以表示自己，但它们不能同时表示不同的字母。
     * @param pattern
     * @param str
     * @return boolean
     */

    public boolean wordPattern(String pattern, String str) {
        char[] patternCharArr = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (patternCharArr.length != strs.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i<patternCharArr.length; i++) {
            if (map.containsKey(patternCharArr[i]) && !(map.get(patternCharArr[i]).equals(strs[i]))) {
                return false;
            } else if (map.containsValue(strs[i]) && !(map.containsKey(patternCharArr[i]))) {
                return false;
            } else {
                map.put(patternCharArr[i], strs[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(wordPattern.wordPattern("aaaa", "dog cat cat dog")); // false
        System.out.println(wordPattern.wordPattern("abba", "dog dog dog dog")); // false
    }
}
