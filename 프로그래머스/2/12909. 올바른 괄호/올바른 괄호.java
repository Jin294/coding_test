import java.util.*;

class Solution {
    boolean solution(String s) {
        int len = s.length();
                
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char x = s.charAt(i);
            if (x == '(') {
                stack.push(x);
            } else { // x = ')'
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}