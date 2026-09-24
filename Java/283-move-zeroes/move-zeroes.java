class Solution {
    public void moveZeroes(int[] nums) {
        int j=0,c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                c++;
            else
            {
                nums[j]=nums[i];
                j++;
            }
        }
        for(int i=0;i<c;i++)
        {
            nums[j+i]=0;
        }
        return;
    }
}