import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Board implements Comparable<Board>{
        int s, e;

        public Board(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Board o) {
            if (this.s == o.s) 
                return this.e - o.e;
            return this.s - o.s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        PriorityQueue<Board> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Board(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        int answer = 0; // 널빤지 개수
        int range = 0; // 널빨지로 물 웅덩이를 덮고있는 범위
        
        while (!pq.isEmpty()) {
            Board target = pq.poll();
            if (target.s > range) {
                range  = target.s;
            }

            if (target.e < range) {
                continue;
            }

            int remain = (target.e - range) % l;
            answer += (target.e - range) / l;
            range = target.e;
            if (remain != 0) {
                answer++;
                range += l - remain;
            }
        }

        System.out.println(answer);
    }
}