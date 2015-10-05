public class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "I");    map.put(5, "V");    map.put(10, "X");
        map.put(50, "L");   map.put(100, "C");  map.put(500, "D");
        map.put(1000, "M"); map.put(4, "IV");   map.put(9, "IX");
        map.put(40, "XL");  map.put(90, "XC");  map.put(400, "CD"); map.put(900, "CM");
        
        StringBuilder sb = new StringBuilder();
        int temp = 1000;
        
        while (num > 0) {
            int curr = num / temp;
            if (curr > 0) {
                if (map.containsKey(curr*temp)) {
                    sb.append(map.get(curr*temp));
                } else {
                    while (curr > 0) {
                        if (curr >= 5) {
                            sb.append(map.get(5*temp));
                            curr = curr - 5;
                        }
                        
                        sb.append(map.get(temp));
                        curr -= 1;
                    }
                }
            }
            
            num = num % temp;
            temp = temp / 10;
        }
        
        return sb.toString();
    }
}
