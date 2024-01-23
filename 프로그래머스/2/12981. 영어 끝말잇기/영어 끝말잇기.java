import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
                int[] answer = {0, 0};

        Set<String> set = new HashSet<>();
        int len = words.length;
        for (int i = 0; i < words.length - 1; i++) {
            String start = words[i];
            String end = words[i + 1];

            // 이미 사용된 단어인지 검사
            if (!set.add(start)) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                return answer;
            }
            // 끝말잇기 조건이 맞음
            if (start.charAt(start.length() - 1) != end.charAt(0)) {
                answer[0] = (i + 1) % n + 1;
                answer[1] = (i + 1) / n + 1;
                return answer;
            }
        }

        // 마지막단어 검사
        if (!set.add(words[len - 1])) {
            answer[0] = len % n == 0 ? n : len % n;
            answer[1] = len / n;
        }

        return answer;
    }
}