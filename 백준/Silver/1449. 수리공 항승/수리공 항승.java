import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        boolean[] counts = new boolean[1001];
        for (int i = 0; i < n; i++) {
            counts[(Integer.parseInt(st.nextToken()))] = true;
        }

        int answer = 0;
        for (int i = 1; i <= 1000; i++) {
            if (counts[i]) {
                answer++;
                i += l - 1;
            }
        }
        System.out.println(answer);
    }
}