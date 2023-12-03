import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int len = number.length();
        char[] arr = new char[len - k];
        Stack<Character> stack = new Stack();
        
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && number.charAt(i) > stack.peek() && k-- > 0) {
                stack.pop();
            }
            
            stack.push(number.charAt(i));
        }
        
        int idx = 0;
        while(idx < arr.length) {
            arr[idx] = stack.get(idx++);
        }
        
        return new String(arr);
    }
}