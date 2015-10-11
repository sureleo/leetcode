// http://bookshadow.com/weblog/2015/06/03/leetcode-contains-duplicate-iii/
// nice TreeSet solution

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i]);
            Integer ceiling = set.ceiling(nums[i]);
            
            if ((floor != null && nums[i] <= floor + t) || ceiling != null && nums[i] >= ceiling - t) {
                return true;
            } 
            
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i-k]);
            }
        }
        
        return false;
    }
}
