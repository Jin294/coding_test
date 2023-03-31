import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] aaa = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aaa[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aaa);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if (Arrays.binarySearch(aaa, Integer.parseInt(st.nextToken())) > -1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}