public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = {0, 0};
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i]) == false) {
                map.put(target-numbers[i], i);
            } else {
                result[0] = map.get(numbers[i]) + 1;
                result[1] = i + 1;
            }
        }
        return result;
    }
}
