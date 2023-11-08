import java.util.*;

class Solution {
    int[] parent;

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int size = n * m + 1;
        parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((j == m - 1 || i == n - 1 || j == 0 || i == 0) && board[i][j] == 'O') {
                    union(size - 1, i * m + j);
                }
                if (i < n - 1 && board[i][j] == 'O' && board[i + 1][j] == 'O') {
                    union((i + 1) * m + j, i * m + j);
                }
                if (j < m - 1 && board[i][j] == 'O' && board[i][j + 1] == 'O') {
                    union(i * m + j, i * m + j + 1);
                }
            }
        }
        int flag = find(size - 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && find(i * m + j) != flag) {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    public boolean union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp == yp) return false;
        parent[yp] = xp;
        return true;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
}
