import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int boardLength = board.length;
        int boardArea = boardLength * boardLength;
        int[] flatten = new int[boardArea];
        boolean[] vis = new boolean[boardArea];
        boolean right = true;
        int counter = 0;
        
        for (int y = boardLength - 1; y >= 0; y--) {
            for (int x = 0; x < boardLength; x++) {
                int actual = right ? x : boardLength - 1 - x;
                flatten[counter] = board[y][actual];
                counter++;
            }
            right = !right;
        }

        int moves = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(null);
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            if (curr == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    moves++;
                }
            } else {
                if (curr == boardArea - 1) return moves;
                for (int i = curr + 1; i <= Math.min(curr + 6, boardArea - 1); i++) {
                    int actualMove = flatten[i] == -1 ? i : flatten[i] - 1;
                    if (vis[actualMove]) continue;
                    vis[i] = true;
                    vis[actualMove] = true;
                    q.add(actualMove);
                }
            }
        }

        return -1;
    }
}