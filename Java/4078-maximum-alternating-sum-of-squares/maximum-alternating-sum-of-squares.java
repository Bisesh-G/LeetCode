class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        // Step 1: Square all the elements to get rid of negative signs
        for (int i = 0; i < n; ++i) {
            nums[i] = nums[i] * nums[i];
        }
        
        // Step 2: Sort the squared elements in ascending order
        Arrays.sort(nums);
        
        long ans = 0;
        int m = n / 2;
        
        // Step 3: Subtract the smaller half of the squared elements
        for (int i = 0; i < m; ++i) {
            ans -= nums[i];
        }
        
        // Step 4: Add the larger half of the squared elements
        for (int i = m; i < n; ++i) {
            ans += nums[i];
        }
        
        return ans;
    }
}