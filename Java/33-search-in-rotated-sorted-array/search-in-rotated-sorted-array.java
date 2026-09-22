class Solution {

    public int search(int[] nums, int target) {

        int n = nums.length;
        int pivot = pivot(nums);
        int end = n - 1;

        if (target >= nums[pivot] && target <= nums[end]) {
            return bS(nums, target, pivot, end);
        } else {
            return bS(nums, target, 0, pivot - 1);
        }
    }

    public int pivot(int[] nums) {

        int s = 0;
        int e = nums.length - 1;

        while (s < e) {

            int mid = (s + e) / 2;

            if (nums[mid] >= nums[0]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }

        return s;
    }

    public int bS(int[] nums, int target, int s, int e) {

        while (s <= e) {

            int mid = (s + e) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return -1;
    }
}