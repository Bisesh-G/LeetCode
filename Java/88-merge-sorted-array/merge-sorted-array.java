class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length==m)
            return ;
        
        for(int i=m;i<nums1.length;i++)
        {
            nums1[i]=nums2[i-m];
        }

        bubbleSort(nums1);
        return ;
    }

    public int[] bubbleSort(int[] a){
        for(int i=0;i<a.length;i++)
        {
            int min=i;
            for(int j=i+1;j<a.length;j++)
            {
                if(a[min]>a[j])
                {
                    min=j;
                }
            }
            int t=a[i];
            a[i]=a[min];
            a[min]=t;
        }
        return a;
    }
}