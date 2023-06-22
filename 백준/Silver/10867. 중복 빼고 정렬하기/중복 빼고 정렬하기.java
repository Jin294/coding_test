import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] counts = new boolean[2002];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            counts[1000 + Integer.parseInt(st.nextToken())] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2002; i++) {
            if (counts[i])
                sb.append((i - 1000) + " ");
        }
        System.out.println(sb);
    }
}