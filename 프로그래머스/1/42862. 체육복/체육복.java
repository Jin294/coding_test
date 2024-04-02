import java.util.*;
import java.util.stream.*;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    	// 주어진 데이터 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

		// 체육복을 도난당했지만, 여분이 있는 학생들
        // => 참여가능
        Set<Integer> owns = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toSet());
        owns.retainAll(Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet()));

        Queue<Integer> q = new LinkedList<>();
        // 큐 : 체육복을 빌려야 하는 학생들
		for (int l : lost) {
        	q.add(l);
        }

        // 체육복을 빌려야 하는 학생 중 몇 몇에게 빌려줄 수 있는지 센다.
        int get = 0;

        // 여분의 체육복을 가지고 있는 학생들 순회
        for (int r : reserve) {
            // 여분을 가지고 있지만 도난당했다면 패스
            if (owns.contains(r)) {
                continue;
            }

            // 1. 큐가 비어있지 않을 때

            // 2. 1. 체육복을 빌려야 하는 학생들 중 현재 번호가, 여분을 가지고 있는 학생의 바로 앞번호가 아니라면
            // 빌릴 수 없으므로 poll

            // 2. 2. 체육복을 빌려야 하는 학생들 중 현재 번호가 여벌이 있다면
            // == 빌리지 않아도 된다면
            // 굳이 빌리지 않아도 됨
            while (!q.isEmpty() &&
                    (q.peek() < r - 1 || owns.contains(q.peek()))) {
                q.poll();
            }

            // 빌려야 하는 학생이 없다면
            if (q.isEmpty()) break;

            // 현재 번호의 학생이 가장 앞에 있는 학생 r이 빌려줄 수 있는 번호라면
            // == 체육복을 빌려줄 수 있는 번호라면
            // 큐에서 숫자를 빼고, 빌린 학생 수를 증가시킨다.
            if (q.peek() <= r + 1) {
                q.poll();
                get++;
            }
        }
        
        // 전체 학생 수 n
        // 체육복을 도난당한 학생 수 lost.length
        // 체육복을 도난당했지만 여벌 체육복이 있던 학생 수 owns.size()
        // 체육복을 빌린 학생 수 get

        return n - lost.length + owns.size() + get;
    }
}