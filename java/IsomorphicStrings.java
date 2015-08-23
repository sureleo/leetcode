public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<Character, Character>();
        Map<Character, Character> mapT = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (mapS.containsKey(s.charAt(i))) {
                if (mapS.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                mapS.put(s.charAt(i), t.charAt(i));
            }
            
            if (mapT.containsKey(t.charAt(i))) {
                if (mapT.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                mapT.put(t.charAt(i), s.charAt(i));
            }
        }
        
        return true;
    }
}
