class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int count[] = new int[n + 1];
        List<Integer> ans = new ArrayList<>();

        for (int x : nums) {
            count[x]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}
