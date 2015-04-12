import java.util.*;
public class Solution {
    public List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        List<String> valuelist = new ArrayList<String>();
        this.dfs(s, valuelist);
        return this.result;
    }
    
    public void dfs(String s, List<String> valuelist) {
        if (s == null || s.length() == 0) {
            this.result.add(valuelist);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String curr = s.substring(0, i+1);
            if (this.check(curr) == true) {
                List<String> newList = new ArrayList<String>(valuelist);
                newList.add(curr);
                this.dfs(s.substring(i+1, s.length()), newList);
            }
        }
    }
    
    public boolean check (String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main (String args[]) {
        System.out.println("".length());
    }
}
