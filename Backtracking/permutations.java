import java.util.*;

class Solution {

    public void swap(int start, int end, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public void helper(int i, int[] nums, List<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int num: nums) temp.add(num);
            res.add(temp); 
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(i, j, nums);
            helper(i + 1, nums, res);
            swap(i, j, nums);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, res);
        return res;
    }
}
