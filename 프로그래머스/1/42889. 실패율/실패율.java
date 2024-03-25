import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] total = new int[N + 1]; // 스테이지에 도달한 플레이어 수
        int[] now = new int[N + 1]; // 스테이지에 도달했지만 아직 클리어하지 못한 플레이어의 수
        
        for (int i = 0; i < stages.length; i++) {
            for (int j = 0; j <= stages[i]; j++) {
                if (j <= N) {
                    total[j]++;
                }
            }
            
            if (stages[i] <= N)  {
                now[stages[i]]++;
            }
        }
        
        // 스테이지 별 실패율
        double[][] ratio = new double[N + 1][2];
        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = total[i] > 0 ? now[i] / (double) total[i] : 0;
        }
        
        // 편의를 위해 넣음
        // 실패율이 0과 같을 경우를 대비해
        // 가능한 수들 중 제일 큰 수를 넣어 제일 마지막에 정렬되게 함.
        ratio[0][0] = N + 1;
        
        // 실패율이 높은 스테이지부터 내림차순
        // 실패율이 같으면 스테이지 번호 오름차순
        Arrays.sort(ratio, new Comparator<double[]>(){
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] < o2[0] ? -1 : 1;
                }
                return o1[1] < o2[1] ? 1 : -1;
            }
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) ratio[i][0];
        }
        
        return answer;
    }
}