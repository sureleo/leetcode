class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(a);
        sb1.append(b);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b);
        sb2.append(a);
        String op1 = sb1.toString();
        String op2 = sb2.toString();
        if (op1.compareTo(op2) > 0) {
            return 1;
        } else if (op1.compareTo(op2) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        Collections.sort(list, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
