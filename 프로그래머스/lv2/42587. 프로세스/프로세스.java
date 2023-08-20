import java.util.*;

class Solution {
    class Point {
        char x;
        int pri;
        int loc;
        
        public Point(char x, int pri, int loc) {
            this.x = x;
            this.pri = pri;
            this.loc = loc;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 1. 큐에 넣는다
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Point((char)('A' + i), priorities[i], i));
        }
        
        // 2. 우선순위를 역순으로 정렬한다
        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        
        // 3. 최댓값이 나올때까지 poll 한것을 add하기
        int count = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            
            // 현재 우선순위가 찾는것과 일치한다면
            if (now.pri == priorities[idx]) {
                idx--;
                count++;
                if (now.loc == location) {
                    return count;
                }
            } else {
                // 일치하지 않으면 -> 뽑은거 맨 뒤로 넣어준다.
                q.add(now);
            }
        }
        
        return answer;
    }
}