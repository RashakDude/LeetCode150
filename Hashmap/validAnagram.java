import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (map.get(c) != null) {
                if (map.get(c) == 1) map.remove(c);
                else map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}