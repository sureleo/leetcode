public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.", 0);
        String[] v2 = version2.split("\\.", 0);
        if (v2.length > v1.length) {
            return -compareVersion(version2, version1);
        }
        
        for (int i = 0; i < v2.length; i++) {
            int one = Integer.parseInt(v1[i]);
            int two = Integer.parseInt(v2[i]);
            if (one == two) {
                continue;
            } else if (one < two) {
                return -1;
            } else {
                return 1;
            }
        }
        
        for (int i = v2.length; i < v1.length; i++) {
            if (Integer.parseInt(v1[i]) != 0) {
                return 1;
            }
        }
        
        return 0;
    }
}
