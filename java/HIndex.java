public class Solution {
    public int hIndex(int[] citations) {
        int buckets[] = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length) {
                buckets[citations.length] += 1;
            } else {
                buckets[citations[i]] += 1;
            }
        }
        
        int sum = 0;
        for (int i = citations.length; i >= 0; i--) {
            sum += buckets[i];
            if (sum >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
