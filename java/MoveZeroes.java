public class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] == 0 && nums[fast] != 0) {
                swap(nums, slow, fast);
                slow += 1;
                continue;
            }
            
            if (nums[slow] != 0) {
                slow += 1;
                continue;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
