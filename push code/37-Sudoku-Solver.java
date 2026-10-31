
class Solution {

    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        // Initialize bitmasks
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int num = board[r][c] - '1';
                    int bit = 1 << num;

                    rows[r] |= bit;
                    cols[c] |= bit;
                    boxes[(r / 3) * 3 + c / 3] |= bit;
                }
            }
        }

        solve(board, rows, cols, boxes);
    }

    private boolean solve(char[][] board,
                          int[] rows,
                          int[] cols,
                          int[] boxes) {

        int minOptions = 10;
        int bestR = -1, bestC = -1;
        int bestMask = 0;

        // Find empty cell with minimum possibilities
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] != '.') continue;

                int box = (r / 3) * 3 + c / 3;

                int mask = 0x1FF &
                        ~(rows[r] | cols[c] | boxes[box]);

                int count = Integer.bitCount(mask);

                if (count == 0) return false;

                if (count < minOptions) {
                    minOptions = count;
                    bestR = r;
                    bestC = c;
                    bestMask = mask;
                }
            }
        }

        // Sudoku solved
        if (bestR == -1) return true;

        int box = (bestR / 3) * 3 + bestC / 3;

        // Try available numbers
        while (bestMask != 0) {

            int bit = bestMask & -bestMask;
            bestMask -= bit;

            int num = Integer.numberOfTrailingZeros(bit);

            board[bestR][bestC] = (char) ('1' + num);

            rows[bestR] |= bit;
            cols[bestC] |= bit;
            boxes[box] |= bit;

            if (solve(board, rows, cols, boxes)) {
                return true;
            }

            // Backtracking
            board[bestR][bestC] = '.';

            rows[bestR] ^= bit;
            cols[bestC] ^= bit;
            boxes[box] ^= bit;
        }

        return false;
    }
}
