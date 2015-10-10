public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graphMap = new HashMap<Integer, List<Integer>>();
        int[] degreeMap = constructMap(graphMap, numCourses, prerequisites);
        List<Integer> inDegreeZero = new ArrayList<Integer>();
        for (int i = 0; i < degreeMap.length; i++) {
            if (degreeMap[i] == 0) {
                inDegreeZero.add(i);
            }
        }

        int[] order = new int[numCourses];
        int orderIdx = 0;
        while (inDegreeZero.size() > 0) {
            int curr = inDegreeZero.remove(inDegreeZero.size() - 1);
            order[orderIdx] = curr;
            orderIdx += 1;
            if (graphMap.containsKey(curr) == false) {
                continue;
            }

            List<Integer> currNei = graphMap.get(curr);
            for (int i = 0; i < currNei.size(); i++) {
                degreeMap[currNei.get(i)] -= 1;
                if (degreeMap[currNei.get(i)] == 0) {
                    inDegreeZero.add(currNei.get(i));
                }
            }

            graphMap.remove(curr);
        }

        if (graphMap.size() > 0) {
            return new int[0];
        } else {
            return order;
        }
    }

    public int[] constructMap(Map<Integer, List<Integer>> graphMap, int numCourses, int[][] pre) {
        int[] degreeMap = new int[numCourses];
        int rows = pre.length;
        for (int i = 0; i < rows; i++) {
            int key = pre[i][1];
            if (graphMap.containsKey(key)) {
                List<Integer> curr = graphMap.get(key);
                curr.add(pre[i][0]);
                degreeMap[pre[i][0]] += 1;
                graphMap.put(key, curr);
            } else {
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(pre[i][0]);
                degreeMap[pre[i][0]] += 1;
                graphMap.put(key, newList);
            }
        }

        return degreeMap;
    }
}
