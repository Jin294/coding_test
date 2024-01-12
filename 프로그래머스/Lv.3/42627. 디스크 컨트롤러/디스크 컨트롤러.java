import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 두 가지 기준으로 각각 정렬
        PriorityQueue<int[]> byStart = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> byElapsed = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // 시작시점 기준으로 정렬되도록 데이터를 삽입한다.
        for (int[] job : jobs) {
            byStart.add(job);
        }
        
        int now = 0;
        int sum = 0;
        
        while (!byStart.isEmpty() || !byElapsed.isEmpty()) {
            // 시작시점이 제일 앞선것부터 현 시각과 비교 후, 소요시간 순으로 정렬
            while (!byStart.isEmpty() && byStart.peek()[0] <= now) {
                byElapsed.offer(byStart.poll());
            }

            if (byElapsed.isEmpty()) {
                // 시작할 수 있는 일이 없다면
                // 현재시각 보정
                now = byStart.peek()[0];
            } else {
                // 시작할 수 있는 일이 있다면
                int[] job = byElapsed.poll();

                sum += now + job[1] - job[0];
                now += job[1];
            }
        }
        
        return sum / jobs.length;
    }
}