import java.util.*;

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            int count = 0;
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i >> j) % 2 == 1) {
                    count++;
                    temp.add(j + 1);
                }
            }
            if (count == k) {
                res.add(temp);
            }
        }
        return res;
    }
}
