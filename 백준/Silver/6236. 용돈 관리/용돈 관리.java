import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = max > arr[i] ? max : arr[i];
        }

        // 돈을 가장 많이 쓰는 날 이상의 금액을 인출해야 한다.
        // 그보다 적으면 금액이 부족하기 때문에 계속 인출하게 됨
        int left = max;
        int right = 100_000 * 10_000;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            // 지정한 횟수 이하의 횟수만큼 출금해야 할 때
            // 출금액이 더 적은 경우에 해답이 있는지 탐색해야 한다.
            int withdraw = mid;
            int count = 1;
            for (int i = 0; i < n; i++) {
                withdraw -= arr[i];
                if (withdraw < 0) {
                    count++;
                    withdraw = mid - arr[i];
                }
            }

            // 출금한 횟수가 너무 크다 -> 출금 금액이 적다 -> left up
            if (count > m) {
                left = mid + 1;
            } else { // 출금한 횟수가 작거나 같다 -> 출금 금액이 크다 -> right down
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}