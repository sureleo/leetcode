public class Solution {
    public String convertToTitle(int n) {
        String map = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int temp = n % 26;
            sb.append(map.charAt(n%26));
            if (temp == 0) {
                temp = 26;
            }
            n = (n - temp) / 26;
        }

        return sb.reverse().toString();
    }
}

// This solution is way more succint than mine.
// http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-title-java/
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            n --;
            sb.append((char)(n % 26 + 'A'));
            n = n / 26;
        }
        
        return sb.reverse().toString();
    }
}
