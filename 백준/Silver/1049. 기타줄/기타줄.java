import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int minP = arr[0][0];
        int minS = arr[0][1];

        for (int i = 0; i < m; i++) {
            minP = minP > arr[i][0] ? arr[i][0] : minP;
            minS = minS > arr[i][1] ? arr[i][1] : minS;
        }

        int answer = 0;
        if (minP < minS * 6) {
            if (n % 6 == 0) {
                answer = minP * (n / 6);
            } else {
                answer = minP * (n / 6) + Math.min(minS * (n % 6), minP);
            }
        } else {
            answer = minS * n;
        }

        System.out.println(answer);
    }
}