public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        
        for (int i = 0; i < s.length(); i ++) {
            if (map.containsKey(s.charAt(i)) == false) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() == true || map.get(s.charAt(i)) != stack.pop()) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
