import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {        
        PriorityQueue<Integer> pq = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        
        int count = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            pq.add(pq.poll() + pq.poll() * 2);
            count++;
        }
        
        if (pq.poll() < K) {
            return -1;
        }
        
        return count;
    }
}