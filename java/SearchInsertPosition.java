public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) {
            return 0;
        }
        
        if (target > nums[nums.length-1]) {
            return nums.length;
        }
        
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                if (nums[mid+1] >= target) {
                    return mid + 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                if (nums[mid-1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                } 
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}
