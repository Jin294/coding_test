import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        // 1. arr의 뒤쪽 원소부터 스택에 넣는다
        // 2. 만약 넣으려는 원소가 스택의 윗부분과 일치하면 버리기
        // 3. arr의 모든 원소를 검사하면, 스택에서 꺼내서 리턴
        
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i > -1; i--) {
            if (stack.isEmpty()) {
                stack.add(arr[i]);
            } else {
                int peek = stack.peek();
                if (arr[i] != peek) {
                    stack.add(arr[i]);
                }
            }
        }

        int[] answer = new int[stack.size()];
        int idx = 0;
        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop();
        }
        return answer;
    }
}