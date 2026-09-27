class Solution {
    public int pivotIndex(int[] nums) {
        int lSum=0;
        int tSum=0;
        for(int i=0;i<nums.length;i++)
        {
            tSum+=nums[i];
        }   
        for(int i=0;i<nums.length;i++)
        {
            if(lSum==tSum-lSum-nums[i])
                return i;
            else 
                lSum+=nums[i];
        } 
        return -1;
    }
}