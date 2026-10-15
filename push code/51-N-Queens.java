
import java.util.*;

class Solution {

    public boolean isSafe(char[][] board, int row, int col) {

        // Check vertical column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void nQueen(char[][] board, int row,
                       List<List<String>> result) {

        // Base case
        if (row == board.length) {
            List<String> solution = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                solution.add(new String(board[i]));
            }

            result.add(solution);
            return;
        }

        // Try every column
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';

                nQueen(board, row + 1, result);

                // Backtracking
                board[row][j] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> result = new ArrayList<>();

        nQueen(board, 0, result);

        return result;
    }
}
