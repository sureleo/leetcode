public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] degreeMap = new int[numCourses];
        int rows = prerequisites.length;
        
        for (int i = 0; i < rows; i++) {
            int key = prerequisites[i][1];
            if (map.containsKey(key)) {
                List<Integer> next = new ArrayList<Integer>(map.get(key));
                next.add(prerequisites[i][0]);
                degreeMap[prerequisites[i][0]] += 1;
                map.put(key, next);
            } else {
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(prerequisites[i][0]);
                degreeMap[prerequisites[i][0]] += 1;
                map.put(key, newList);
            }
        }
        
        List<Integer> inDegreeZero = new ArrayList<Integer>();
        for (int i = 0; i < degreeMap.length; i++) {
            if (degreeMap[i] == 0) {
                inDegreeZero.add(i);
            }
        }
        
        while (inDegreeZero.size() > 0) {
            int lastOne = inDegreeZero.remove(inDegreeZero.size() - 1);
            if (map.containsKey(lastOne) == false) {
                continue;
            }
            
            for (int i = 0; i < map.get(lastOne).size(); i++) {
                int currElement = map.get(lastOne).get(i);
                degreeMap[currElement] -= 1;
                if (degreeMap[currElement] == 0) {
                    inDegreeZero.add(currElement);
                }
            }
            
            map.remove(lastOne);
        }
        
        return map.size() == 0;
    }
}
