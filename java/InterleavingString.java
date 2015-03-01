public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[][] opt = new Boolean[s2.length()+1][s1.length()+1];
        for (Boolean[] row : opt) {
            Arrays.fill(row, false);
        }
        opt[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            opt[0][i] = s1.charAt(i-1) == s3.charAt(i-1) && opt[0][i-1];
        }

        for (int i = 1; i <= s2.length(); i++) {
            opt[i][0] = s2.charAt(i-1) == s3.charAt(i-1) && opt[i-1][0];
        }

        for (int i = 1; i <= s2.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {
                char last_s1 = s1.charAt(j-1);
                char last_s2 = s2.charAt(i-1);
                char last_s3 = s3.charAt(i+j-1);
                opt[i][j] = (last_s1 == last_s3 && opt[i][j-1]) || (last_s2 == last_s3 && opt[i-1][j]);
            }
        }
        return opt[s2.length()][s1.length()];
    }
}
