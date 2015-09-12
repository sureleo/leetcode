// http://www.programcreek.com/2014/03/leetcode-repeated-dna-sequences-java/
// This solution is way better than my solution in 6 months ago.

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        
        Set<Integer> hashSet = new HashSet<Integer>();
        Set<Integer> resultSet = new HashSet<Integer>();
        List<String> result = new ArrayList<String>();
        int hash = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i < 9) {
                hash = (hash << 2) + map.get(s.charAt(i));
            } else {
                hash = (hash << 2) + map.get(s.charAt(i));
                hash = hash & ((1 << 20) - 1);
                if (hashSet.contains(hash) == true && resultSet.contains(hash) == false) {
                    result.add(s.substring(i - 9, i + 1));
                    resultSet.add(hash);
                } else {
                    hashSet.add(hash);
                }
            }
        }
        
        return result;
    }
}
