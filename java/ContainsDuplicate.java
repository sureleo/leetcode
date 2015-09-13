public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]) == true) {
                return true;
            }
            
            set.add(nums[i]);
        }
        
        return false;
    }
}