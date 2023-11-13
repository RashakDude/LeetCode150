import java.util.*;

class Solution {
    public int climbStairs(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(1);
        for (int i = 2; i <= n; i++) {
            res.add(res.get(i-1) + res.get(i-2));
        }
        return res.get(n);
    }
}