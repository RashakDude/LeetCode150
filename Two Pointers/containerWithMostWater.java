import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int width = right - left;
            int height1 = Math.min(height[left], height[right]);
            int area = width * height1;
            res = Math.max(res, area);
            if (height[left] < height[right]) left++;
            else if (height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }
        return res;
    }
}