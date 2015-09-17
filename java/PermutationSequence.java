public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        List<Integer> list = new ArrayList<Integer>();
        int category = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            if (i != n) {
                category = category * i;
            }
        }

        k = k - 1;
        while (result.length() < n) {
            int index = k / category;
            result.append(list.get(index));
            list.remove(index);

            k = k % category;
            if (n != result.length()) {
                category = category / (n - result.length());
            }
        }

        return result.toString();
    }
}
