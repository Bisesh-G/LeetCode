class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Every state in the decision tree is a valid subset, so add a copy to the result list
        result.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            // Include the current element
            currentSubset.add(nums[i]);
            
            // Recurse to the next element
            backtrack(result, currentSubset, nums, i + 1);
            
            // Backtrack: remove the last element to explore paths without it
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}