public class Solution {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<Integer>();
        this.dfs(nums, curr);
        return this.result;
    }
    
    public void dfs(int[] nums, List<Integer> curr) {
        if (nums.length == 0) {
            result.add(curr);
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            List<Integer> next = new ArrayList<Integer>(curr);
            next.add(nums[i]);
            int[] fPart = Arrays.copyOfRange(nums, 0, i);
            int[] sPart = Arrays.copyOfRange(nums, i+1, nums.length);
            int[] join = new int[fPart.length+sPart.length];
            System.arraycopy(fPart, 0, join, 0, fPart.length);
            System.arraycopy(sPart, 0, join, i, sPart.length);
            dfs(join, next);
        }
    }
}
