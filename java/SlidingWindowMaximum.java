public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length-k+1];
        int resultIndex = 0;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (deque.isEmpty() == false && i-deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            
            while (deque.isEmpty() == false && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            if (i >= k - 1) {
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex += 1;
            }
        }
        
        return result;
    }
}
