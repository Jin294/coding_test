import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 데이터 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = solution(n, arr);

        // 데이터 출력
        StringBuilder sb = new StringBuilder();
        for (int x : answer) {
            sb.append(x + " ");
        }
        System.out.println(sb);
    }

    private static int[] solution(int n, int[] arr) {
        // 1. 오름차순 정렬
        int[] copy = Arrays.copyOf(arr, n);
        Arrays.sort(copy);

        // 2. 중복 제거 및 순위 할당
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], rank++);
            }
        }

        // 3. 원래 배열의 요소에 대해 순위 할당
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = map.get(arr[i]);
        }

        return result;
    }
}