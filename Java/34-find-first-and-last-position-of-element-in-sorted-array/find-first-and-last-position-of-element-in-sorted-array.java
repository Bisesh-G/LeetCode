class Solution {

    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1, -1};

        result[0] = findFirstOccurrence(nums, target);
        result[1] = findLastOccurrence(nums, target);

        return result;
    }

    private int findFirstOccurrence(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int first = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                first = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return first;
    }

    private int findLastOccurrence(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int last = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                last = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return last;
    }
}