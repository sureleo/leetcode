// http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
// oh, man. even knuth needs 24 hours to get O(n) solution.
public class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (mid >= nums[i]) {
                    count += 1;
                }
            }
            
            if (count > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }

}
