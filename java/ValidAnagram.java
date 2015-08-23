public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == t) {
            return true;
        }
        
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> mapS = new HashMap<Character, Integer>();
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1);
            } else {
                mapS.put(s.charAt(i), 1);
            }
            
            if (mapT.containsKey(t.charAt(i))) {
                mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1);
            } else {
                mapT.put(t.charAt(i), 1);
            }
        }
        
        for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
            if (mapT.containsKey(entry.getKey()) == false || mapT.get(entry.getKey()).equals(mapS.get(entry.getKey())) == false) {
                return false;
            }
        }
        
        return true;
    }
}
