import java.util.*;
public class Solution {
    public String word;
    public char[][] board;
    public boolean result = false;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int row = board.length;
        if (row == 0) {
            return this.word.length() == 0;
        }
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.dfs(i, j, 0);
            }
        }
        return this.result;
    }
    
    public void dfs(int row, int col, int curr) {
        if (this.result == true) {
            return;
        }
        if (this.word.charAt(curr) == this.board[row][col]) {
            if (curr == this.word.length()-1) {
                this.result = true;
                return;
            }
            char temp = this.board[row][col];
            this.board[row][col] = '.';
            if (row > 0) {
                this.dfs(row-1, col, curr+1);
            }
            if (row < this.board.length-1) {
                this.dfs(row+1, col, curr+1);
            }
            if (col > 0) {
                this.dfs(row, col-1, curr+1);
            }
            if (col < this.board[0].length-1) {
                this.dfs(row, col+1, curr+1);
            }
            this.board[row][col] = temp;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = new char[1][1];
        board[0][0] = 'a';
        String s = "a";
        sol.exist(board, s);
        System.out.println(sol.result);
    }
}
