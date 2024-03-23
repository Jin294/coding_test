import java.util.*;

class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        StringBuilder sb = new StringBuilder().append(s).reverse();
        char[] arr = sb.toString().toCharArray();
        int[] answer = new int[arr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[i] - '0';
        }
        return answer;
    }
}