class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            // Check if the 1-based index (i + 1) divides the length of the array n
            if (n % (i + 1) == 0) {
                sum += nums[i] * nums[i];
            }
        }
        
        return sum;
    }
}