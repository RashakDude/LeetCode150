import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length, pc[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            pc[i][0] = profits[i];
            pc[i][1] = capital[i];
        }
        Arrays.sort(pc, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int maxCap = w, i = 0;
        while (k-- > 0) {
            for (; i < n && maxCap >= pc[i][1]; i++)
                pq.add(pc[i]);
            if (pq.isEmpty())
                break;
            maxCap += pq.poll()[0];
        }
        return maxCap;
    }
}