import java.util.*;

class Solution {

    public void helper(int i, int target, int[] candidates, List<List<Integer>> res, List<Integer> temp) {
        if (i == candidates.length) {
            if (target == 0) res.add(new ArrayList<>(temp));
            return;
        }
        if (target >= candidates[i]) {
            temp.add(candidates[i]);
            helper(i, target - candidates[i], candidates, res, temp);
            temp.remove(temp.size() - 1);
        }
        helper(i + 1, target, candidates, res, temp);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(0, target, candidates, res, temp);
        return res;
    }
}
