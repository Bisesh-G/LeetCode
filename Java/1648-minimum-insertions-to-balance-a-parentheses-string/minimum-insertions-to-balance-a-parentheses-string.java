
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // If an unmatched ')' is pending,
                // insert '(' before it.
                if (open > 0 && open % 2 == 1) {
                    insertions++;
                    open--;
                }

                open += 2;
            } else {
                open--;

                // If we have too many closing parentheses,
                // insert an opening parenthesis.
                if (open < 0) {
                    insertions++;
                    open = 1;
                }
            }
        }

        return insertions + open;
    }
}
