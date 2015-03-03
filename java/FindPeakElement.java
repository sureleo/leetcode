public class Solution {
    public int findPeakElement(int[] num) {
        int low = 0;
        int high = num.length-1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid != 0 && num[mid-1]>num[mid]) {
                high = mid - 1;
            } else if (mid != num.length-1 && num[mid+1] > num[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return mid;
    }
}
