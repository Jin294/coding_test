import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Line> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 시작점 기준으로 오름차순 정렬
        Collections.sort(list);

        int s = list.get(0).start;
        int e = list.get(0).end;
        int len = 0;

        // s - e : 현재 구간
        for (int i = 1; i < n; i++) {
            Line now = list.get(i);
            // 현재 구간을 벗어났을 때
            if (now.start > e) {
                len += e - s;
                s = now.start;
                e = now.end;
            }

            // 현재 구간에 시작점 또는 끝점이 포함될 때
            if (now.start < s) {
                s = now.start;
            }

            if (now.end > e) {
                e = now.end;
            }

        }

        len += e - s;
        System.out.println(len);
    }

    static class Line implements Comparable<Line> {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o) {
            return this.start - o.start;
        }
    }
}