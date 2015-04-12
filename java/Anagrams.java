public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String curr = new String(chars);
            if (map.containsKey(curr)) {
                map.get(curr).add(strs[i]);
            } else {
                List<String> valuelist = new ArrayList<String>();
                valuelist.add(strs[i]);
                map.put(curr, valuelist);
            }
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.addAll(entry.getValue());
            }
        }

        return result;
    }
}
