public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int currIndex = m + n - 1;
        int indexOne = m - 1;
        int indexTwo = n - 1;
        while (indexOne >= 0 && indexTwo >= 0) {
            if (nums1[indexOne] > nums2[indexTwo]) {
                nums1[currIndex] = nums1[indexOne];
                indexOne -= 1;
            } else {
                nums1[currIndex] = nums2[indexTwo];
                indexTwo -= 1;
            }
            
            currIndex -= 1;
        }
        
        while (indexTwo >= 0) {
            nums1[currIndex] = nums2[indexTwo];
            currIndex -= 1;
            indexTwo -= 1;
        }
    }
}
