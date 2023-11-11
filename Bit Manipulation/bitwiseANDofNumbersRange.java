import java.util.*;

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == 0 || left == right) {
            return left;
        }
        return left & (~0 << (32 - Integer.numberOfLeadingZeros(left ^ right)));
    }
}