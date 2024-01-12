import java.util.*;

class Solution {
    static Map<String, Integer> nameToNum;
    static int n;
    static int[] parent;
    // enroll : 자식, referral : 부모
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        n = enroll.length;
        // 이름에 인덱스 연결작업
        nameToNum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nameToNum.put(enroll[i], i);
        }
        // 이차원 그래프 구현 및 데이터 넣기
        n = enroll.length;
        
        // i번째 enroll의 부모인덱스
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            // 민호 직속은 생략, 자기 자신의 이름 넣기
            if (referral[i].charAt(0) == '-') {
                referral[i] = enroll[i];
                continue;
            }
            
            // 부모 인덱스위치의 리스트에 자식 이름 넣는다.
            int childIdx = nameToNum.get(enroll[i]);
            int parentIdx = nameToNum.get(referral[i]);
            parent[childIdx] = parentIdx;
        }
        
        
        // seller에 같은 이름이 중복해서 들어있을 수 있기 때문에 더해줘야 한다.
        int[] income = new int[n];
        for (int i = 0; i < seller.length; i++) {
            int idx = nameToNum.get(seller[i]);
            int result = amount[i] * 100;
            int diff = result / 10;
            
            income[idx] += result - diff;
                        
            int parentIdx = parent[idx];
            // seller의 조상찾기
            while(parentIdx != idx) {
                // 조상에게 10% 떼어준다.
                result = diff;
                diff = result / 10;
                income[parentIdx] += result - diff;
                               
                idx = parentIdx;
                parentIdx = parent[parentIdx];
            }
        }

        return income;
    }
}