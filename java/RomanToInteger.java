public class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);    map.put("V", 5);    map.put("X", 10);
        map.put("L", 50);   map.put("C", 100);  map.put("D", 500);
        map.put("M", 1000); map.put("IV", 4);   map.put("IX", 9);
        map.put("XL", 40);  map.put("XC", 90);  map.put("CD", 400); map.put("CM", 900);
        
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i > 1) {
                String twoTemp = s.substring(i, i+2);
                if (map.containsKey(twoTemp)) {
                    result += map.get(twoTemp);
                    i += 1;
                    continue;
                }
            }
            
            String oneTemp = s.substring(i, i+1);
            result += map.get(oneTemp);
        }
        
        return result;
    }
}
