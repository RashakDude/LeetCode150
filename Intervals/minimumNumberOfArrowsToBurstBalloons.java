import java.util.*;

class CustomComparator implements Comparator<int[]> {
    public int compare(int[] temp1, int[] temp2) {
        return Integer.compare(temp1[0], temp2[0]);
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        int res = 1;
        Arrays.sort(points, new CustomComparator());
        int second = points[0][1];
        for (int i = 1; i < n; i++) {
            if (second < points[i][0]) {
                res++;
                second = points[i][1];
            } else {
                second = Math.min(second, points[i][1]);
            }
        }
        return res;
    }
}