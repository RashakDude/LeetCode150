import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (m + n + 1) / 2 - partX;
            
            int maxX = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            int maxY = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            int minX = (partX == m) ? Integer.MAX_VALUE : nums1[partX];
            int minY = (partY == n) ? Integer.MAX_VALUE : nums2[partY];

            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 0) return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                else return Math.max(maxX, maxY);
            } else if (maxX > minY) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }
        return 0.0;
    }
}