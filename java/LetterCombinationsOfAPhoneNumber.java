public class Solution {
    public Map<Character, String> map = new HashMap<Character, String>();
    public List<String> result = new ArrayList<String>();
    
    public void createMap() {
        this.map.put('2', "abc");
        this.map.put('3', "def");
        this.map.put('4', "ghi");
        this.map.put('5', "jkl");
        this.map.put('6', "mno");
        this.map.put('7', "pqrs");
        this.map.put('8', "tuv");
        this.map.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        this.createMap();
        List<Character> curr = new ArrayList<Character>();
        this.dfs(curr, digits);
        return this.result;
    }
    
    public void dfs(List<Character>valuelist, String digits) {
        if (digits.length() == 0) {
            if (valuelist.size() > 0) {
                this.result.add(convertListToString(valuelist));
            }
            return;
        }
        String currdigits = this.map.get(digits.charAt(0));
        for (int i = 0; i < currdigits.length(); i++) {
            List<Character> copy = new ArrayList<Character>(valuelist);
            copy.add(currdigits.charAt(i));
            dfs(copy, digits.substring(1, digits.length()));
        }
    }
    
    public String convertListToString (List<Character> valuelist) {
        StringBuilder sb = new StringBuilder(valuelist.size());
        for (int i = 0; i < valuelist.size(); i++) {
            sb.append(valuelist.get(i));
        }
        return sb.toString();
    }
}
