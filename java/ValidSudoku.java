public class Solution {
    public boolean isValidSudoku(char[][] board) {
        return this.checkRow(board) && this.checkCol(board) && this.checkSub(board);
    }
    
    public boolean checkRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j]) == true) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
    
    public boolean checkCol(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i]) == true) {
                        return false;
                    } else {
                        set.add(board[j][i]);
                    }
                }
            }
        }
        return true;
    }
    
    public boolean checkSub (char[][] board) {
        for (int m = 0; m <= 6; m += 3) {
            for (int n = 0; n <= 6; n += 3) {
                Set<Character> set = new HashSet<Character>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i+m][j+n] != '.') {
                            if (set.contains(board[i+m][j+n]) == true) {
                                return false;
                            } else {
                                set.add(board[i+m][j+n]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
