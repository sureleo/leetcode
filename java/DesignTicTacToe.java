class TicTacToe {
    
    private int[][] board;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        
        if (isRowWin(row, col, player) || isColWin(row, col, player) || isDiagnalWin(row, col, player) || isReverseDiagnalWin(row, col, player)) {
            return player;
        }
        
        return 0;
    }
    
    private boolean isRowWin(int row, int col, int player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != player) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isColWin(int row, int col, int player) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != player) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isDiagnalWin(int row, int col, int player) {
        if (row != col) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != player) {
                return false;
            }
        }

        return true;
    }
    
    private boolean isReverseDiagnalWin(int row, int col, int player) {
        if (row + col != board.length - 1) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length - i - 1] != player) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
