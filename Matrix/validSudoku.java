import java.util.*;

class Solution {
    public boolean checkBoard(int i, int j, char[][] board) {
        HashSet<Character> set = new HashSet<>();
        int row = i + 3;
        int col = j + 3;
        for (int idx = i; idx < row; idx++) {
            for (int jdx = j; jdx < col; jdx++) {
                char c = board[idx][jdx];
                if (c != '.' && !set.add(c)) return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0 ; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                Character r = board[i][j];
                Character c = board[j][i];
                if ((r != '.' && !row.add(r)) || (c != '.' && !col.add(c))) return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkBoard(i, j, board)) return false;
            }
        }
        return true;
    }
}