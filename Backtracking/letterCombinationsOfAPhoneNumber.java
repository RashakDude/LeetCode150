import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        String[] phone_map = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> output = new ArrayList<>();
        backtrack("", digits, phone_map, output);
        return output;
    }

    private void backtrack(String combination, String digits, String[] phone_map, List<String> output) {
        if (digits.isEmpty()) {
            output.add(combination);
        } else {
            String letters = phone_map[digits.charAt(0) - '2'];
            for (char letter : letters.toCharArray()) {
                backtrack(combination + letter, digits.substring(1), phone_map, output);
            }
        }
    }
}
