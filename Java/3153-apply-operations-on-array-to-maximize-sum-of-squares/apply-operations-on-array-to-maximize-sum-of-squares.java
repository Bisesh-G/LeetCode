import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007L;
        int[] bitCount = new int[31]; // Count set bits at each position (0 to 30)

        // Step 1: Count the frequency of each bit across all numbers
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if (((num >> bit) & 1) == 1) {
                    bitCount[bit]++;
                }
            }
        }

        long answer = 0;

        // Step 2: Greedily construct the k largest numbers
        for (int i = 0; i < k; i++) {
            long current = 0;
            for (int bit = 30; bit >= 0; bit--) {
                if (bitCount[bit] > 0) {
                    current |= (1L << bit);
                    bitCount[bit]--;
                }
            }
            answer = (answer + current * current) % MOD;
        }

        return (int) answer;
    }
}
/*

---

### How It Works

1. **Bit Preservation**: The operation `nums[i] = nums[i] & nums[j]` and `nums[j] = nums[i] | nums[j]` moves bits between two numbers without destroying or creating any new ones. This means the total count of each set bit (from position `0` to `30`) remains constant across the entire array.
2. **Bit Counting**: We count how many times each bit (`0` through `30`) appears across all elements in `nums`.
3. **Greedy Construction**: To maximize the sum of squares, we want to make the individual numbers as large as possible. We greedily build `k` numbers by taking the highest available set bits first (from bit `30` down to `0`) and placing them into our current number.
4. **Modulo Arithmetic**: Each squared number is added to the total running sum and modulated by `1,000,000,007` (`10^9 + 7`).
*/