public class Solution {
    public List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return this.result;
        }
        List<String> curr = new ArrayList<String>();
        this.dfs(curr, s);
        return this.result;
    }
    
    public void dfs(List<String> curr, String s) {
        if (s.length() == 0) {
            this.result.add(curr);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (this.check(s.substring(0, i+1)) == true) {
                List<String> copy = new ArrayList<String>(curr);
                copy.add(s.substring(0, i+1));
                this.dfs(copy, s.substring(i+1, s.length()));
            }
        }
    }
    
    public boolean check(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } 
            left ++;
            right --;
        }
        return true;
    }
}
