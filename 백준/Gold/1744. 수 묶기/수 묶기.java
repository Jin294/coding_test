import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        // 묶지 않을때의 값
        int noTie = 0;
        for (int item : list) {
            noTie += item;
        }
        // under : 음수 + 0
        // over : 양수
        Queue<Integer> under = new LinkedList<>();
        Queue<Integer> over = new LinkedList<>();

        // 음수 양수 분리
        for (int i = 0; i < n; i++) {
            int num = list.get(i);
            if (num <= 0) {
                under.add(num);
            } else {
                over.add(num);
            }
        }

        // 묶었을 때의 합
        int tie = 0;

        // 오름차순 정렬 -> 음수는 절댓값 제일 큰 것부터 나온다
        while (under.size() > 1) {
            int one = under.poll();
            int two = under.poll();

            tie += one * two;
        }

        // 음수 하나 남으면 그냥 더해주면 됨.
        if (under.size() == 1) {
            tie += under.poll();
        }

        // 오름차순 정렬
        // 1이 있다면 제일 처음 값이 1, 그냥 더해주면 됨
        while (!over.isEmpty() && over.peek() == 1){
            tie++;
            over.poll();
        }

        // 홀수개면 미리 뽑아서 더해준다
        if (over.size() % 2 == 1) {
            tie += over.poll();
        }

        // 양수 큐가 빌 때 까지 다 묶어준다.
        while (!over.isEmpty()) {
            int one = over.poll();
            int two = over.poll();

            tie += one * two;
        }

        // 묶었을 때와 그러지 않았을 때의 값 비교해서 더 큰 것 출력
        if (noTie < tie) {
            System.out.println(tie);
        } else {
            System.out.println(noTie);
        }

    }
}