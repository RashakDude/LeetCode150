import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character original = s.charAt(i);
            Character replacement = t.charAt(i);
            if (!map.containsKey(original)) {
                if (!map.containsValue(replacement)) map.put(original, replacement);
                else return false;
            } else {
                if (replacement != map.get(original)) return false;
            }
        }
        return true;
    }
}