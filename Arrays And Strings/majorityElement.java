import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int res = 0;
        int count = 0;
        for(Map.Entry<Integer, Integer> element: map.entrySet()) {
            if (element.getValue() > count) {
                res = element.getKey();
                count = element.getValue();
            }
        }
        return res;
    }
}