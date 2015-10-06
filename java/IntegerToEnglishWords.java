public class Solution {
    public String fetch(int num) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(100, "Hundred");    map.put(90, "Ninety");
        map.put(80, "Eighty");   map.put(70, "Seventy");    map.put(60, "Sixty");
        map.put(20, "Twenty");  map.put(19, "Nineteen");    map.put(18, "Eighteen");
        map.put(17, "Seventeen");   map.put(16, "Sixteen"); map.put(15, "Fifteen");
        map.put(14, "Fourteen"); map.put(13, "Thirteen");    map.put(12, "Twelve");
        map.put(50, "Fifty");   map.put(40, "Forty");   map.put(30, "Thirty");
        map.put(8, "Eight");    map.put(7, "Seven");    map.put(6, "Six");
        map.put(10, "Ten"); map.put(9, "Nine"); map.put(11, "Eleven");
        map.put(5, "Five"); map.put(4, "Four"); map.put(3, "Three");
        map.put(2, "Two");  map.put(1, "One");

        StringBuilder sb = new StringBuilder();
        int temp = 100;
        while (num > 0) {
            int digit = num / temp;
            if (digit > 0) {
                if (temp == 100) {
                    sb.append(map.get(digit));
                    sb.append(" ");
                    sb.append(map.get(100));
                } else {
                    if (map.containsKey(num)) {
                        sb.append(map.get(num));
                        num = 0;
                        break;
                    }

                    sb.append(map.get(digit*temp));
                }
            }

            num = num % temp;
            temp = temp / 10;
            if (num != 0 && digit != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = -1;
        String[] strs = {" Thousand", " Million", " Billion"};
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            String curr = fetch(num % 1000);
            StringBuilder extra = new StringBuilder();
            if (i >= 0 && curr.length() > 0) {
                extra.append(strs[i]);
                if (sb.length() > 0) {
                    extra.append(" ");
                }
            }

            sb.insert(0, extra);
            sb.insert(0, curr);
            i += 1;
            num = num / 1000;
        }

        return sb.toString();
    }
}
