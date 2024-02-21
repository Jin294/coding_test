import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)  {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        long[] answer = solution(n, arr);
        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1]);
    }

    private static long[] solution(int n, long[] arr) {
        long[] result = new long[2];
        int lt = 0;
        int rt = n - 1;

        long min = Long.MAX_VALUE;

        while (lt < rt) {
            long sum = arr[lt] + arr[rt];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                result[0] = arr[lt];
                result[1] = arr[rt];
            }

            if (sum < 0) {
                lt++;
            } else {
                rt--;
            }
        }

        return result;
    }
}