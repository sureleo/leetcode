//http://blog.csdn.net/worldwindjp/article/details/19251995
//if current is already a ".", we don't need to search it anymore
class Pair {
    int x;
    int y;
    Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0) {
            return;
        }
        int cols = board[0].length;
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') {
                this.doBFS(0, i, board);
            }
            if (board[rows-1][i] == 'O') {
                this.doBFS(rows-1, i, board);
            }
        }
        for (int i = 1; i < rows - 1; i++) {
            if (board[i][0] == 'O') {
                this.doBFS(i, 0, board);
            }
            if (board[i][cols-1] == 'O') {
                this.doBFS(i, cols-1, board);
            }
        }
        this.generateResult(board);
    }

    public void generateResult(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void doBFS (int i, int j, char[][] board) {
        Queue<Pair> queue = new LinkedList<Pair>();
        Pair curr = new Pair(i, j);
        queue.add(curr);
        while (queue.isEmpty() == false) {
            Pair temp = queue.poll();
            int row = temp.x;
            int col = temp.y;
            if (board[row][col] == '.') {
                continue;
            }
            board[row][col] = '.';
            if (row - 1 >= 0 && board[row-1][col] == 'O') {
                queue.add(new Pair(row-1, col));
            }
            if (row + 1 < board.length && board[row+1][col] == 'O') {
                queue.add(new Pair(row+1, col));
            }
            if (col - 1 >= 0 && board[row][col-1] == 'O') {
                queue.add(new Pair(row, col-1));
            }
            if (col + 1 < board[0].length && board[row][col+1] == 'O') {
                queue.add(new Pair(row, col+1));
            }
        }
    }
}
