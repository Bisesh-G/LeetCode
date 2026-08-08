class Solution {
    public boolean isPowerOfTwo(int n) {
        int temp=n;
        if (temp<=0)
            return false;
        if((temp & (temp-1)) ==0)
            return true;
        else 
            return false;
    }
}