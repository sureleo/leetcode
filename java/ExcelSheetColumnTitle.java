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
