import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int c = 0;
            char[] m = s.toCharArray();
            Arrays.sort(m);
            String temp = String.valueOf(m);
            if (map.containsKey(temp)) map.get(temp).add(s);
            else {
                map.put(temp, new ArrayList<>());
                map.get(temp).add(s);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> s : map.entrySet()) res.add(s.getValue());
        return res;
    }
}