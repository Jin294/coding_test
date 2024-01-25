import java.util.*;

class Solution {
    public int solution(int[] a) {
        // 카운팅정렬(=계수정렬) : 원소의 개수를 해당 원소와 일치하는 인덱스에 저장한다.
        int[] count = new int[a.length];
        for (int num : a) {
            count[num]++;
        }
                
        int answer = 0;
        
        for (int i = 0; i < a.length; i++) {
            // i가 한번도 사용되지 않았거나, answer보다 적거나 같게 사용되었다면 패스
            if (count[i] == 0 || count[i] <= answer) {
                continue;
            }
            
            int len = 0;
            for (int j = 0; j < a.length - 1; j++) {
                // 교집합 여부 검사
                if (a[j] != i && a[j + 1] != i) {
                    continue;
                }
                
                // 집합 내 숫자들이 서로 다른지 검사
                if (a[j] == a[j + 1]) {
                    continue;
                }
                
                len++;
                j++;
            }
            
            answer = Math.max(answer, len);
        }
        
        return answer * 2;
    }
}