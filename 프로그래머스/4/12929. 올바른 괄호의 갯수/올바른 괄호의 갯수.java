import java.util.*;

class Solution {
    static Set<String> set;
    public int solution(int n) {
        set = new HashSet<>();
        int open = n;
        int close = n;
        
        makeBrace(open, close, new String(""));
        
        return set.size();
    }
    
    public void makeBrace(int open, int close, String now) {
        if (open == 0 && close == 0) {
            isCorrect(now);
            return;
        }
        
        if (open != 0) {
            makeBrace(open - 1, close, now + "(");
        }
        if (close != 0) {
            makeBrace(open, close - 1, now + ")");
        }
    }
    
    public void isCorrect(String now) {
        Stack<Character> stack = new Stack<>();
        char[] arr = now.toCharArray();
        for (char x : arr) {
            if (x == '(') {
                stack.add(x);
            } else {
                if (stack.isEmpty()) {
                    return;
                }
                stack.pop();
            }
        }
        
        if (!stack.isEmpty()) {
            return;
        }
        
        set.add(now);
    }
}