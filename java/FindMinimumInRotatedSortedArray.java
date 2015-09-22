public class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high - 1) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                if (nums[mid] < nums[mid+1] && (mid == 0 || nums[mid] < nums[mid-1])) {
                    return nums[mid];
                } else {
                    high = mid - 1;
                }
            }
        }
        
        return Math.min(nums[low], nums[high]);
    }
}
