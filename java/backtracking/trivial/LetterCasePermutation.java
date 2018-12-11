import java.util.ArrayList;
import java.util.List;

public class LC784LetterCasePermutation {
    private List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        if (S.length() == 0) {
            result.add("");
            return result;
        }

        doDFS(S, 0, "");

        return result;
    }

    private void doDFS(String S, int currIndex, String currString) {
        if (currIndex == S.length()) {
            result.add(currString);
            return;
        }

        char currChar = S.charAt(currIndex);
        if (Character.isDigit(currChar)) {
            String nextString = currString + currChar;
            doDFS(S, currIndex+1, nextString);
        } else {
            String nextLowerString = currString + Character.toLowerCase(currChar);
            doDFS(S, currIndex+1, nextLowerString);

            String nextUpperString = currString + Character.toUpperCase(currChar);
            doDFS(S, currIndex+1, nextUpperString);
        }
    }
}
