import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; sb.length() <= m * t; i++) {
            sb.append(Integer.toString(i, n));
        }
        
        String num = sb.toString();
        StringBuilder answer = new StringBuilder();
        
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