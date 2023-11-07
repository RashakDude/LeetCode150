import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int begin = nums[i];
            while (i+1 < nums.length && nums[i] == nums[i+1]-1) i++;
            int end = nums[i];
            if (begin == end) res.add("" + begin);
            else res.add("" + begin + "->" + end);
        }
        return res;
    }
}