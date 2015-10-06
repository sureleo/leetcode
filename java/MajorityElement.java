public class DivideAndConquerSolution {
    public int majorityElementDivideAndConquer(int[] num) {
        if (num.length == 1 || num.length == 2) {
            return num[0];
        }
        
        int left = majorityElement(Arrays.copyOfRange(num, 0, (num.length-1)/2+1));
        int right = majorityElement(Arrays.copyOfRange(num, (num.length-1)/2+1, num.length));
        
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == left) {
                leftCount += 1;
            }
            if (num[i] == right) {
                rightCount += 1;
            }
        }
        if (leftCount > rightCount) {
            return left;
        } else {
            return right;
        }
    }
}

public class MooreVotingSolution {
    public int majorityElement(int[] nums) {
        int curr = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curr) {
                times += 1;
            } else {
                times -= 1;
                if (times == 0) {
                    times = 1;
                    curr = nums[i];
                }
            }
        }
        
        return curr;
    }
}
