import java.util.*;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];
        for (Character c : magazine.toCharArray()) charCount[c-'a']++;
        for (Character c : ransomNote.toCharArray()) {
            if (!(charCount[c-'a'] > 0)) return false;
            charCount[c-'a']--;
        }
        return true;
    }
}