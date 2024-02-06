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

        // 2. 중복 제거
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 || copy[i - 1] != copy[i]) {
                list.add(copy[i]);
            }
        }

        // 3. 원래 배열의 요소에 대해 순위 할당
        int[] uniqueNum = list.stream().mapToInt(x -> x).toArray();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Arrays.binarySearch(uniqueNum, arr[i]);
        }

        return result;
    }
}