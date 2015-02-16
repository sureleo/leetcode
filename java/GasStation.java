//Refer: http://www.cnblogs.com/zuoyuan/p/3761023.html
//I believe the key to this problem is "The solution is guaranteed to be unique."
//Otherwise, I would like to sort them and check with total is greater than 0,
//and return the index with most gas - cost.
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i ++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        if (total < 0) {
            return -1;
        } else {
            return start;
        }
    }
}
