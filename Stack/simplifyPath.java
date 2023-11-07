import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();    
        String[] res = path.trim().split("/");
        for (String s : res) {
            if (s.equals("") || s.equals(".")) continue;
            else if (s.equals("..") && !st.isEmpty()) st.pop();
            else if (!s.equals("..") && !s.equals(".")) st.push(s);
        }
        if (st.isEmpty()) return "/";
        for (String s : st) {
            if (!s.equals("")) sb.append("/" + s);
        }
        return sb.toString();
    }
}