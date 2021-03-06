public class Solution {
    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] > citations.length - mid) {
                high = mid - 1;
            } else if (citations[mid] < citations.length - mid) {
                low = mid + 1;
            } else {
                return citations.length - mid;
            }
        }
        
        return citations.length - low;
    }
}
