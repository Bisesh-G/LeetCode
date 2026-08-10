class Solution {
    public int[] countBits(int n) {
        int[] ans= new int[n+1];
        int c=0;
        for(int i=0;i<=n;i++)
        {
            c=0;
            int temp =i;
            for(int j=0;j<=i;j++)
            {
                if(( temp&1)==1)
                    c++;
                temp=temp>>1;
            }
            ans[i]=c;
        }
        return ans;
    }
}