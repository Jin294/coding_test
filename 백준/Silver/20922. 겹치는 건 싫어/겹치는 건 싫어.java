import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        int[] counts = new int[100_001];

        for (int j = 0; j < n; j++) {
            input[j] = Integer.parseInt(st.nextToken());
        }


        int lt = 0, rt = 0;
        int answer = 0;
        while (rt < n) {
            counts[input[rt]]++;

            while (counts[input[rt]] > k) {
                answer = answer < rt - lt ? rt - lt : answer;
                counts[input[lt]]--;
                lt++;
            }
            rt++;
        }

        answer = answer < rt - lt ? rt - lt : answer;
        System.out.println(answer);
    }
}