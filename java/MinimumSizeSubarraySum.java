public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length+1];
        int result = nums.length + 1;
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }

        for (int i = 0; i < sums.length; i++) {
            int right = binarySearch(i, sums.length-1, sums, s);
            if (right == sums.length) {
                break;
            }

            result = Math.min(result, right - i);
        }

        if (result == nums.length + 1) {
            return 0;
        } else {
            return result;
        }
    }

    public int binarySearch(int low, int high, int[] sums, int target) {
        int start = sums[low];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sums[mid] - start == target) {
                return mid;
            } else if (sums[mid] - start > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
