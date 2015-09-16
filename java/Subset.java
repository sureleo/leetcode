public class Solution {
    public List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<Integer>();
        this.dfs(nums, curr);
        return result;
    }
    
    public void dfs(int[] nums, List<Integer> curr) {
        result.add(curr);
        
        for (int i = 0; i < nums.length; i++) {
            List<Integer> next = new ArrayList<Integer>(curr);
            next.add(nums[i]);
            dfs(Arrays.copyOfRange(nums, i + 1, nums.length), next);
        }
    }
}
