import java.util.*;
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.", 0);
        String[] v2 = version2.split("\\.", 0);
        int i = 0;
        while (i < v1.length && i < v2.length) {
            int curr_v1 = Integer.parseInt(v1[i]);
            int curr_v2 = Integer.parseInt(v2[i]);
            if (curr_v1 > curr_v2) {
                return 1;
            } else if (curr_v1 < curr_v2) {
                return -1;
            } else {
                i += 1;
            }
        }
        if (i == v1.length && i == v2.length) {
            return 0;
        } else if(i == v1.length) {
            while (i < v2.length && Integer.parseInt(v2[i]) == 0) {
                i += 1;
            }
            if (i == v2.length) {
                return 0;
            } else {
                return -1;
            }
        } else {
            while (i < v1.length && Integer.parseInt(v1[i]) == 0) {
                i += 1;
            }
            if (i == v1.length) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static void main (String[] args) {
        String version1 = "1.0";
        String version2 = "1";
        Solution sol = new Solution();
        System.out.println(sol.compareVersion(version1, version2));
    }
}
