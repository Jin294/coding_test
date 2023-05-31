import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Boolean> isChecked = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            isChecked.put(arr[i], false);
        }

        // a + b = target;
        for (int i = 0; i < n; i++) {
            // 타겟 지정
            int target = arr[i];

            // 이미 계산된 값이면 중복계산 안한다
            if (isChecked.get(target)) {
                visited[i] = true;
                continue;
            }

            // 타겟의 값 하나 감소(0과 만날 경우 대비)
            map.put(arr[i], map.getOrDefault(target, 0) - 1);

            // 메인 알고리즘
            // 앞에서부터 a를 지정
            // a 지정하면 b는 자동으로 나온다 : b = target - a
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int a = arr[j];
                int b = target - a;

                // b가 배열 안에 존재하면서 그 값이 한 개 이상일 때
                if (map.containsKey(b) && map.get(b) > 0) {
                    // 특수한 경우
                    // ex 타겟이 14일 때, a가 7인데 b도 7일때
                    if (a == b) {
                        if (map.get(b) > 1) {
                            visited[i] = true;
                            isChecked.put(target, true);
                            break;
                        }
                    } else { // 일반적인 경우
                        visited[i] = true;
                        isChecked.put(target, true);
                        break;
                    }
                }
            }

            // 타겟의 값 복원
            map.put(arr[i], map.getOrDefault(target, 0) + 1);
        }

        int answer = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]){
                answer++;
            }
        }
        System.out.println(answer);
    }
}