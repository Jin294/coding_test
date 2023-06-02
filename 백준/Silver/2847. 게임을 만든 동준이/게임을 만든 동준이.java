import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        int max = scores[n - 1];
        int count = 0;
        for (int i = n - 2; i >= 0; i--) {
            // 현재 위치의 값이 최댓값보다 작아질 때 -> 경신
            if (scores[i] < max) {
                max = scores[i];
            }
            // 현재 위치의 값이 최댓값보다 커지거나 같을 때 -> 작아질 때 까지 깎는다
            else {
                count += (scores[i] - max + 1);
                scores[i] = max - 1;
                max = scores[i];
            }
        }
        System.out.println(count);
    }
}