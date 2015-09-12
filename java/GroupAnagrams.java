public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String org = strs[i];
            char[] chars = org.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (map.containsKey(sorted)) {
                List<String> currList = map.get(sorted);
                currList.add(org);
                map.put(sorted, currList);
            } else {
                List<String> newList = new ArrayList<String>();
                newList.add(org);
                map.put(sorted, newList);
            }
        }
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> curr = entry.getValue();
            Collections.sort(curr);
            result.add(curr);
        }
        
        return result;
    }
}
