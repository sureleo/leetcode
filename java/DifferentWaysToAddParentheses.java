public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        int k = 0;
        int curr = 0;
        while (k < input.length() && Character.isDigit(input.charAt(k))) {
            curr = curr * 10 + (int)input.charAt(k) - (int)'0';
            k += 1;
        }
        
        if (k == input.length()) {
            result.add(curr);
            return result;
        }
        
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i)) == false) {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));
                for (int m = 0; m < left.size(); m++) {
                    for (int n = 0; n < right.size(); n++) {
                        int op1 = left.get(m);
                        int op2 = right.get(n);
                        int r = 0;
                        char op = input.charAt(i);
                        if (op == '-') {
                            r = op1 - op2;
                        } else if (op == '+') {
                            r = op1 + op2;
                        } else {
                            r = op1 * op2;
                        }
                                            
                        result.add(r);
                    }
                }
            }
        }
        
        return result;
    }
}
