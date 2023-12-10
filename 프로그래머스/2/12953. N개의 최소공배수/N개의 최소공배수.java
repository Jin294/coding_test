import java.util.*;

class Solution {
    public int solution(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : arr) {
            pq.add(x);
        }
        
        while (pq.size() != 1) {
            int a = pq.poll();
            int b = pq.poll();
            
            pq.add(LCM(a, b));
        }
        
        return pq.poll();
    }
    
    public int LCM(int a, int b) {
        return a / GCM(a, b) * b;
    }
    
    public int GCM(int a, int b) {
        return b == 0 ? a : GCM(b, a % b);
    }
}