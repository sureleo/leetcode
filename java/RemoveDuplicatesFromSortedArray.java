public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow += 1;
            }
            
            if (slow != fast) {
                nums[slow] = nums[fast];
            }
        }
        
        return slow + 1;
    }
}
