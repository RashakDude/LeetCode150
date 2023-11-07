import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<List<Integer>> items = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i+1 < intervals.length && end >= intervals[i+1][0]) {
                end = Math.max(end, intervals[i+1][1]);
                i++;
            }
            List<Integer> row = new ArrayList<>();
            row.add(start);
            row.add(end);
            items.add(row);
        }
        int[][] res = new int[items.size()][2];
        for (int i = 0; i < items.size(); i++) {
            res[i][0] = items.get(i).get(0);
            res[i][1] = items.get(i).get(1);
        }
        return res;
    }
}