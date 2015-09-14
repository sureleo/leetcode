public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        if (s.length() == 1) {
            return 1;
        }
        
        int opt[] = new int[s.length()+1];
        opt[0] = 1;
        opt[1] = 1;
        for (int i = 2; i < opt.length; i++) {
            int lastTwo = Integer.parseInt(s.substring(i-2, i));
            if (s.charAt(i-1) == '0') {
                if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2') {
                    opt[i] = opt[i-2];
                } else {
                    return 0;
                }
            } else if ((lastTwo >= 27 && lastTwo <= 99) || s.charAt(i-2) == '0') {
                opt[i] = opt[i-1];
            } else {
                opt[i] = opt[i-1] + opt[i-2];
            }
        }
        
        return opt[s.length()];
    }
}
