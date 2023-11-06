import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int match = 0, desired = t.length();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int i = -1, j = -1;
        while (true) {
            boolean f1 = false, f2 = false;
            while (i < s.length() - 1 && match < desired) {
                i++;
                Character c = s.charAt(i);
                map2.put(c, map2.getOrDefault(c, 0) + 1);
                if (map2.getOrDefault(c, 0) <= map.getOrDefault(c, 0)) match++;
                f1 = true;
            }
            while (j < i && match == desired) {
                String pan = s.substring(j+1, i+1);
                if (res.length() == 0 || pan.length() < res.length()) res = pan;
                j++;
                Character c = s.charAt(j);
                if (map2.get(c) == 1) map2.remove(c);
                else map2.put(c, map2.get(c)-1);
                if (map2.getOrDefault(c, 0) < map.getOrDefault(c, 0)) match--;
                f2 = true;
            }
            if (f1 == false && f2 == false) break;
        }
        return res;
    }
}