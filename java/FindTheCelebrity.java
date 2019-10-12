/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            candidates.add(i);
        }
        
        while (candidates.size() != 1) {
            List<Integer> newCandidates = new ArrayList<>();
            for (int i = 0; i < candidates.size(); i = i + 2) {
                if ((i + 1) == candidates.size()) {
                    newCandidates.add(candidates.get(i));
                    continue;
                }
                
                if (knows(candidates.get(i), candidates.get(i+1))) {
                    newCandidates.add(candidates.get(i+1));
                } else {
                    newCandidates.add(candidates.get(i));
                }
            }
            
            candidates = new ArrayList<>(newCandidates);
        }
        
        int lastOne = candidates.get(0);
        for (int i = 0; i < n; i++) {
            if (i == lastOne) {
                continue;
            }
            
            if (knows(lastOne, i) || !knows(i, lastOne)) {
                return -1;
            }
        }
        
        return lastOne;
    }
}
