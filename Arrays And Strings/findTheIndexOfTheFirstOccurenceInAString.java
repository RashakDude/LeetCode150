import java.util.*;

class Solution {
    public int strStr(String haystack, String needle) {
        int count = 0;
        int h = haystack.length();
        int n = needle.length();
        for (int i = 0; i < h; i++) {
            if (haystack.charAt(i) == needle.charAt(count)) {
                count++;
            } else {
                i = i - count;
                count = 0;
            } 
            if (count == n) return i - count + 1;
        }
        return -1;
    }
}