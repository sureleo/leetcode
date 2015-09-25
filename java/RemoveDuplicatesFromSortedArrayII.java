public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        
        int prev = 1;
        int curr = 2;
        while (curr < nums.length && prev < nums.length) {
            if (nums[curr] == nums[prev] && nums[prev] == nums[prev-1]) {
                curr += 1;
            } else {
                prev += 1;
                nums[prev] = nums[curr];
                curr += 1;
            }
        }
        
        return prev + 1;
    }
}
