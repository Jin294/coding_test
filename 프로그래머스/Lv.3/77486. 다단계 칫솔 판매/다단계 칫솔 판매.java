import java.util.*;

class Solution {
    static Map<String, Integer> nameToNum;
    static ArrayList<ArrayList<String>> graph;
    static int n, max;
    static int[] level, parent;
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
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
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
            graph.get(parentIdx).add(enroll[i]);
            parent[childIdx] = parentIdx;
        }
        
        level = new int[n];
        for (int i = 0; i < n; i++) {
            // 직속 부하들에게 다 연결되니까, 직속부하만 DFS 진행
            if (referral[i].equals(enroll[i])) {
                DFS(0, i);
            }
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
    
    public void DFS(int depth, int now) {
        ArrayList<String> list = graph.get(now);
        
        for (int i = 0; i < list.size(); i++) {
            DFS(depth + 1, nameToNum.get(list.get(i)));
        }
        
        level[now] = depth;
        max = Math.max(max, depth);
    }
}