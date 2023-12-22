import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int nowh = health;
        int cnt = 0; // 연속횟수 카운트
        int idx = 0;

        for (int i = 0; i <= attacks[attacks.length - 1][0]; i++) {
            // 공격이 이루어지면
            if (i == attacks[idx][0]) {
                cnt = 0;
                nowh -= attacks[idx++][1];
            } else { // 공격받지 않을 때
                if (nowh != health) {
                    cnt++;
                    nowh += bandage[1];
                }
            }
            
            if (cnt == bandage[0]) {
                cnt = 0;
                nowh += bandage[2];
            }
            
            // 체력 조정
            if (nowh <= 0) {
                return -1;
            } else if (nowh >= health) {
                nowh = health;
            }
        }
        
        return nowh;
    }
}