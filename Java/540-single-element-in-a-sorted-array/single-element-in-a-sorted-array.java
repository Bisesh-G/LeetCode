class Solution {
    public int singleNonDuplicate(int[] nums) {
        return bS(nums, 0, nums.length - 1);
    }

    public int bS(int[] nums, int s, int e) {

        if (s == e) {
            return nums[s];
        }

        int mid = (s + e) / 2;

        if (mid % 2 == 1) {
            mid--;
        }

        if (nums[mid] == nums[mid + 1]) {
            return bS(nums, mid + 2, e);
        } else {
           return bS(nums, s, mid);
        }
    }
}