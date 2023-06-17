import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Country implements Comparable<Country>{
        int id;
        int score;

        public Country(int id, int score) {
            this.id = id;
            this.score = score;
        }


        @Override
        public int compareTo(Country o) {
            return o.score - this.score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Country> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken()) * 3 +
                    Integer.parseInt(st.nextToken()) * 2 +
                    Integer.parseInt(st.nextToken());
            pq.add(new Country(id, score));
        }

        int grade = 0;
        int score = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Country target = pq.poll();
            if (score > target.score) {
                grade++;
            }

            if (target.id == k) {
                System.out.println(grade);
                return;
            }
            score = target.score;
        }
    }
}