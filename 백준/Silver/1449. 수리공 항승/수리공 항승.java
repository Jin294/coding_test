import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Tape implements Comparable<Tape>{
        int loc;
        double front;
        double rear;

        public Tape(int loc) {
            this.loc = loc;
            this.front = loc - 0.5;
            this.rear = loc + 0.5;
        }

        @Override
        public int compareTo(Tape o) { // 오름차순 정렬
            return this.loc - o.loc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        ArrayList<Tape> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(new Tape(Integer.parseInt(st.nextToken())));
        }
        // 테이프 길이가 1이면 1칸당 테이스 하나씩 붙이면 된다.
        if (l == 1) {
            System.out.println(n);
            return;
        }
        Collections.sort(list);

        int count = 1;
        double left = list.get(0).front;
        double tapeRange = left + l;
        for (int i = 1; i < n; i++) {
            Tape target = list.get(i);
            if (tapeRange < target.rear){ // 현재 지점이 테이프 범위를 벗어남
                count++;
                left = target.front; // 현재 지점의 왼쪽에 연결
                tapeRange = left + l;
            }
        }

        System.out.println(count);
    }
}