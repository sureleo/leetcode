// http://www.cnblogs.com/grandyang/p/4854466.html
// is this Finite State Machine?
public class Solution {
    public void gameOfLife(int[][] board) {
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int countLive = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < row && y >= 0 && y < col && (board[x][y] == 1 || board[x][y] == 2)) {
                        countLive += 1;
                    }
                }
                
                if ((board[i][j] == 1 || board[i][j] == 2) && (countLive < 2 || countLive > 3)) {
                    board[i][j] = 2;
                }
                
                if ((board[i][j] == 0 || board[i][j] == 3) && countLive == 3) {
                    board[i][j] = 3;
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
