public class Solution {
    public void nextPermutation(int[] nums) {
        int vioIndex = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                vioIndex = i;
                break;
            } else {
                if (i == 0) {
                    reverse(nums, 0, nums.length);
                    return;
                }
            }
        }

        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] > nums[vioIndex]) {
                int temp = nums[i];
                nums[i] = nums[vioIndex];
                nums[vioIndex] = temp;
                break;
            }
        }

        reverse(nums, vioIndex+1, nums.length);
    }
    
    public void reverse(int[] nums, int start, int end) {
        for (int i = start; i < (start+end) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[end-1-i+start];
            nums[end-1-i+start] = temp;
        }
    }
}
