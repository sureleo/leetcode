import java.util.*;
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        Map <Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<List<Integer>> result_set = new HashSet<List<Integer>>();
        for (int i = 0; i < num.length-1; i++) {
            for (int j = i+1; j < num.length; j++) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(i);
                l.add(j);
                int key = num[i] + num[j];
                if (map.containsKey(key) == false) {
                    List<List<Integer>> curr = new ArrayList<List<Integer>>();
                    curr.add(l);
                    map.put(key, curr);
                } else {
                    List<List<Integer>> curr = map.get(key);
                    curr.add(l);
                    map.put(key, curr);
                }
            }
        }

        for (Map.Entry<Integer, List<List<Integer>>> entry : map.entrySet()) {
            if (map.containsKey(target-entry.getKey())) {
                List<List<Integer>> e = map.get(entry.getKey());
                List<List<Integer>> t_e = map.get(target-entry.getKey());
                for (int i = 0; i < e.size(); i++) {
                    for (int j = 0; j < t_e.size(); j++) {
                        if (e.get(i).get(1) < t_e.get(j).get(0) || e.get(i).get(0) > t_e.get(j).get(1)) {
                            int[] indices = {e.get(i).get(1), e.get(i).get(0), t_e.get(j).get(0), t_e.get(j).get(1)};
                            Arrays.sort(indices);
                            List<Integer> curr_result = new ArrayList<Integer>();
                            curr_result.add(num[indices[0]]);
                            curr_result.add(num[indices[1]]);
                            curr_result.add(num[indices[2]]);
                            curr_result.add(num[indices[3]]);
                            result_set.add(curr_result);
                        }
                    }
                }
            }
        }

        result.addAll(result_set);

        return result;
    }

    public static void main (String[] args) {
        int[] num = {-3, -1, 0, 2, 4, 5};
        int target = 0;
        Solution sol = new Solution();
        System.out.println(sol.fourSum(num, target));
    }
}
