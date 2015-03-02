public class Solution {
    public void rotateWithCopy(int[] nums, int k) {
        int[] results = new int[nums.length];
        k = k % nums.length;
        System.arraycopy(nums, 0, results, k, nums.length-k);
        System.arraycopy(nums, nums.length-k, results, 0, k);
        System.arraycopy(results, 0, nums, 0, nums.length);
    }

    public void rotateWithKTimes(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        while (count < k) {
            int temp = nums[nums.length-1];
            for (int i = nums.length-1; i > 0; i --) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            count += 1;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        this.reverse(nums, 0, nums.length-1);
        this.reverse(nums, 0, k-1);
        this.reverse(nums, k, nums.length-1);
    }
    
    public void reverse (int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left += 1;
            right -= 1;
        }
    }
}
