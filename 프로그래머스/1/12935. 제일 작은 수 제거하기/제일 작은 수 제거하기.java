import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        
        // 최솟값과 그 인덱스 찾기
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < arr.length; i++)  {
            if (min > arr[i]) {
                min = arr[i];
                minIdx = i;
            }
        }
        
        // 데이터 옮기기
        int[] answer = new int[arr.length - 1];
        int idx = 0;
        for (int i = 0; i < minIdx; i++) {
            answer[i] = arr[idx++];
        }
        idx++;
        for (int i = minIdx; i < answer.length; i++) {
            answer[i] = arr[idx++];
        }
        return answer;
    }
}