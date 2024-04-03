import java.util.*;
import java.util.stream.*;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    	// 주어진 데이터 정렬 (특별한 언급이 없다면, 정렬이 안되어있다고 생각하자)
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // reserve와 lost를 set으로 바꿔준다.
        Set<Integer> reserveSet = Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet());
            
        // lost의 원소가 reserve에 있다
        // == 여벌이 있지만 도난당했다
        // == 결국 못빌려준다.
        // 따라서 reserve에서 제거해야함.
        Set<Integer> lostSet = new HashSet<>();
        for (int l : lost) {
            if (reserveSet.contains(l)) {
                reserveSet.remove(l);
            } else {
                lostSet.add(l);
            }
        }
        
        // reserveSet의 오름차순 정렬을 위해 pq로 변환
        // (set은 원소간의 순서를 보장하지 않는다구!!)
        PriorityQueue<Integer> reservePQ = new PriorityQueue<>(reserveSet);

        // 여벌이 있는 모든 학생들을 조회하며
        while (!reservePQ.isEmpty()) {
            int now = reservePQ.poll();
            
            // 여벌을 가지고 있는 학생의 앞, 뒤 번호가
            // 도난당한 학생 번호와 일치하는지 확인
            if (lostSet.contains(now - 1)) {
                lostSet.remove(now - 1);
            } else if (lostSet.contains(now + 1)) {
                lostSet.remove(now + 1);
            }
        }

        // 최종적으로 끝내 여벌을 받지 못한 학생들만 제해주면 끝.
        return n - lostSet.size();
    }
}