import java.util.*;

class Solution {
    static Map<String, Integer> nameToIndex;
    static int[] parent, income;
    // enroll : 자식, referral : 부모
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        
        nameToIndex = new HashMap<>();
        parent = new int[n];
        income = new int[n];
        
        // i번째 enroll의 부모인덱스를 셋
        // 부모가 민호인 경우는 자기 자신의 인덱스를 넣는다.
        for (int i = 0; i < n; i++) {
            nameToIndex.put(enroll[i], i);
            parent[i] = referral[i].equals("-") ? i : nameToIndex.get(referral[i]);            
        }
        
        for (int i = 0; i < seller.length; i++) {
            calcIncome(nameToIndex.get(seller[i]), amount[i] * 100);
        }

        return income;
    }
    
    public void calcIncome(int index, int amount) {
        int commission = amount / 10;
        income[index] += amount - commission;
        
        if (parent[index] != index && commission > 0) {
            calcIncome(parent[index], commission);
        }
    }
}