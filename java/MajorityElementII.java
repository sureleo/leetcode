public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0) {
            return result;
        }

        if (nums.length <= 2) {
            result.add(nums[0]);
            if (nums.length == 2 && nums[0] != nums[1]) {
                result.add(nums[1]);
            }

            return result;
        }

        int n1 = nums[0];
        int c1 = 1;
        int twoIdx = 1;
        while (twoIdx < nums.length) {
            if (nums[twoIdx] != n1) {
                break;
            } else {
                c1 += 1;
                twoIdx += 1;
            }
        }

        if (twoIdx == nums.length) {
            result.add(n1);
            return result;
        }

        int n2 = nums[twoIdx];
        int c2 = 1;

        for (int i = twoIdx+1; i < nums.length; i++) {
            if (n1 == nums[i]) {
                c1 += 1;
            } else if (n2 == nums[i]) {
                c2 += 1;
            } else if (c1 == 0) {
                c1 = 1;
                n1 = nums[i];
            } else if (c2 == 0) {
                c2 = 1;
                n2 = nums[i];
            } else {
                c1 -= 1;
                c2 -= 1;
            }
        }

        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n1) {
                count1 += 1;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(n1);
        }

        if (n1 != n2) {
            int count2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == n2) {
                    count2 += 1;
                }
            }

            if (count2 > nums.length / 3) {
                result.add(n2);
            }
        }

        return result;
    }
}
