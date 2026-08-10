class Solution {

    public int search(int[] nums, int target) {

        int n = nums.length;
        int pivot = getPivot(nums);
        int end = n - 1;

        if (target >= nums[pivot] && target <= nums[end]) {
            return binarySearch(nums, target, pivot, end);
        } else {
            return binarySearch(nums, target, 0, pivot - 1);
        }
    }

    private int getPivot(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] >= nums[0]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}