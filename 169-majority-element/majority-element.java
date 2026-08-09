class Solution {
    public int majorityElement(int[] nums) {
        insertionSort(nums);
        int t=nums[0];
        int c=1;
        for(int i=1;i<nums.length;i++)
        {
            if(t==nums[i])
            {
                c++;
            }
            else
            {
                t=nums[i];
                c=1;
            }

            if(c>nums.length/2)
                return t;
        }
        return t;
    }

    public int[] insertionSort(int[] a){
        for(int i=1;i<a.length;i++)
        {
            int curr=a[i];
            int prev=i-1;
            while(prev>=0 && a[prev]>curr)
            {
                a[prev+1]=a[prev];
                prev--;
            }
            a[prev+1]=curr;
        }
        return a;
    }
}