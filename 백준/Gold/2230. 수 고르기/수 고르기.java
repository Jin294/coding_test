import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int e = 0;
        int min = Integer.MAX_VALUE;
        for (int s = 0; s < n; s++) {
            // 차이가 m이하라면 계속 e 증가
            while (e < n && arr[e] - arr[s] < m) {
                e++;
            }

            if (e == n) {
                break;
            }
            min = Math.min(min, arr[e] - arr[s]);
        }
        System.out.println(min);
    }
}