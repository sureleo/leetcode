public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            int currCount = 1;
            char currDigit = result.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == currDigit) {
                    currCount += 1;
                } else {
                    sb.append(currCount);
                    sb.append(currDigit);
                    currCount = 1;
                    currDigit = result.charAt(j);
                }
            }
            
            sb.append(currCount);
            sb.append(currDigit);
            result = sb.toString();
        }
        
        return result;
    }
}
