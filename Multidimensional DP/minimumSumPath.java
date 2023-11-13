import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                int right = j >= 1 ? dp[i][j-1] + grid[i][j] : Integer.MAX_VALUE;
                int down = i >= 1 ? dp[i-1][j] + grid[i][j] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}