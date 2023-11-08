import java.util.*;

class Solution {

    public boolean canTransform(String a, String b) {
        int i = 0;
        for (int j = 0; j < a.length(); j++) {
            if (a.charAt(j) != b.charAt(j)) {
                i++;
            }
        }
        return i == 1;
    }

    public int minMutation(String start, String end, String[] bank) {
        int n = bank.length;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(bank[i]);
        }
        if (!set.contains(end)) {
            return -1;
        }
        set.clear();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int len = 0;
        set.add(start);
        while (!q.isEmpty()) {
            len++;
            int m = q.size();
            for (int i = 0; i < m; i++) {
                String temp = q.remove();
                for (int j = 0; j < bank.length; j++) {
                    if (!set.contains(bank[j])) {
                        if (canTransform(temp, bank[j])) {
                            if (bank[j].equals(end)) {
                                return len;
                            }
                            set.add(bank[i]);
                            q.add(bank[j]);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
