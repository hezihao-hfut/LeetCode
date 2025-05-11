import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println(Arrays.toString(numbers));
        System.out.println(numbers.toString());
        // 输出: [1, 2, 3]

        String[] names = {"Alice", "Bob", null};
        System.out.println(Arrays.toString(names));
        System.out.println(names.toString());
        // 输出: [Alice, Bob, null]

        char[] chars = {'a', 'b', 'c'};
        System.out.println(Arrays.toString(chars));
        System.out.println(chars.toString());
        // 输出: [a, b, c]
    }
}