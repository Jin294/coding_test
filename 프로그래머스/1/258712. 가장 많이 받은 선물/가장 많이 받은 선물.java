import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    int len;
    int[] score;
    int[][] matrix;
    public int solution(String[] friends, String[] gifts) {
        len = friends.length;
        // 친구 이름과 숫자 연결
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        
        // 선물기록을 표로 정리
        matrix = new int[len][len];
        for (String gift : gifts) {
            String[] record = gift.split(" ");
            int from = map.get(record[0]);
            int to = map.get(record[1]);
            
            matrix[from][to]++;
        }
        
        // 선물지수 계산
        int[] score = new int[len];
        for (int i = 0; i < len; i++) {
            score[i] = presentTo(friends[i]) - presentFrom(friends[i]);
        }
        
        // 최종 선물 계산
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((matrix[i][j] == 0 && matrix[j][i] == 0) || (matrix[i][j] == matrix[j][i])) { // 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면
                    // 선물지수 같다면 패스
                    if (score[i] == score[j]) {
                        continue;
                    }
                    
                    // 선물지수가 큰 쪽이 선물을 하나 받음
                    int idx = score[i] > score[j] ? i : j;
                    answer[idx]++;
                } else if (matrix[i][j] != 0 || matrix[j][i] != 0) { // 두 사람이 선물을 주고받은 기록이 있다면
                    // 더 많은 선물을 준 사람이 선물을 하나 받음
                    int idx = matrix[i][j] > matrix[j][i] ? i : j;
                    answer[idx]++;
                }
            }
        }
        
        return Arrays.stream(answer).max().getAsInt();
    }
    
    public int presentTo(String x) {
        return Arrays.stream(matrix[map.get(x)]).sum();
    }
    
    public int presentFrom(String x) {
        int sum = 0;
        int idx = map.get(x);
        for (int i = 0; i < len; i++) {
            sum += matrix[i][idx];
        }
        
        return sum;
    }
}