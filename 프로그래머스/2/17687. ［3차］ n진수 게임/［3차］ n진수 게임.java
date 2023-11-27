import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        // 1. 전체 수를 n진법으로 변환
        StringBuilder sb = new StringBuilder();
        for (int i = 0; sb.length() <= m * t; i++) {
            sb.append(Integer.toString(i, n));
        }
        
        String num = sb.toString();
        StringBuilder answer = new StringBuilder();
        
        // 2. m명중에 p번째
        int idx = 0;
        int len = num.length();
        while (answer.length() < t) {
            int index = m * idx + p - 1;
            if (index < len) {
                answer.append(num.charAt(index));
            }
            idx++;
        }

        return answer.toString().toUpperCase();
    }
}