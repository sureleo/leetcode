//http://www.cnblogs.com/springfor/p/3889222.html
//compare to code I wrote about two month ago, 
//this approach is way easier
//my way is a little bit hacky
public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
        List<Integer> result = new ArrayList<Integer>();
        result = grayCode(n-1);
        int addNumber = 1 << n-1;
        for (int i = result.size()-1; i >= 0; i--) {
            result.add(addNumber + result.get(i));
        }
        return result;
    }
}
