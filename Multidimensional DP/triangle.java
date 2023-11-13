import java.util.*;

class Solution {
    long[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new long[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (long[] row : dp) Arrays.fill(row, Long.MIN_VALUE);
        return dfs(0, 0, triangle);
    }

    public int dfs(int level, int index, List<List<Integer>> triangle) {
        if (level > triangle.size() - 1) return 0;
        if (dp[level][index] != Long.MIN_VALUE) return (int) dp[level][index];
        int path = triangle.get(level).get(index); // get the current value
        if (level < triangle.size() - 1) path += Math.min(dfs(level + 1, index, triangle), dfs(level + 1, index + 1, triangle));
        dp[level][index] = (long) path;
        return path;
    }
}
