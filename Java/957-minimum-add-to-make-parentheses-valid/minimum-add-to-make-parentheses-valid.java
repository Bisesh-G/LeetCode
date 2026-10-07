class Solution {
    public int minAddToMakeValid(String s) {
        int openImbalance = 0;
        int closeImbalance = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openImbalance++;
            } else {
                // If we have an unmatched '(', pair it up
                if (openImbalance > 0) {
                    openImbalance--;
                } else {
                    // Otherwise, this ')' is unmatched
                    closeImbalance++;
                }
            }
        }

        // The total insertions needed is the sum of unmatched '(' and ')'
        return openImbalance + closeImbalance;
    }
}