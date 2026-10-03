import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base anchor for length calculation
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // Store the index of '('
            } else {
                stack.pop(); // Try to match with a previous '('
                
                if (stack.isEmpty()) {
                    // No matching '(', so this ')' becomes the new baseline anchor
                    stack.push(i);
                } else {
                    // Valid substring found! Calculate its length
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}