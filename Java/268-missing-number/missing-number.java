class Solution {
    public int missingNumber(int[] nums) {
        boolean[] map=new boolean[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
                map[nums[i]]=true;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(map[i]!=true)
                return i;
        }
    return nums.length;
    }
}