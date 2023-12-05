import java.util.*;

class Solution {
    static int n, m, recruit, profit;
    static int[] discount;
    public int[] solution(int[][] users, int[] emoticons) {
        n = users.length;
        m = emoticons.length;
        discount = new int[m];
        
        // DFS-순열 로 할인율 조절
        DFS(0, users, emoticons);
        
        return new int[]{recruit, profit};
    }
    
    public void DFS(int depth, int[][] users, int[] emoticons) {
        if (depth == m) {
            calc(users, emoticons);
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            discount[depth] = i;
            DFS(depth + 1, users, emoticons);
        }
    }
    
    public void calc(int[][] users, int[] emoticons) {
        // 서비스 가입자
        int cnt = 0;
        // 최종 매출액
        int sum = 0;
        // 사용자 목록
        for (int i = 0; i < n; i++) {
            // 한 사용자가 이모티콘을 구매하는지
            int tmpSum = 0;
            for (int j = 0; j < m; j++) {
                if (discount[j] >= users[i][0]) {
                    tmpSum += ((100 - discount[j]) * emoticons[j]) / 100;
                }
            }
           
            // 한 사용자의 이모티콘 구매 비용이 예산을 넘는다면
            if (tmpSum >= users[i][1]) {
                cnt++;
            } else {
                sum += tmpSum;
            }

        }
        
        // 현재 할인율의 서비스 가입자 수가 기록된 서비스 가입자 수보다 높다면
        if (cnt > recruit) {
            recruit = cnt;
            profit = sum;
        } else if (cnt == recruit) { // 가입자수 같아도 매출 높으면 최고매출액 갱신
            profit = Math.max(profit, sum);
        }
    }
}