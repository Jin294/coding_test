import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (isCorrect(str, i))  {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isCorrect(char[] str, int idx) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length; i++) {
            char c = str[(idx + i) % str.length];
            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                default -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.pop() != c) {
                        return false;
                    }
                }
            }
        }
        
        return stack.isEmpty();
    }
}