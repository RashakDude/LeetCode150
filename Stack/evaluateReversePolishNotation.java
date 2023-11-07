import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int a, b;
        for (String s : tokens) {
            switch(s) {
                case "+":
                    a = st.pop();
                    b = st.pop();
                    st.push(a+b);
                    break;
                case "-":
                    a = st.pop();
                    b = st.pop();
                    st.push(b-a);
                    break;
                case "*":
                    a = st.pop();
                    b = st.pop();
                    st.push(a*b);
                    break;
                case "/":
                    a = st.pop();
                    b = st.pop();
                    st.push(b/a);
                    break;
                default:
                    st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}