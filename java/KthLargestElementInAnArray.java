public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        
        for (int i = k; i < nums.length; i++) {
            if (heap.peek() > nums[i]) {
                continue;
            } else {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        
        return heap.peek();
    }
}
