public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int slow = 0;
        int fast = 0;
        List<String> result = new ArrayList<String>();
        if (fast == nums.length) {
            return result;
        }
        
        while (fast < nums.length) {
            if ((fast - slow ) == (nums[fast] - nums[slow])) {
                fast += 1;
            } else {
                StringBuilder sb = new StringBuilder();
                if (fast == slow + 1) {
                    sb.append(nums[slow]);
                } else {
                    sb.append(nums[slow]);
                    sb.append("->");
                    sb.append(nums[fast-1]);
                }
                
                slow = fast;
                result.add(sb.toString());
            }
        }
        
        if (fast == slow + 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[slow]);
            result.add(sb.toString());
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[slow]);
            sb.append("->");
            sb.append(nums[fast-1]);
            result.add(sb.toString());
        }
        
        return result;
    }
}
