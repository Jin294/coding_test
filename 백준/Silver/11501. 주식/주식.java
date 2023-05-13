import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int max = arr[n - 1];
            for (int i = n - 2; i > -1; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                } else if (arr[i] < max) {
                    answer += max - arr[i];
                }
            }
            System.out.println(answer);
        }
    }
}