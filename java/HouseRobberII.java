public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int wFirst[] = new int[nums.length];
        int woFirst[] = new int[nums.length + 1];
        wFirst[0] = 0;
        wFirst[1] = nums[0];
        for (int i = 2; i < wFirst.length; i++) {
            wFirst[i] = Math.max(wFirst[i - 2] + nums[i - 1], wFirst[i - 1]);
        }
        
        woFirst[0] = 0;
        woFirst[1] = 0;
        for (int i = 2; i < woFirst.length; i++) {
            woFirst[i] = Math.max(woFirst[i - 2] + nums[i - 1], woFirst[i - 1]);
        }
        
        return Math.max(wFirst[nums.length - 1], woFirst[nums.length]);
    }
}
