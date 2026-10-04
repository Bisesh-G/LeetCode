class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // c == '*'
                low--;
                high++;
            }
            
            // Too many closing brackets encountered
            if (high < 0) {
                return false;
            }
            
            // We cannot have a negative count of required open brackets
            if (low < 0) {
                low = 0;
            }
        }
        
        // The string is valid if all open brackets can be matched
        return low == 0;
    }
}