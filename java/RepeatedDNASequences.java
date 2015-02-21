import java.util.*;
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        Map<Character, Integer> ctoi = new HashMap<Character, Integer>();
        ctoi.put('A', 0);
        ctoi.put('C', 1);
        ctoi.put('G', 2);
        ctoi.put('T', 3);
        Map<Integer, Character> itoc = new HashMap<Integer, Character>();
        itoc.put(0, 'A');
        itoc.put(1, 'C');
        itoc.put(2, 'G');
        itoc.put(3, 'T');
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (s.length() < 10) {
            return result;
        }
        int first_ten = constructFirstNumber(ctoi, s.substring(0, 10));
        map.put(first_ten, 1);
        for (int i = 10; i < s.length(); i++) {
            first_ten = first_ten << 2;
            first_ten = first_ten & Integer.parseInt("0011111111111111111111", 2);
            first_ten = first_ten | ctoi.get(s.charAt(i));
            if (map.containsKey(first_ten) == false) {
                map.put(first_ten, 1);
            } else {
                map.put(first_ten, map.get(first_ten) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(translate(itoc, entry.getKey()));
            }
        }
        
        return result;
    }

    public String translate(Map<Integer, Character> itoc, int key) {
        int mask = Integer.parseInt("00111111111111111111", 2);
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            sb.append(itoc.get(key>>(2*i)));
            key = key & mask;
            mask = mask >> 2;
        }
        return sb.toString();
    }

    public int constructFirstNumber(Map<Character, Integer> ctoi, String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result << 2;
            result = result | ctoi.get(s.charAt(i));
        }
        return result;
    }

    public static void main (String args[]) {
        String s = "CCGGCCGGCCGGCC";
        Solution sol = new Solution();
        sol.findRepeatedDnaSequences(s);
    }
}
