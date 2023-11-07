import java.util.*;

class Solution {
    public int next (int n) {
        int res = 0;
        while (n > 0) {
            int rem = n % 10;
            res += (rem * rem);
            n /= 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = next(slow);
            fast = next(next(fast));
        } while (slow != fast);
        return slow == 1;
    }
}