import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Task {
    int pg;
    int speed;
    
    public Task (int pg, int speed) {
        this.pg = pg;
        this.speed = speed;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Task> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(new Task(progresses[i], speeds[i]));
        }

        while (!q.isEmpty()) {
            for (Task now : q) {
                if (now.pg < 100) {
                    now.pg += now.speed;
                }
            }

            int count = 0;
            while (!q.isEmpty() && q.peek().pg >= 100) {
                count++;
                q.poll();
            }

            if (count > 0) {
                list.add(count);
                count = 0;
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}