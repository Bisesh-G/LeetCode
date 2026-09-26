class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r=piles[0];
        long tot=0;
        for (int i = 0;i<piles.length;i++)
        {
            if (r<piles[i])
                r=piles[i];
            tot=tot+piles[i];
        }
        int l=(int)Math.ceil((double)tot/h);
        while(l<=r)
        {
            int mid = l + (r - l) / 2;
            long sum=0;
            for(int i=0;i<piles.length;i++)
            {
                sum=sum+(int)Math.ceil((double)piles[i]/mid);
            }
            if (sum > h)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
}