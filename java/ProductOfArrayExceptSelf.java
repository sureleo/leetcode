// http://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/
// I actually met this problem during an interview. However, division was allowed
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[result.length-1] = 1;
        for (int i = result.length-2; i >= 0; i--) {
            result[i] = result[i+1] * nums[i+1];
        }
        
        int left = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] * left;
            left = left * nums[i];
        }
        
        return result;
    }
}
