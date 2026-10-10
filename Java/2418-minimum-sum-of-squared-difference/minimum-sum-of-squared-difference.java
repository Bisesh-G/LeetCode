class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long totalK = (long) k1 + k2;
        int n = nums1.length;
        
        // Step 1: Populate the frequency array of absolute differences
        // The maximum possible difference is 100,000 given the constraints
        int[] bucket = new int[100001];
        long totalDiffSum = 0;
        int maxDiff = 0;
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > 0) {
                bucket[diff]++;
                totalDiffSum += diff;
                maxDiff = Math.max(maxDiff, diff);
            }
        }
        
        // If our total modifications can completely wipe out all differences, return 0
        if (totalDiffSum <= totalK) {
            return 0;
        }
        
        // Step 2: Greedily reduce the largest differences down to smaller buckets
        for (int d = maxDiff; d > 0 && totalK > 0; d--) {
            if (bucket[d] == 0) continue;
            
            long count = bucket[d];
            // Determine how many complete decrements we can make for this entire bucket level
            long opsAllocated = Math.min(totalK, count);
            
            bucket[d] -= opsAllocated;
            bucket[d - 1] += opsAllocated;
            totalK -= opsAllocated;
            
            // If we used all operations but couldn't move the entire bucket, we are done
            if (bucket[d] > 0) {
                break;
            }
        }
        
        // Step 3: Calculate the final sum of squared differences
        long minSumSquare = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (bucket[d] > 0) {
                minSumSquare += (long) bucket[d] * d * d;
            }
        }
        
        return minSumSquare;
    }
}