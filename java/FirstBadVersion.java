/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid) == true) {
                if (mid - 1 < 0 || isBadVersion(mid-1) == false) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                if (mid + 1 > n || isBadVersion(mid+1) == true) {
                    return mid + 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        
        return high;
    }
}
