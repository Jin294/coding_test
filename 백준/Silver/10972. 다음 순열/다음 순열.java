import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = n - 1;
        while (idx > 0 && arr[idx - 1] >= arr[idx]) {
            idx--;
        }

        if (idx == 0) {
            System.out.println(-1);
            return;
        }

        int big_idx = n - 1;
        while (big_idx > 0 && arr[idx - 1] >= arr[big_idx]) {
            big_idx--;
        }

        int tmp = arr[idx - 1];
        arr[idx - 1] = arr[big_idx];
        arr[big_idx] = tmp;

        Arrays.sort(arr, idx, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}