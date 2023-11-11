import java.util.*;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1, -1};
        ans[0] = first(nums, target);
        ans[1] = last(nums, target);
        return ans;
    }

    private int first(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= x) {
                if (arr[mid] == x)
                    ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private int last(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= x) {
                if (arr[mid] == x)
                    ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}