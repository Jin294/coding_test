import java.util.*;

class Solution {
    static Queue<int[]> q = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        int sum = 0;
        for(int i = 0; i < truck_weights.length; i++) {
            while(true) {
                if(q.isEmpty()) {
                    q.offer(truck_weights[i]);
                    sum += truck_weights[i];
                    time++;
                    break;
                } else if(q.size() == bridge_length) {
                    sum -= q.poll();
                } else {
                    if(sum + truck_weights[i] > weight) {
                        q.offer(0);
                        time++;
                    } else {
                        q.offer(truck_weights[i]);
                        sum += truck_weights[i];
                        time++;
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}