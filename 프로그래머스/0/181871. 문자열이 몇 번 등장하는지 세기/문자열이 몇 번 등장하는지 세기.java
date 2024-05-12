import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        int idx = myString.indexOf(pat);
        
        while (idx != -1) {
            answer++;
            myString = myString.substring(idx + 1);
            idx = myString.indexOf(pat);
        }
        
        return answer;
    }
}