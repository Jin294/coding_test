import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 데이터 입력
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(br.readLine());
            int[] apples = new int[j];
            for (int i = 0; i < j; i++) {
                apples[i] = Integer.parseInt(br.readLine());
            }

            int left = 1;
            int right = m;

            int answer = 0;
            for (int i = 0; i < apples.length; i++) {
                if (apples[i] >= left && apples[i] <= right) continue;

                if (apples[i] < left) {
                    answer += left - apples[i];
                    left = apples[i];
                    right = left + m - 1;
                } else if (apples[i] > right) {
                    answer += apples[i] - right;
                    right = apples[i];
                    left = right - m + 1;
                }
            }
            System.out.println(answer);
        };
    }
}