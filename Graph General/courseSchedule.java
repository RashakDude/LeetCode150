import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] in = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            in[prerequisites[i][1]]++;
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int temp = q.poll();
            for (int i : adj.get(temp)) {
                in[i]--;
                if (in[i] == 0) q.add(i);
            }
        }
        return count == numCourses;
    }
}