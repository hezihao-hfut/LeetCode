import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        for (char i : cs) {
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            } else if (i == ')') {
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (i == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            } else {
                if (stack.pop() != '{') {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}