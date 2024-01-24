import  java.util.*;

class Solution {
    static final int LEN = 11;
    static int maxDiff;
    static int[] answer = {-1};
    public int[] solution(int n, int[] info) {
        int[] ryan = new int[LEN];
        DFS(0, n, info, ryan);

        return answer;
    }
    
    public boolean isRyanBetter(int[] ryan) {
        for (int i = LEN - 1; i >= 0; i--) {
            if (answer[i] > ryan[i]) {
                return false;
            } else if (answer[i] < ryan[i]){
                return true;
            }
        }

        return false;
    }

    public void calcScore(int[] apeach, int[] ryan) {
        int apeachScore = 0, ryanScore = 0;
        for (int i = 0; i < LEN; i++) {
            int score = 10 - i;
            if (apeach[i] > ryan[i]) {
                apeachScore += score;
            } else if (apeach[i] < ryan[i]){
                ryanScore += score;
            }
        }

        int diff = ryanScore - apeachScore;

        // 현재 차이값이 최대 차이값보다 같다면
        // answer 배열이 가장 낮은 점수를 고려했는지 살펴봐야 한다.
        if (diff > 0 && diff >= maxDiff) {
            if (maxDiff == diff && !isRyanBetter(ryan)) {
                return;
            }
            maxDiff = diff;
            answer = Arrays.copyOf(ryan, LEN);
        }
    }

    public void DFS(int idx, int arrows, int[] apeach, int[] ryan) {
        // 인덱스 끝까지 도달했을 때, 또는 화살이 다 떨어졌을 때
        if (idx == LEN || arrows == 0) {
            // 남은 화살은 모두 0점 과녁에 몰아준다
            ryan[LEN - 1] += arrows;
            calcScore(apeach, ryan);

            // 0점에 몰아준 화살 복구
            ryan[LEN - 1] -= arrows;
            return;
        }

        // 해당 영역에 화살을 쏘자
        if (apeach[idx] < arrows) {
            // 어피치보다 많아야 해당 구역의 점수를 얻을 수 있음.
            ryan[idx] += apeach[idx] + 1;
            DFS(idx + 1, arrows - (apeach[idx] + 1), apeach, ryan);
            ryan[idx] -= apeach[idx] + 1;
        }

        // 해당 영역에 화살을 쏘지 말자
        DFS(idx + 1, arrows, apeach, ryan);
    }
}