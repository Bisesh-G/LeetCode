class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int c[]=new int[n+1];
         int a[]=new int[2];
         for(int nm:nums)
         {
            c[nm]++;
         }
        for(int i=1;i<n+1;i++)
        {
            if(c[i]>1)
            {
                 a[0]=i;
                 }
            if(c[i]==0)
                a[1]=i;
        }
        return a;
    }
}