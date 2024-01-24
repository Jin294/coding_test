import  java.util.*;

class Solution {
    static final int LEN = 11;
    static int diff;
    static int[] answer, apeach, ryan;
    public int[] solution(int n, int[] info) {
        // 이길 수 없는 경우의 리턴배열
        int[] lose = {-1};

        // 라이언 점수배열 전역화
        apeach = info;
        ryan = new int[LEN];
        answer = new int[LEN];

        DFS(0, n, 0, 0);

        return diff == 0 ? lose : answer;
    }
    
    // idx : 인덱스, 10 - idx 번째 점수를 얻기 위한 화살개수
    // arrow : 잔여화살 개수
    // aSum : 어피치의 점수합계
    // rSum : 라이언의 점수합계
    public void DFS(int idx, int arrow, int aSum, int rSum) {
        // 화살이 다 떨어졌을 때
        if (arrow < 0) {
            return;
        }

        // 인덱스 끝까지 도달했을 때
        // 또는 준비한 화살이 떨어졌을 때
        if (idx == LEN) {
            // 라이언의 점수가 어피치보다 높고
            // 이전까지의 최댓값을 경신할 수 있을 때
            if (aSum < rSum && diff <= rSum - aSum) {
                // 아직 화살이 남아있다면 -> 0점에 몰아주자
                if (arrow > 0) {
                    ryan[LEN - 1] += arrow;
                }

                if (diff == rSum - aSum) {
                    answer = getLowestArray(answer, ryan);
                } else {
                    diff = rSum - aSum;
                    answer = Arrays.copyOf(ryan, LEN);
                }
            }
            return;
        }


        // 해당 점수를 얻기 위한 화살개수
        // 어피치보다 많이 맞혀야 점수획득이 가능하다.
        int need2Gain = apeach[idx] + 1;
        ryan[idx] = need2Gain;

        // (10 - idx) 의 점수를 얻을 수 있을 때,
        int score = 10 - idx;
        DFS(idx + 1, arrow - need2Gain, aSum, rSum + score);

        // (10 - idx) 의 점수를 얻을 수 없을 때,
        ryan[idx] = 0;
        DFS(idx + 1, arrow, apeach[idx] == 0 ? aSum : aSum + score, rSum);
    }
    
    public int[] getLowestArray(int[] a, int[] b) {
        long aString = scoringReverse(a);
        long bString = scoringReverse(b);

        return aString > bString ? Arrays.copyOf(a, LEN) : Arrays.copyOf(b, LEN);
    }

    public long scoringReverse(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = LEN - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        return Long.parseLong(sb.toString());
    }
}