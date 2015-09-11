class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        if (denominator == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sb.append("-");
        }
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        long quotient = num / den;
        sb.append(quotient);
        long remainder = num % den;
        if (remainder == 0) {
            return sb.toString();
        }
        
        sb.append(".");
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (remainder != 0 && map.containsKey(remainder) == false) {
            long nextDigit = remainder * 10 / den;
            map.put(remainder, sb.length());
            sb.append(nextDigit);
            remainder = remainder * 10 % den;
        }
        
        if (remainder != 0) {
            int insertion = map.get(remainder);
            sb.insert(insertion, "(");
            sb.append(")");
        }
        
        return sb.toString();
    }
}
