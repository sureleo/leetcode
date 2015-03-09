public class RecursiveSolution {
    public Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Solution () {
        this.map.put(0, 1);
        this.map.put(1, 1);
    }
    public int climbStairs(int n) {
        if (n == 0) {
            return this.map.get(0);
        }
        if (n == 1) {
            return this.map.get(1);
        }
        int n_1 = 0;
        int n_2 = 0;
        if (this.map.containsKey(n-1)) {
            n_1 = this.map.get(n-1);
        } else {
            n_1 = climbStairs(n-1);
            this.map.put(n-1, n_1);
        }
        if (this.map.containsKey(n-2)) {
            n_2 = this.map.get(n-2);
        } else {
            n_2 = climbStairs(n-2);
            this.map.put(n-2, n_2);
        }
        return n_1 + n_2;
    }
}

public class IterativeSolution {
    public int climbStairs(int n) {
        int curr = 0;
        int m_1 = 1;
        int m_2 = 1;
        if (n <= 1) {
            return m_1;
        }
        for (int i = 2; i <= n; i++) {
            curr = m_1 + m_2;
            m_2 = m_1;
            m_1 = curr;
        }
        return curr;
    }
}
