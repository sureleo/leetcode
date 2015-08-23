public class Solution {
    public boolean isHappy(int n) {
        int curr = n;
        Set<Integer> set = new HashSet<Integer>();
        while (set.contains(curr) == false) {
            set.add(curr);
            int next = 0;
            while (curr != 0) {
                next += (curr % 10) * (curr % 10);
                curr = curr / 10;
            }

            curr = next;
        }
        
        return curr == 1;
    }
}
