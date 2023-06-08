import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Spot implements Comparable<Spot>{
        int point;
        int type;

        public Spot(int point, int type) {
            this.point = point;
            this.type = type;
        }

        @Override
        public int compareTo(Spot o) {
            if (this.point == o.point) {
                return this.type - o.type;
            }
            return this.point - o.point;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Spot> spots = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // 시작점은 타입이 1, 끝점은 타입이 0
            spots.add(new Spot(Integer.parseInt(st.nextToken()), 1));
            spots.add(new Spot(Integer.parseInt(st.nextToken()), 0));
        }

        // 오름차순 정렬
        // 시작위치 같으면 끝점이 먼저 오도록
        Collections.sort(spots);

        int answer = 0;
        int conflictCount = 0;
        for (Spot spot : spots) {
            if (spot.type == 1) {
                conflictCount++;
                answer = Math.max(answer, conflictCount);
            } else {
                conflictCount--;
            }
        }

        System.out.println(answer);
    }
}