import java.util.*;

class Solution {
    public static List<String> res;

    public static void helper(int open, int close, String s) {
        if (open == 0 && close == 0) res.add(s);
        if (open > 0) helper(open - 1, close + 1, s + "(");
        if (close > 0) helper(open, close - 1, s + ")");
    }

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        helper(n, 0, "");
        return res;
    }
}
