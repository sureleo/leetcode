public class MathSolution {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int i = 0; i < nums.length+1; i++) {
            sum += i;
        }
        
        return sum - IntStream.of(nums).sum();
    }
}

public class MathSolution {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i] ^ i;
        }
        
        return result ^ nums.length;
    }
}
