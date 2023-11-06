import java.util.*;

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (citations[i] > citations.length) {
                freq[citations.length]++;
            } else {
                freq[citations[i]]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += freq[i];
            if (count >= i) return i;
        }
        return 0;
    }
}