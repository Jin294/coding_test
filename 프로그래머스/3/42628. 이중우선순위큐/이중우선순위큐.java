import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] ss = operations[i].split(" ");
            char order = ss[0].charAt(0);
            int num = Integer.parseInt(ss[1]);
                        
            if (order == 'I') {
                maxq.add(num);
            } else {
                if (num == 1) {
                    while (!minq.isEmpty()) {
                        maxq.add(minq.poll());
                    }
                    
                    maxq.poll();
                } else if (num == -1) {
                    while (!maxq.isEmpty()) {
                        minq.add(maxq.poll());
                    }
                    
                    minq.poll();
                }
            }
        }
        int max = 0;
        int min = 0;
        
        if (!minq.isEmpty()) {
            min = minq.peek();
            
            while(!minq.isEmpty()) {
                maxq.add(minq.poll());
            }
            max = maxq.peek();
        } else if (!maxq.isEmpty()) {
            max = maxq.peek();
            
            while(!maxq.isEmpty()) {
                minq.add(maxq.poll());
            }
            min = minq.peek();
        }
        
        return new int[]{max, min};
    }
    
}