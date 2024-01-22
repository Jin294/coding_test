import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = makeQueue(queue1);
        Queue<Long> q2 = makeQueue(queue2);
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        int len = (queue1.length + queue2.length) * 2;
        int cnt = 0;
        while (sum1 != 0 && sum2 != 0) {
            
            if (sum1 > sum2) {
                long num = q1.poll();
                q2.add(num);
                sum1 -= num;
                sum2 += num;
                cnt++;
            } else if (sum1 < sum2) {
                long num = q2.poll();
                q1.add(num);
                sum2 -= num;
                sum1 += num;
                cnt++;
            } else {
                return cnt;
            }
            
            if (cnt > len) {
                return -1;
            }
        }
        
        return -1;
    }
    
    public Queue<Long> makeQueue(int[] array){
        Queue<Long> result = new LinkedList<>();
        for (int num : array) {
            result.add((long) num);
        }
        
        return result;
    }
}