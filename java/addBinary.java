public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        
        StringBuilder sb = new StringBuilder();
        int length = b.length();
        int carry = 0;
        for (int i = length-1; i >= 0; i--) {
            int temp = Character.getNumericValue(a.charAt(i+a.length()-b.length())) + Character.getNumericValue(b.charAt(i)) + carry;
            carry = temp / 2;
            sb.append(temp % 2);
        }
        
        for (int i = a.length() - b.length() - 1; i >= 0; i--) {
            int temp = Character.getNumericValue(a.charAt(i)) + carry;
            carry = temp / 2;
            sb.append(temp % 2);
        }
        
        if (carry == 1) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}
