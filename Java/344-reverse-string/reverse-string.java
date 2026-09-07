class Solution {
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
        return;
    }
    public void helper(char[] s, int left, int right) {
        if(left>=right)
            return;
        
        char t=s[right];
        s[right]=s[left];
        s[left]=t;
        helper(s,left+1,right-1);
        return;
    }
}