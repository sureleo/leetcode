public class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] sums = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                sums[i+j] += ((int)num1.charAt(i)-(int)'0') * ((int)num2.charAt(j)-(int)'0');
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < sums.length; i++) {
            int sum = sums[i] + carry;
            int digit = sum % 10;
            carry = sum / 10;
            sb.append(digit);
        }
        
        sb = sb.reverse();
        
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
