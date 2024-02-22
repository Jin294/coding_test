import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(n, arr));
        }
    }

    public static long solution(int n, int[] arr) {
        long answer = 0;

        int max = arr[n - 1];

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
            } else {
                answer += max - arr[i];
            }
        }

        return answer;
    }
}