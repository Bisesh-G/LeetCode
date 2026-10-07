import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);
        boolean foundValid = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            // If a valid string is found, add to results and stop generating longer variations
            if (isValid(current)) {
                result.add(current);
                foundValid = true;
            }

            // If we found a valid level, do not generate deeper states
            if (foundValid) continue;

            // Generate all possible states by removing one parenthesis
            for (int i = 0; i < current.length(); i++) {
                char c = current.charAt(i);
                if (c != '(' && c != ')') continue;

                // Create a new string substring skipping character at index i
                String nextState = current.substring(0, i) + current.substring(i + 1);

                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    queue.add(nextState);
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}